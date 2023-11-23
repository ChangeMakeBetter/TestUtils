package test.swing;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

public class JListWithCheckBoxAndPanelExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JList with CheckBox Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DefaultListModel<MyData> model = new DefaultListModel<>();
    model.addElement(new MyData("Item 1", true));
    model.addElement(new MyData("Item 2", true));
    model.addElement(new MyData("Item 3", true));
    model.addElement(new MyData("Item 4", true));
    model.addElement(new MyData("Item 5", true));

    JList<MyData> list = new JList<>(model);
    list.setCellRenderer(new CheckBoxListCellRenderer());
    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    //    list.addListSelectionListener(e -> {
    //      list.repaint(); // Update the cell renderers to reflect selection changes
    //    });

    JScrollPane scrollPane = new JScrollPane(list);
    frame.getContentPane().add(scrollPane);

    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
  }

  static class MyData {
    private String title;
    private boolean selected;

    public MyData(String title, boolean selected) {
      this.title = title;
      this.selected = selected;
    }

    public String getTitle() {
      return title;
    }

    public boolean isSelected() {
      return selected;
    }

    public void setSelected(boolean selected) {
      this.selected = selected;
    }
  }

  static class CheckBoxListCellRenderer extends JPanel implements ListCellRenderer<MyData> {
    private static final long serialVersionUID = 7675988404074502046L;

    public CheckBoxListCellRenderer() {
      setOpaque(true);
      createUI();
    }

    private JPanel productInfoPanel;
    private JCheckBox checkBox;

    private void createUI() {
      productInfoPanel = new JPanel();
      GridBagConstraints c = new GridBagConstraints();
      c.insets = new Insets(0, 0, 6, 0);
      c.gridx = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.CENTER;
      c.weightx = 0;

      checkBox = new JCheckBox();
      productInfoPanel.add(checkBox, c);
      c.gridx++;

      c.weightx = 1;
      productInfoPanel.add(new JLabel("TTT"), c);
      c.gridx++;

      productInfoPanel.add(new JLabel(""), c);
      c.gridx++;

      c.weightx = 0;
      productInfoPanel.add(new JLabel("PPP"), c);
      c.gridx++;

      add(productInfoPanel);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends MyData> list, MyData value, int index,
      boolean isSelected, boolean cellHasFocus) {

      if (isSelected) {
        setBackground(list.getSelectionBackground());
        setForeground(list.getSelectionForeground());
      } else {
        setBackground(list.getBackground());
        setForeground(list.getForeground());
      }

      return this;
    }
  }
}

