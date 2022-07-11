package batchrename;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserButtonListener implements ActionListener {
  MyUI myUI;

  public FileChooserButtonListener(MyUI myUI) {
    this.myUI = myUI;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只显示目录,不显示文件
    fileChooser.setPreferredSize(new Dimension(1200, 800));//设置文件选择器窗口的大小
    if (fileChooser.showOpenDialog(myUI) == JFileChooser.APPROVE_OPTION) {//必须要有showOpenDialog(myUI),否则不显示
      myUI.parentDirField.setText(fileChooser.getSelectedFile().toString());
    }
  }
}