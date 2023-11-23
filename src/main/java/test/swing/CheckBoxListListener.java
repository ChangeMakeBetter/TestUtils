package test.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JList;

public class CheckBoxListListener implements ItemListener {
  private JList<?> list;

  public CheckBoxListListener(JList<?> list) {
    this.list = list;
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == ItemEvent.SELECTED) {
      // 处理选中状态
    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
      // 处理取消选中状态
    }
  }
}
