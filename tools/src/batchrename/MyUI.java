package batchrename;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class MyUI extends JFrame {
  private static final long serialVersionUID = 1711686087612595940L;

  public static final String BUTTON_COMMAND_LIST = "列举数量";
  public static final String BUTTON_COMMAND_RENAME = "重命名";
  public static final String BUTTON_COMMAND_COPY = "复制并新建";
  public static final String BUTTON_COMMAND_REMOVE = "删除";

  JPanel body = new JPanel();//主体面板

  JLabel parentDirLabel = new JLabel("请点击右下方的\"浏览\"并选择一个父目录");
  JTextField parentDirField = new JTextField();
  JButton fileChooserButton = new JButton("浏览");

  JLabel matchRegExLabel = new JLabel("请输入匹配模式(拓展名在此处和后面均可设置)");
  JTextField matchRegExField = new JTextField();
  JLabel matchRegExGuide = new JLabel("<html><style>span{color:red}</style>" +
    "<br/>关于匹配模式(严格遵循Java正则表达式规范)的说明：<br/>" +
    "<p style='font-size:15'>1、<span>?</span>表示零到一个，<span>*</span>表示零到多个，<span>+</span>表示一到多个，<span>.</span>表示任意单个字符，如："
    +
    "<span>刘.+</span>可以匹配所有姓刘的。<br/>" +
    "2、<span>.*</span>表示匹配任意长度的字符串。</p></html>");

  JLabel renameGuide = new JLabel("<html><br><hr/>命名格式为：<br/>" +
    "<p style='font-size:15'>[原名](可无)+[定名部分](可无)+[自动编号部号]+[拓展名部分]</p><br/>" +
    "具体设置如下：</br></br></html>");
  //  JLabel saveNameLabel = new JLabel("原名是否保留");
  //  JSpinner saveNameSpinner = new JSpinner(new SpinnerListModel(new String[] { "是", "否" }));
  JLabel constNameLabel = new JLabel("修改部分修改为");
  JTextField constNameField = new JTextField();
  JLabel beginIndexLabel = new JLabel("修改的组");
  JSpinner beginIndexSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
  JLabel extNameLabel = new JLabel("拓展名(必填)");
  JTextField extNameField = new JTextField();

  JButton listCountButton = new JButton(BUTTON_COMMAND_LIST);
  JButton copyAndNewButton = new JButton(BUTTON_COMMAND_COPY);
  JButton renameButton = new JButton(BUTTON_COMMAND_RENAME);
  JButton removeButton = new JButton(BUTTON_COMMAND_REMOVE);

  JTable resultTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "原文件名", "新文件名" }));
  JScrollPane resultTableContainer = new JScrollPane(resultTable);//参数为view(Pane显示的内容)

  Insets noneBorder = new Insets(2, 5, 2, 5);
  //Insets rightBorder=new Insets(5,5,5,5);

  JLabel background = new JLabel();

  public MyUI() {
    setBounds(500, 20, 1000, 1000);
    setTitle("文件批量重命名");
    setContentPane(body);//设置当前窗口的主体
    //    background.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
    getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));//注意：此处必须用Integer,不能用int!否则会显示异常

    //默认值
    parentDirField.setText("D:\\upgradeSchema\\v30r02");
    matchRegExField.setText("^[\\s\\S]+.(oracle|Oracle).sql$");
    constNameField.setText("polardb");
    extNameField.setText(".sql");
    beginIndexSpinner.setValue(1);

    body.setOpaque(false);
    body.setLayout(new GridBagLayout());//给主体面板设置布局(注意：要先指定，后面才能用！)

    body.add(parentDirLabel, new GridBagConstraints(0, 0, 4, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(parentDirField, new GridBagConstraints(0, 1, 3, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(fileChooserButton, new GridBagConstraints(3, 1, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    //parentDirLabel.setFont(new Font("微软雅黑",Font.PLAIN,20));

    body.add(matchRegExLabel, new GridBagConstraints(0, 2, 4, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(matchRegExField, new GridBagConstraints(0, 3, 2, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(matchRegExGuide, new GridBagConstraints(0, 4, 4, 1, 0, 0, 10, 1, noneBorder, 0, 0));

    body.add(renameGuide, new GridBagConstraints(0, 5, 4, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    //    body.add(saveNameLabel, new GridBagConstraints(0, 6, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(constNameLabel, new GridBagConstraints(1, 6, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(beginIndexLabel, new GridBagConstraints(2, 6, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));

    body.add(extNameLabel, new GridBagConstraints(3, 6, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    //    body.add(saveNameSpinner, new GridBagConstraints(0, 7, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(constNameField, new GridBagConstraints(1, 7, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(beginIndexSpinner, new GridBagConstraints(2, 7, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(extNameField, new GridBagConstraints(3, 7, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));

    body.add(listCountButton, new GridBagConstraints(0, 8, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(copyAndNewButton, new GridBagConstraints(1, 8, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(renameButton, new GridBagConstraints(2, 8, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    body.add(removeButton, new GridBagConstraints(3, 8, 1, 1, 0, 0, 10, 1, noneBorder, 0, 0));

    body.add(resultTableContainer, new GridBagConstraints(0, 9, 4, 1, 0, 0, 10, 1, noneBorder, 0, 0));
    resultTable.setRowHeight(30);//设置表格行的行高
    resultTable.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置表格的字体

    fileChooserButton.addActionListener(new FileChooserButtonListener(this));
    ActionButtonListener actionButtonListener = new ActionButtonListener(this);
    renameButton.addActionListener(actionButtonListener);
    listCountButton.addActionListener(actionButtonListener);
    copyAndNewButton.addActionListener(actionButtonListener);
    removeButton.addActionListener(actionButtonListener);
  }
}