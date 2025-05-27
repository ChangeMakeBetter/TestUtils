package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMapper {
  public static void main(String[] args) {
    //    String excelFilePath = "D://20240201VTE.xlsx";
    String pexcelFilePath = "D://patients.xlsx";
    String excelFilePartPath = "D://泌尿科VTE病人检验结果.xlsx";
    //        String excelFilePath = "D://test.xlsx";
    // 导入excel并生成对象
    List<Patient> patients = importFromExcel(pexcelFilePath);

    // 无对象，数组通用模式
    //    List<List<String>> data = importToVector(pexcelFilePath);
    //    List<List<String>> result = recalcData(data);

    //    Map<String, PatientPart> patientParts = importFromExcelPart(excelFilePartPath);
    // 根据规则进行数据处理
    List<Patient> result = calcAndReset(patients);
    //    combine(patients, patientParts);
    System.out.println("计算完成");
    System.out.println("开始导出..");
    // 导出到 Excel
    exportPatientsToExcel(result, "D://combine.xlsx");
    System.out.println("完成.");
  }

  private static List<List<String>> recalcData(List<List<String>> data) {
    int keyIndex = 0;
    int compareIndex = 48;

    //  按 keyIndex 分组
    Map<String, List<List<String>>> pMap =
      data.stream().collect(Collectors.groupingBy(row -> row.get(keyIndex), LinkedHashMap::new, Collectors.toList()));
    List<List<String>> result = new ArrayList<>();
    for (Entry<String, List<List<String>>> entry : pMap.entrySet()) {
      Optional<List<String>> usefulRow = entry.getValue().stream().max(Comparator.comparing(l -> l.get(compareIndex)));
      usefulRow.ifPresent(result::add);
    }
    return result;
  }

  private static void combine(List<Patient> patients, Map<String, PatientPart> patientParts) {
    for (Patient patient : patients) {
      PatientPart part = patientParts.get(patient.get住院号());
      if (part != null) {
        convert(patient, part);
      }
    }
  }

  private static void convert(Patient patient, PatientPart part) {
    patient.set纤维蛋白降解物1(part.get纤维蛋白降解物1());
    patient.setD_D二聚体(part.getD_D二聚体());
    patient.set凝血酶时间1(part.get凝血酶时间1());
    patient.set凝血酶原时间1(part.get凝血酶原时间1());
    patient.set国际标准化比率1(part.get国际标准化比率1());
    patient.set纤维蛋白原1(part.get纤维蛋白原1());
    patient.set部分凝血活酶时间1(part.get部分凝血活酶时间1());
    patient.set血小板计数1(part.get血小板计数1());
    patient.set尿酸URIC1(part.get尿酸URIC1());
    patient.set肌酐CREA1(part.get肌酐CREA1());
    patient.set凝血因子活性1(part.get凝血因子活性1());
    patient.set纤维蛋白原水平min1(part.get纤维蛋白原水平min1());
    patient.set纤维蛋白原水平1(part.get纤维蛋白原水平1());
    patient.set血小板功能1(part.get血小板功能1());
    patient.set凝血综合参数1(part.get凝血综合参数1());
    patient.set预测纤溶指标1(part.get预测纤溶指标1());
    patient.set纤溶指标1(part.get纤溶指标1());
    patient.set凝固时间1(part.get凝固时间1());
    patient.set血块强度(part.get血块强度());
    patient.setTEG凝血因子活性1(part.getTEG凝血因子活性1());
    patient.setTEG纤维蛋白原水平1(part.getTEG纤维蛋白原水平1());
    patient.set住院号(part.get住院号());
    patient.setTEG血小板功能1(part.getTEG血小板功能1());
    patient.setTEG纤溶系统1(part.getTEG纤溶系统1());
    patient.set总胆固醇CHOL1(part.get总胆固醇CHOL1());
    patient.set甘油三脂TG1(part.get甘油三脂TG1());
    patient.set高密度脂蛋白胆固醇HDL1(part.get高密度脂蛋白胆固醇HDL1());
    patient.set低密度脂蛋白胆固醇LDL1(part.get低密度脂蛋白胆固醇LDL1());
    patient.set非高密度脂蛋白胆固醇NHDL1(part.get非高密度脂蛋白胆固醇NHDL1());
    patient.set纤维蛋白原降解物术后第一天(part.get纤维蛋白原降解物术后第一天());
    patient.setD_D二聚体术后第一天(part.getD_D二聚体术后第一天());
    patient.set肌酐CREA术后第一天(part.get肌酐CREA术后第一天());
    patient.set尿酸URIC术后第一天(part.get尿酸URIC术后第一天());
  }

  private static Map<String, PatientPart> importFromExcelPart(String excelFilePath) {
    try (InputStream inputStream = new FileInputStream(excelFilePath);
         Workbook workbook = new XSSFWorkbook(inputStream)) {

      Sheet sheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = sheet.iterator();

      Map<String, PatientPart> patients = new LinkedHashMap<>();

      int size = 0;
      StringBuilder sb = new StringBuilder();
      StringBuilder titleSplit = new StringBuilder();
      List<String> titleList = new ArrayList<>();
      // Skipping the first row (header)
      if (iterator.hasNext()) {
        Row header = iterator.next(); // header row
        Iterator<Cell> headerCellIterator = header.iterator();
        sb.append("|");
        titleSplit.append("|");
        while (headerCellIterator.hasNext()) {
          size++;
          DataFormatter df = new DataFormatter();
          String title = df.formatCellValue(headerCellIterator.next());
          sb.append(title).append("|");
          titleList.add(title);
          titleSplit.append("-------|");
        }
      }

      sb.append("\n");
      sb.append(titleSplit).append("\n");
      sb.append("|");
      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
        PatientPart patient = new PatientPart();
        int i = 0;
        patient.set住院号(format(currentRow.getCell(i)));
        i = 4;
        patient.set纤维蛋白降解物1(format(currentRow.getCell(i++)));
        patient.setD_D二聚体(format(currentRow.getCell(i++)));
        patient.set凝血酶时间1(format(currentRow.getCell(i++)));
        patient.set凝血酶原时间1(format(currentRow.getCell(i++)));
        patient.set国际标准化比率1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原1(format(currentRow.getCell(i++)));
        patient.set部分凝血活酶时间1(format(currentRow.getCell(i++)));
        patient.set血小板计数1(format(currentRow.getCell(i++)));
        patient.set尿酸URIC1(format(currentRow.getCell(i++)));
        patient.set肌酐CREA1(format(currentRow.getCell(i++)));
        patient.set凝血因子活性1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原水平min1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原水平1(format(currentRow.getCell(i++)));
        patient.set血小板功能1(format(currentRow.getCell(i++)));
        patient.set凝血综合参数1(format(currentRow.getCell(i++)));
        patient.set预测纤溶指标1(format(currentRow.getCell(i++)));
        patient.set纤溶指标1(format(currentRow.getCell(i++)));
        patient.set凝固时间1(format(currentRow.getCell(i++)));
        patient.set血块强度(format(currentRow.getCell(i++)));
        patient.setTEG凝血因子活性1(format(currentRow.getCell(i++)));
        patient.setTEG纤维蛋白原水平1(format(currentRow.getCell(i++)));
        patient.setTEG血小板功能1(format(currentRow.getCell(i++)));
        patient.setTEG纤溶系统1(format(currentRow.getCell(i++)));
        patient.set总胆固醇CHOL1(format(currentRow.getCell(i++)));
        patient.set甘油三脂TG1(format(currentRow.getCell(i++)));
        patient.set高密度脂蛋白胆固醇HDL1(format(currentRow.getCell(i++)));
        patient.set低密度脂蛋白胆固醇LDL1(format(currentRow.getCell(i++)));
        patient.set非高密度脂蛋白胆固醇NHDL1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原降解物术后第一天(format(currentRow.getCell(i++)));
        patient.setD_D二聚体术后第一天(format(currentRow.getCell(i++)));
        patient.set肌酐CREA术后第一天(format(currentRow.getCell(i++)));
        patient.set尿酸URIC术后第一天(format(currentRow.getCell(i++)));
        patients.put(patient.get住院号(), patient);
      }
      System.out.println("part总记录数：" + patients.size());

      return patients;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new LinkedHashMap<>();
    }
  }

  private static List<List<String>> importToVector(String excelFilePath) {
    try (InputStream inputStream = new FileInputStream(excelFilePath);
         Workbook workbook = new XSSFWorkbook(inputStream)) {

      Sheet sheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = sheet.iterator();

      List<Patient> patients = new ArrayList<>();

      int col = 0;
      // Skipping the first row (header)
      if (iterator.hasNext()) {
        Row header = iterator.next(); // header row
        Iterator<Cell> headerCellIterator = header.iterator();
        while (headerCellIterator.hasNext()) {
          col++;
        }
      }

      List<List<String>> datas = new Vector<>();

      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
        List<String> rowData = new ArrayList<>();
        for (int i = 0; i <= col; i++) {
          rowData.add(format(currentRow.getCell(i)));
        }
        datas.add(rowData);
      }
      System.out.println("总记录数：" + datas.size());
      return datas;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ArrayList<>();
    }
  }

  private static List<Patient> importFromExcel(String excelFilePath) {
    try (InputStream inputStream = new FileInputStream(excelFilePath);
         Workbook workbook = new XSSFWorkbook(inputStream)) {

      Sheet sheet = workbook.getSheetAt(0);
      Iterator<Row> iterator = sheet.iterator();

      List<Patient> patients = new ArrayList<>();

      int col = 0;
      // Skipping the first row (header)
      if (iterator.hasNext()) {
        Row header = iterator.next(); // header row
        Iterator<Cell> headerCellIterator = header.iterator();
        while (headerCellIterator.hasNext()) {
          col++;
          DataFormatter df = new DataFormatter();
        }
      }

      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
        Patient patient = new Patient();
        int i = 0;
        patient.setPATIENT_ID(format(currentRow.getCell(i++)));
        patient.setVISIT_ID(format(currentRow.getCell(i++)));
        patient.set住院号(format(currentRow.getCell(i++)));
        patient.setPATIENT_NAME(format(currentRow.getCell(i++)));
        patient.setSEX(format(currentRow.getCell(i++)));
        patient.setAGE(format(currentRow.getCell(i++)));
        patient.setWARD_NAME(format(currentRow.getCell(i++)));
        patient.set主诊断(format(currentRow.getCell(i++)));
        patient.set其他诊断(format(currentRow.getCell(i++)));
        patient.set身高(format(currentRow.getCell(i++)));
        patient.set体重(format(currentRow.getCell(i++)));
        patient.set入院时间(format(currentRow.getCell(i++)));
        patient.set出院时间(format(currentRow.getCell(i++)));
        patient.set手术时间(format(currentRow.getCell(i++)));
        patient.set手术名称(format(currentRow.getCell(i++)));
        patient.set病理(format(currentRow.getCell(i++)));
        patient.setB超(format(currentRow.getCell(i++)));
        patient.set记录日期(format(currentRow.getCell(i++)));
        patient.set记录时间(format(currentRow.getCell(i++)));
        patient.setCAPRINI评分(format(currentRow.getCell(i++)));
        patient.set护理措施(format(currentRow.getCell(i++)));
        patient.set护理措施2(format(currentRow.getCell(i++)));
        patient.set护理措施3(format(currentRow.getCell(i++)));
        patient.set药品名(format(currentRow.getCell(i++)));
        patient.set年龄0至40岁(format(currentRow.getCell(i++)));
        patient.set年龄41至60岁(format(currentRow.getCell(i++)));
        patient.set年龄61至74岁(format(currentRow.getCell(i++)));
        patient.set年龄大于等于75岁(format(currentRow.getCell(i++)));
        patient.set肥胖即体质指数BMI大于25(format(currentRow.getCell(i++)));
        patient.set卧床时间小于72小时且持续步行少于30步(format(currentRow.getCell(i++)));
        patient.set卧床时间大于等于72小时且持续步行少于30步(format(currentRow.getCell(i++)));
        patient.set下肢肿胀目前或1个月内(format(currentRow.getCell(i++)));
        patient.set下肢静脉曲张目前或1个月内(format(currentRow.getCell(i++)));
        patient.set炎性肠病史如克隆氏病或溃疡性结肠炎(format(currentRow.getCell(i++)));
        patient.set充血性心力衰竭史(format(currentRow.getCell(i++)));
        patient.set严重肺病史如COPD或肺气肿或不包括哮喘(format(currentRow.getCell(i++)));
        patient.set恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者(format(currentRow.getCell(i++)));
        patient.set一月内或现在急性心肌梗死(format(currentRow.getCell(i++)));
        patient.set一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症(format(currentRow.getCell(i++)));
        patient.set一月内进行过全麻或局麻下大于等于45分钟的手术(format(currentRow.getCell(i++)));
        patient.set一月内或现在PICC置管或中心静脉置管(format(currentRow.getCell(i++)));
        patient.set一月内下肢石膏固定或其他原因限制下肢活动(format(currentRow.getCell(i++)));
        patient.set一月内下肢关节置换手术史(format(currentRow.getCell(i++)));
        patient.set一月内髋或骨盆或下肢骨折(format(currentRow.getCell(i++)));
        patient.set一月内严重创伤比如由于车祸或坠落导致的多处骨折(format(currentRow.getCell(i++)));
        patient.set一月内需长期卧床的脑卒中(format(currentRow.getCell(i++)));
        patient.set一月内急性脊髓损伤瘫痪(format(currentRow.getCell(i++)));
        patient.setVTE病史(format(currentRow.getCell(i++)));
        patient.setVTE家族史(format(currentRow.getCell(i++)));
        patient.set小手术即手术时间小于45分钟(format(currentRow.getCell(i++)));
        patient.set大手术即手术时间大于等于45分钟(format(currentRow.getCell(i++)));
        patient.set关节镜手术即手术时间大于等于45分钟(format(currentRow.getCell(i++)));
        patient.set腹腔鏡手术即手术时间大于等于45分钟(format(currentRow.getCell(i++)));
        patient.set怀孕或产后一个月内(format(currentRow.getCell(i++)));
        patient.set有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史(format(currentRow.getCell(i++)));
        patient.set正在口服避孕药或其他药物避孕措施(format(currentRow.getCell(i++)));
        patient.set狼疮抗凝物阳性括号获得性(format(currentRow.getCell(i++)));
        patient.set抗磷脂抗体阳性括号获得性(format(currentRow.getCell(i++)));
        patient.set高同型半胱氨酸血症括号获得性(format(currentRow.getCell(i++)));
        patient.set肝素诱导的血小板减少症括号获得性(format(currentRow.getCell(i++)));
        patient.set凝血因子VLEIDEN突变括号遗传性(format(currentRow.getCell(i++)));
        patient.set凝血酶原G20210A突变括号遗传性(format(currentRow.getCell(i++)));
        patient.set蛋白S斜杠C缺乏括号遗传性(format(currentRow.getCell(i++)));
        patient.set抗凝血酶III缺乏括号遗传性(format(currentRow.getCell(i++)));
        patient.set其他高凝状态比如血纤维蛋白原异常或红细胞增多症等(format(currentRow.getCell(i++)));
        patient.set纤维蛋白降解物1(format(currentRow.getCell(i++)));
        patient.setD_D二聚体(format(currentRow.getCell(i++)));
        patient.set凝血酶时间1(format(currentRow.getCell(i++)));
        patient.set凝血酶原时间1(format(currentRow.getCell(i++)));
        patient.set国际标准化比率1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原1(format(currentRow.getCell(i++)));
        patient.set部分凝血活酶时间1(format(currentRow.getCell(i++)));
        patient.set血小板计数1(format(currentRow.getCell(i++)));
        patient.set尿酸URIC1(format(currentRow.getCell(i++)));
        patient.set肌酐CREA1(format(currentRow.getCell(i++)));
        patient.set凝血因子活性1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原水平min1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原水平1(format(currentRow.getCell(i++)));
        patient.set血小板功能1(format(currentRow.getCell(i++)));
        patient.set凝血综合参数1(format(currentRow.getCell(i++)));
        patient.set预测纤溶指标1(format(currentRow.getCell(i++)));
        patient.set纤溶指标1(format(currentRow.getCell(i++)));
        patient.set凝固时间1(format(currentRow.getCell(i++)));
        patient.set血块强度(format(currentRow.getCell(i++)));
        patient.setTEG凝血因子活性1(format(currentRow.getCell(i++)));
        patient.setTEG纤维蛋白原水平1(format(currentRow.getCell(i++)));
        patient.setTEG血小板功能1(format(currentRow.getCell(i++)));
        patient.setTEG纤溶系统1(format(currentRow.getCell(i++)));
        patient.set总胆固醇CHOL1(format(currentRow.getCell(i++)));
        patient.set甘油三脂TG1(format(currentRow.getCell(i++)));
        patient.set高密度脂蛋白胆固醇HDL1(format(currentRow.getCell(i++)));
        patient.set低密度脂蛋白胆固醇LDL1(format(currentRow.getCell(i++)));
        patient.set非高密度脂蛋白胆固醇NHDL1(format(currentRow.getCell(i++)));
        patient.set纤维蛋白原降解物术后第一天(format(currentRow.getCell(i++)));
        patient.setD_D二聚体术后第一天(format(currentRow.getCell(i++)));
        patient.set肌酐CREA术后第一天(format(currentRow.getCell(i++)));
        patient.set尿酸URIC术后第一天(format(currentRow.getCell(i++)));
        patients.add(patient);

      }
      System.out.println("总记录数：" + patients.size());
      return patients;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ArrayList<>();
    }
  }

  private static final String normalDate = "yyyy/M/d H:mm";

  private static String format(Cell cell) {
    DataFormatter dataFormatter = new DataFormatter();
    if (cell == null) {
      return dataFormatter.formatCellValue(null);
    }
    if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
      String dateStr = dataFormatter.formatCellValue(cell);
      Date date = cell.getDateCellValue();
      if (dateStr.split("/").length > 2) {
        if (dateStr.split(":").length > 1) {
          return formatDate(date, normalDate);
        } else {
          return formatDate(date, "yyyy/M/d");
        }
      } else if (dateStr.split(":").length > 1) {
        return formatDate(date, "H:mm");
      } else {
        return formatDate(date, normalDate);
      }
    } else {
      return dataFormatter.formatCellValue(cell);
    }
  }

  // 将日期格式化为 "H:mm"
  private static String formatDate(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }

  private static List<Patient> calcAndReset(List<Patient> patients) {
    Map<String, List<Patient>> groupedPatients = patients.stream()
      .collect(Collectors.groupingBy(Patient::getPATIENT_ID,
        LinkedHashMap::new, Collectors.toList()));
    System.out.println("总病人数：" + groupedPatients.size());
    Map<String, Patient> result = new LinkedHashMap<>();
    for (Map.Entry<String, List<Patient>> entry : groupedPatients.entrySet()) {
      List<Patient> values = entry.getValue();
      // 在每组中查找年龄为50的记录
      Optional<Patient> maxCAPRINI = values.stream()
        .max(Comparator.comparing(Patient::getCAPRINI评分));

      Optional<Patient> patient病理 = values.stream()
        .filter(p -> (p.get病理() != null && !"".equals(p.get病理()))).findFirst();

      if (maxCAPRINI.isPresent()) {
        Patient p = maxCAPRINI.get();
        patient病理.ifPresent(o -> p.set病理(o.get病理()));
        result.put(p.getPATIENT_ID(), p);
      }
    }

    // 打印结果
    //    result.forEach((pid, patient) -> {
    //      System.out.println(
    //        "PATIENT: " + patient.getPATIENT_NAME() + ",病理：" + patient.get病理() + ",CAPRINI:" + patient.getCAPRINI评分());
    //    });

    //    result.forEach((pid, p) -> System.out.println(p.toFormatString()));
    return new ArrayList<>(result.values());
  }

  public static void exportPatientsToExcel(List<Patient> patients, String filePath) {
    try (Workbook workbook = new XSSFWorkbook()) {
      Sheet sheet = workbook.createSheet("Patients");

      int rowNum = 0;
      for (Patient patient : patients) {
        Row row = sheet.createRow(rowNum++);
        int cellNum = 0;
        row.createCell(cellNum++).setCellValue(patient.getPATIENT_ID());
        row.createCell(cellNum++).setCellValue(patient.getVISIT_ID());
        row.createCell(cellNum++).setCellValue(patient.get住院号());
        row.createCell(cellNum++).setCellValue(patient.getPATIENT_NAME());
        row.createCell(cellNum++).setCellValue(patient.getSEX());
        row.createCell(cellNum++).setCellValue(patient.getAGE());
        row.createCell(cellNum++).setCellValue(patient.getWARD_NAME());
        row.createCell(cellNum++).setCellValue(patient.get主诊断());
        row.createCell(cellNum++).setCellValue(patient.get其他诊断());
        row.createCell(cellNum++).setCellValue(patient.get身高());
        row.createCell(cellNum++).setCellValue(patient.get体重());
        row.createCell(cellNum++).setCellValue(patient.get入院时间());
        row.createCell(cellNum++).setCellValue(patient.get出院时间());
        row.createCell(cellNum++).setCellValue(patient.get手术时间());
        row.createCell(cellNum++).setCellValue(patient.get手术名称());
        row.createCell(cellNum++).setCellValue(patient.get病理());
        row.createCell(cellNum++).setCellValue(patient.getB超());
        row.createCell(cellNum++).setCellValue(patient.get记录日期());
        row.createCell(cellNum++).setCellValue(patient.get记录时间());
        row.createCell(cellNum++).setCellValue(patient.getCAPRINI评分());
        row.createCell(cellNum++).setCellValue(patient.get护理措施());
        row.createCell(cellNum++).setCellValue(patient.get护理措施2());
        row.createCell(cellNum++).setCellValue(patient.get护理措施3());
        row.createCell(cellNum++).setCellValue(patient.get药品名());
        row.createCell(cellNum++).setCellValue(patient.get年龄0至40岁());
        row.createCell(cellNum++).setCellValue(patient.get年龄41至60岁());
        row.createCell(cellNum++).setCellValue(patient.get年龄61至74岁());
        row.createCell(cellNum++).setCellValue(patient.get年龄大于等于75岁());
        row.createCell(cellNum++).setCellValue(patient.get肥胖即体质指数BMI大于25());
        row.createCell(cellNum++).setCellValue(patient.get卧床时间小于72小时且持续步行少于30步());
        row.createCell(cellNum++).setCellValue(patient.get卧床时间大于等于72小时且持续步行少于30步());
        row.createCell(cellNum++).setCellValue(patient.get下肢肿胀目前或1个月内());
        row.createCell(cellNum++).setCellValue(patient.get下肢静脉曲张目前或1个月内());
        row.createCell(cellNum++).setCellValue(patient.get炎性肠病史如克隆氏病或溃疡性结肠炎());
        row.createCell(cellNum++).setCellValue(patient.get充血性心力衰竭史());
        row.createCell(cellNum++).setCellValue(patient.get严重肺病史如COPD或肺气肿或不包括哮喘());
        row.createCell(cellNum++).setCellValue(patient.get恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者());
        row.createCell(cellNum++).setCellValue(patient.get一月内或现在急性心肌梗死());
        row.createCell(cellNum++).setCellValue(patient.get一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症());
        row.createCell(cellNum++).setCellValue(patient.get一月内进行过全麻或局麻下大于等于45分钟的手术());
        row.createCell(cellNum++).setCellValue(patient.get一月内或现在PICC置管或中心静脉置管());
        row.createCell(cellNum++).setCellValue(patient.get一月内下肢石膏固定或其他原因限制下肢活动());
        row.createCell(cellNum++).setCellValue(patient.get一月内下肢关节置换手术史());
        row.createCell(cellNum++).setCellValue(patient.get一月内髋或骨盆或下肢骨折());
        row.createCell(cellNum++).setCellValue(patient.get一月内严重创伤比如由于车祸或坠落导致的多处骨折());
        row.createCell(cellNum++).setCellValue(patient.get一月内需长期卧床的脑卒中());
        row.createCell(cellNum++).setCellValue(patient.get一月内急性脊髓损伤瘫痪());
        row.createCell(cellNum++).setCellValue(patient.getVTE病史());
        row.createCell(cellNum++).setCellValue(patient.getVTE家族史());
        row.createCell(cellNum++).setCellValue(patient.get小手术即手术时间小于45分钟());
        row.createCell(cellNum++).setCellValue(patient.get大手术即手术时间大于等于45分钟());
        row.createCell(cellNum++).setCellValue(patient.get关节镜手术即手术时间大于等于45分钟());
        row.createCell(cellNum++).setCellValue(patient.get腹腔鏡手术即手术时间大于等于45分钟());
        row.createCell(cellNum++).setCellValue(patient.get怀孕或产后一个月内());
        row.createCell(cellNum++).setCellValue(patient.get有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史());
        row.createCell(cellNum++).setCellValue(patient.get正在口服避孕药或其他药物避孕措施());
        row.createCell(cellNum++).setCellValue(patient.get狼疮抗凝物阳性括号获得性());
        row.createCell(cellNum++).setCellValue(patient.get抗磷脂抗体阳性括号获得性());
        row.createCell(cellNum++).setCellValue(patient.get高同型半胱氨酸血症括号获得性());
        row.createCell(cellNum++).setCellValue(patient.get肝素诱导的血小板减少症括号获得性());
        row.createCell(cellNum++).setCellValue(patient.get凝血因子VLEIDEN突变括号遗传性());
        row.createCell(cellNum++).setCellValue(patient.get凝血酶原G20210A突变括号遗传性());
        row.createCell(cellNum++).setCellValue(patient.get蛋白S斜杠C缺乏括号遗传性());
        row.createCell(cellNum++).setCellValue(patient.get抗凝血酶III缺乏括号遗传性());
        row.createCell(cellNum++).setCellValue(patient.get其他高凝状态比如血纤维蛋白原异常或红细胞增多症等());
        row.createCell(cellNum++).setCellValue(patient.get纤维蛋白降解物1());
        row.createCell(cellNum++).setCellValue(patient.getD_D二聚体());
        row.createCell(cellNum++).setCellValue(patient.get凝血酶时间1());
        row.createCell(cellNum++).setCellValue(patient.get凝血酶原时间1());
        row.createCell(cellNum++).setCellValue(patient.get国际标准化比率1());
        row.createCell(cellNum++).setCellValue(patient.get纤维蛋白原1());
        row.createCell(cellNum++).setCellValue(patient.get部分凝血活酶时间1());
        row.createCell(cellNum++).setCellValue(patient.get血小板计数1());
        row.createCell(cellNum++).setCellValue(patient.get尿酸URIC1());
        row.createCell(cellNum++).setCellValue(patient.get肌酐CREA1());
        row.createCell(cellNum++).setCellValue(patient.get凝血因子活性1());
        row.createCell(cellNum++).setCellValue(patient.get纤维蛋白原水平min1());
        row.createCell(cellNum++).setCellValue(patient.get纤维蛋白原水平1());
        row.createCell(cellNum++).setCellValue(patient.get血小板功能1());
        row.createCell(cellNum++).setCellValue(patient.get凝血综合参数1());
        row.createCell(cellNum++).setCellValue(patient.get预测纤溶指标1());
        row.createCell(cellNum++).setCellValue(patient.get纤溶指标1());
        row.createCell(cellNum++).setCellValue(patient.get凝固时间1());
        row.createCell(cellNum++).setCellValue(patient.get血块强度());
        row.createCell(cellNum++).setCellValue(patient.getTEG凝血因子活性1());
        row.createCell(cellNum++).setCellValue(patient.getTEG纤维蛋白原水平1());
        row.createCell(cellNum++).setCellValue(patient.getTEG血小板功能1());
        row.createCell(cellNum++).setCellValue(patient.getTEG纤溶系统1());
        row.createCell(cellNum++).setCellValue(patient.get总胆固醇CHOL1());
        row.createCell(cellNum++).setCellValue(patient.get甘油三脂TG1());
        row.createCell(cellNum++).setCellValue(patient.get高密度脂蛋白胆固醇HDL1());
        row.createCell(cellNum++).setCellValue(patient.get低密度脂蛋白胆固醇LDL1());
        row.createCell(cellNum++).setCellValue(patient.get非高密度脂蛋白胆固醇NHDL1());
        row.createCell(cellNum++).setCellValue(patient.get纤维蛋白原降解物术后第一天());
        row.createCell(cellNum++).setCellValue(patient.getD_D二聚体术后第一天());
        row.createCell(cellNum++).setCellValue(patient.get肌酐CREA术后第一天());
        row.createCell(cellNum++).setCellValue(patient.get尿酸URIC术后第一天());
      }

      try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
        workbook.write(outputStream);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}


