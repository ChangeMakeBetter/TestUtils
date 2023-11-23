package test.swing;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

public class JListWithCheckBoxExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JList with CheckBox Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DefaultListModel<JCheckBox> model = new DefaultListModel<>();
    model.addElement(new JCheckBox("Item 1"));
    model.addElement(new JCheckBox("Item 2"));
    model.addElement(new JCheckBox("Item 3"));
    model.addElement(new JCheckBox("Item 4"));
    model.addElement(new JCheckBox("Item 5"));

    JList<JCheckBox> list = new JList<>(model);
    list.setCellRenderer(new CheckBoxListCellRenderer());
    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    list.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent event) {
        JList<JCheckBox> list = (JList<JCheckBox>) event.getSource();
        int index = list.locationToIndex(event.getPoint());
        if (index >= 0) {
          JCheckBox checkBox = list.getModel().getElementAt(index);
          checkBox.setSelected(!checkBox.isSelected());
          list.repaint();
        }
      }
    });

    JScrollPane scrollPane = new JScrollPane(list);
    frame.getContentPane().add(scrollPane);

    frame.pack();
    frame.setVisible(true);
  }

  static class CheckBoxListCellRenderer implements ListCellRenderer<JCheckBox> {
    @Override
    public Component getListCellRendererComponent(JList<? extends JCheckBox> list, JCheckBox value, int index,
      boolean isSelected, boolean cellHasFocus) {
      value.setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
      value.setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
      value.setEnabled(list.isEnabled());
      value.setFont(list.getFont());
      value.setFocusPainted(false);
      value.setBorderPainted(true);
      return value;
    }
  }
}
