package test.swing;

/**
 * </br>
 * Created by yangxiaohua on 2023/6/26.
 */

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class JListExample extends JFrame {
  private static final long serialVersionUID = -2201727669246895062L;
  private JList<String> myList;
  private DefaultListModel<String> listModel;

  public JListExample() {
    listModel = new DefaultListModel<>();
    listModel.addElement("Item 1");
    listModel.addElement("Item 2");
    listModel.addElement("Item 3");

    myList = new JList<>(listModel);
    myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    //    myList.addListSelectionListener(e -> {
    //      if (!e.getValueIsAdjusting()) {
    //        int selectedIndex = myList.getSelectedIndex();
    //        System.out.println("Selected index: " + selectedIndex);
    //      }
    //    });

    myList.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int selectedIndex = myList.getSelectedIndex();
        if (selectedIndex != -1) {
          if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String selectedValue = listModel.getElementAt(selectedIndex);
            System.out.println("Enter key pressed on item: " + selectedValue);
          }
        }
      }
    });

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(new JScrollPane(myList), BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(JListExample::new);
  }
}
