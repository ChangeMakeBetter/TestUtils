package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelReader {

  public static void main(String[] args) throws IOException {

    //    FileInputStream fileIn = new FileInputStream("example.xlsx");
    //    SXSSFWorkbook workbook = new SXSSFWorkbook(fileIn);
    //
    //    SheetDataWriter sheetDataWriter = workbook.getSheetDataWriter(0);
    //    RowDataWriter rowDataWriter;
    //
    //    while (sheetDataWriter.hasNext()) {
    //      rowDataWriter = sheetDataWriter.nextRow();
    //      for (int i = 0; i < rowDataWriter.size(); i++) {
    //        System.out.print(rowDataWriter.getCell(i) + "\t");
    //      }
    //      System.out.println();
    //    }
    //
    //    workbook.dispose();
    //    fileIn.close();

    // 创建一个工作簿
    SXSSFWorkbook wb = new SXSSFWorkbook();
    // 创建一个工作表
    SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("Sheet1");
    // 创建一行
    SXSSFRow row = (SXSSFRow) sheet.createRow(0);
    // 创建单元格并设置值
    SXSSFCell cell = (SXSSFCell) row.createCell(0);
    cell.setCellValue("Hello World!");
  }

  public static void readExcel(String filePath) throws IOException {
    InputStream inputStream = new FileInputStream(filePath);
    Workbook workbook = WorkbookFactory.create(inputStream);
    Sheet sheet = workbook.getSheetAt(0);
    int totalRows = sheet.getLastRowNum();
    int batchSize = 1000;
    for (int startRow = 0; startRow <= totalRows; startRow += batchSize) {
      int endRow = Math.min(startRow + batchSize - 1, totalRows);
      for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
          continue;
        }
        // do something with row
      }
    }
  }
}
