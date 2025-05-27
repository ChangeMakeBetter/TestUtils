package test.swing;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class BoldColumnTable {
  public static TableColumn buildTableColumn(int modelIndex, Object headerValue, Object identifier,
    TableCellRenderer cellRenderer, TableCellEditor cellEditor) {
    TableColumn c = new TableColumn();
    c.setModelIndex(modelIndex);
    c.setHeaderValue(headerValue);
    c.setIdentifier(identifier);
    if (cellRenderer != null) {
      c.setCellRenderer(cellRenderer);
    }
    if (cellEditor != null) {
      c.setCellEditor(cellEditor);
    }
    return c;
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Bold Column Table Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // 创建表格数据
      String[] columnNames = { "ID", "Name", "Age" };
      Object[][] data = {
        { 1, "John", 30 },
        { 2, "Jane", 25 },
        { 3, "Jim", 40 }
      };
      DefaultTableModel model = new DefaultTableModel(data, columnNames);
      Font font = new Font("微软雅黑", Font.BOLD, 12);
      CellRendererWithAlignment cellRenderer = new CellRendererWithAlignment(font, JLabel.CENTER);
      TableColumn col = buildTableColumn(-1, "ID", 1, cellRenderer, null);

      JTable table = new JTable(model);

      // 自定义渲染器，使第二列（索引为1）字体加粗
      table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
        private static final long serialVersionUID = 5723331552632534312L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
          int row, int column) {
          Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          if (column == 1) { // 假设我们想要第二列加粗
            c.setFont(c.getFont().deriveFont(Font.BOLD));
          }
          return c;
        }
      });

      frame.add(new JScrollPane(table));
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }

  static class CellRendererWithAlignment extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    public CellRendererWithAlignment(Font font, int align) {
      super();
      if (font != null) {
        setFont(font);
      }
      setHorizontalAlignment(align);
    }

  }
}