package batchrename;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import file.FileUtils;

public class ActionButtonListener implements ActionListener {
  MyUI myUI;

  public ActionButtonListener(MyUI myUI) {
    this.myUI = myUI;
  }

  public void rename(String matchRegEx, String extName, String actionCommand) throws IOException {
    DefaultTableModel tableModel = (DefaultTableModel) myUI.resultTable.getModel();
    tableModel.setRowCount(0);
    File parentDir = new File(myUI.parentDirField.getText());

    File[] matchedFiles = getMatchedFiles(parentDir, matchRegEx, extName);
    if (matchedFiles == null) {
      return;
    }

    //    boolean saveOldName = "是".equals(myUI.saveNameSpinner.getValue());
    int needReplaceGroup = (int) myUI.beginIndexSpinner.getValue();

    String exchangeName = myUI.constNameField.getText();
    if (exchangeName == null || "".equals(exchangeName)) {
      return;
    }
    Pattern p = Pattern.compile(matchRegEx);

    int count = 0;
    for (File oldFile : matchedFiles) {
      String oldName = oldFile.getName(), newName = "";
      Matcher m = p.matcher(oldFile.getName());
      String needReplace = "";
      if (m.find()) {
        needReplace = m.group(needReplaceGroup);
      }

      String prefix = oldName.substring(0, oldName.indexOf(needReplace));
      String suffix = oldName.substring(oldName.indexOf(needReplace) + needReplace.length());

      newName += prefix + exchangeName + suffix;

      if (MyUI.BUTTON_COMMAND_RENAME.equals(actionCommand)) {
        File newFile = new File(oldFile.getParent(), newName);
        oldFile.renameTo(newFile);
        tableModel.addRow(new String[] { newFile.getAbsolutePath(), newName });
        count++;
      } else if (MyUI.BUTTON_COMMAND_COPY.equals(actionCommand)) {
        File newFile = new File(oldFile.getParent(), newName);
        FileUtils.copyFile(oldFile, newFile);
        tableModel.addRow(new String[] { oldFile.getAbsolutePath(), newName });
        count++;
      } else if (MyUI.BUTTON_COMMAND_REMOVE.equals(actionCommand)) {
        oldFile.delete();
        tableModel.addRow(new String[] { "删除", oldFile.getAbsolutePath() });
        count++;
      } else if (MyUI.BUTTON_COMMAND_LIST.equals(actionCommand)) {
        count++;
      } else {
      }

    }
    tableModel.addRow(new String[] { "执行个数", String.valueOf(count) });
  }

  private class MyFile {
    File file;
    String parentDir;
  }

  private File[] getMatchedFiles(File parentDir, String matchRegEx, String extName) {
    List<File> matchedFiles = new ArrayList<>();
    File[] dirs = parentDir.listFiles(File::isDirectory);
    if (dirs != null) {
      for (File dir : dirs) {
        File[] matchedFilesInDir = getMatchedFiles(dir, matchRegEx, extName);
        matchedFiles.addAll(Arrays.asList(matchedFilesInDir));
      }
    }
    File[] matchFileArray = parentDir.listFiles(new MyFileFilter(matchRegEx,
      extName));
    if (matchFileArray != null) {
      matchedFiles.addAll(Arrays.asList(matchFileArray));
    }
    return matchedFiles.toArray(new File[0]);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      String matchRegEx = myUI.matchRegExField.getText() == null ? "" : myUI.matchRegExField.getText();
      String extName = myUI.extNameField.getText() == null ? "" : myUI.extNameField.getText();
      if (matchRegEx.length() == 0) {
        JOptionPane.showMessageDialog(myUI, "请输入匹配模式");
      } else if (extName.length() == 0) {
        JOptionPane.showMessageDialog(myUI, "请输入拓展名");
      } else {
        if (extName.charAt(0) != '.') {
          extName = '.' + extName;//不管用户输入的拓展名是否以点开头,最终都是点开头
        }
        rename(matchRegEx, extName, e.getActionCommand());
      }
    } catch (Exception err) {
      System.out.println("error:" + err.getMessage());
    }

  }
}