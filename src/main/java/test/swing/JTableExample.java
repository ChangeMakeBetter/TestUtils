package test.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableExample {
  public static void main(String[] args) {
    JFrame frame = new JFrame("JTable Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Object[][] data = {
      { "John", 25, "Male" },
      { "Jane", 30, "Female" },
      { "Bob", 22, "Male" }
    };

    String[] columns = { "Name", "Age", "Gender" };

    JTable table = new JTable(data, columns);
    table.setFillsViewportHeight(true); // Enable filling the viewport height

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}
