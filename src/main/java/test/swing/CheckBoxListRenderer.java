package test.swing;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CheckBoxListRenderer extends JCheckBox implements ListCellRenderer<Object> {
  private static final long serialVersionUID = 8516398418306834310L;

  @Override
  public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
    boolean cellHasFocus) {
    // 设置文本
    setText(value.toString());

    // 根据选择状态设置复选框的选中状态
    setSelected(isSelected);

    // 根据焦点状态设置外观
    if (cellHasFocus) {
      // 设置获得焦点时的外观
    } else {
      // 设置失去焦点时的外观
    }

    return this;
  }
}
