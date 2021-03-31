package test.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * Created by yangxiaohua on 2020/7/22.
 */
public class Demo extends JFrame {

  private int m;
  private int n;
  private JTable table = null;
  private List<String> list = new ArrayList<String>();
  TableColumn c = new TableColumn();
  TableColumn c2 = new TableColumn();
  DefaultTableCellRenderer cellRenderer = null;
  DefaultTableColumnModel columnModel;

  public Demo() {
    cellRenderer = new DefaultTableCellRenderer() {
      public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {

        JTextField text = new JTextField(value.toString());
        if (row == n & column == m) {

          text.setBackground(Color.RED);
          text.setForeground(Color.BLACK);
        } else {
          text.setBackground(Color.WHITE);
          text.setForeground(Color.CYAN);
        }
        return text;

      }
    };

    String[] x1 = { "1", "2", "3", "4" };
    String[][] x2 = { { "q", "w", "e", "r" }, { "a", "s", "d", "f" }, { "z", "x", "c", "v" } };

    for (int i = 0; i < 10; i++) {
      list.add("" + i);
    }

    //    DefaultTableModel tableModel = new DefaultTableModel(x2, x1);

    TableModel tableModel = new DetailsTableModel();

    columnModel = new DefaultTableColumnModel();

    c.setModelIndex(0);
    c.setHeaderValue("test1");
    c.setIdentifier("ttt");
    c.setCellRenderer(cellRenderer);
    columnModel.addColumn(c);

    c2.setModelIndex(1);
    c2.setHeaderValue("test2");
    c2.setIdentifier("ttt2");
    c2.setCellRenderer(cellRenderer);
    columnModel.addColumn(c2);

    table = new JTable(tableModel, columnModel);
    table.setDefaultRenderer(Object.class, cellRenderer);
    JPanel jp = new JPanel(new BorderLayout());
    jp.add(new JScrollPane(table), BorderLayout.CENTER);

    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    table.setColumnSelectionAllowed(false);

    this.setContentPane(jp);
    this.setBounds(100, 100, 300, 300);
    this.setVisible(true);

    table.addMouseListener(new MouseAdapter() {

                             @Override
                             public void mousePressed(MouseEvent e) {

                               m = table.getSelectedColumn();
                               n = table.getSelectedRow();
                               String str = (String) table.getValueAt(n, m);
                             }
                           }
    );
  }

  class DetailsTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    @Override
    public int getRowCount() {
      return list.size();
    }

    @Override
    public int getColumnCount() {
      return columnModel.getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      String line = list.get(rowIndex);
      if (columnIndex == c.getModelIndex()) {
        return line;
      } else if (columnIndex == c2.getModelIndex()) {
        return line;
      } else {
        return null;
      }
    }
  }

  public static void main(String[] args) {
    new Demo();

  }
}
