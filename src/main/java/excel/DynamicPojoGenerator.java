package excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicPojoGenerator {

  public static void main(String[] args) {
    // Excel file path
    String excelFilePath = "D://20240201VTE.xlsx";

    // Read column names from Excel header row
    List<String> excelHeader = readExcelHeader(excelFilePath);

    // Generate POJO class source code
    String pojoSourceCode = generatePOJO(excelHeader);

    // Output the generated Java source code to console
    System.out.println(pojoSourceCode);
  }

  private static List<String> readExcelHeader(String excelFilePath) {
    List<String> columnNames = new ArrayList<>();

    try (InputStream inputStream = new FileInputStream(excelFilePath);
         Workbook workbook = new XSSFWorkbook(inputStream)) {

      Sheet sheet = workbook.getSheetAt(0);
      Row headerRow = sheet.getRow(0);

      Iterator<Cell> cellIterator = headerRow.cellIterator();
      while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
        columnNames.add(cell.getStringCellValue());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return columnNames;
  }

  private static String generatePOJO(List<String> fieldNames) {
    StringBuilder sourceCode = new StringBuilder();

    // Generate package and class declarations
    sourceCode.append("public class DynamicPOJO {\n");

    // Generate fields based on column names
    for (String fieldName : fieldNames) {
      sourceCode.append("    private String ").append(fieldName).append(";\n");
    }
    sourceCode.append("\n");

    // Generate constructor
    sourceCode.append("    public DynamicPOJO() {}\n\n");

    // Generate getters and setters
    for (String fieldName : fieldNames) {
      sourceCode.append("    public String get").append(capitalize(fieldName)).append("() {\n");
      sourceCode.append("        return ").append(fieldName).append(";\n");
      sourceCode.append("    }\n\n");
      sourceCode.append("    public void set").append(capitalize(fieldName)).append("(String ").append(fieldName)
        .append(") {\n");
      sourceCode.append("        this.").append(fieldName).append(" = ").append(fieldName).append(";\n");
      sourceCode.append("    }\n\n");
    }

    // Generate toString method
    sourceCode.append("    @Override\n");
    sourceCode.append("    public String toString() {\n");
    sourceCode.append("        return \"DynamicPOJO{\" +\n");
    for (String fieldName : fieldNames) {
      sourceCode.append("                \", ").append(fieldName).append("='\" + ").append(fieldName)
        .append(" + '\\'' +\n");
    }
    sourceCode.append("                '}';\n");
    sourceCode.append("    }\n");

    // Close class declaration
    sourceCode.append("}\n");

    return sourceCode.toString();
  }

  private static String capitalize(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return Character.toUpperCase(str.charAt(0)) + str.substring(1);
  }
}
