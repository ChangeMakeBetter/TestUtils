package test.swing;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * </br>
 * Created by yangxiaohua on 2023/6/25.
 */
public class CheckBoxTest {

  public static void main(String[] args) {
    String[] yourDataArray = new String[] { "qewr", "asdf", "zxcv" };
    JList<String> list = new JList<>(yourDataArray);
    list.setCellRenderer(new CheckBoxListRenderer());
    list.addListSelectionListener(e -> {
      if (!e.getValueIsAdjusting()) {
        Object[] selectedValues = list.getSelectedValues();
        System.out.println("Selected items:");
        for (Object value : selectedValues) {
          System.out.println(value);
        }
      }
    });
    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JScrollPane scrollPane = new JScrollPane(list);
    panel.add(scrollPane);
    frame.setContentPane(panel);
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);

  }

}
