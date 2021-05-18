package test.basejava;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hd123.otter.service.jposservice.intf.samplebill.OtterSampleBill;

/**
 * TestUtils<br> Created by yangxiaohua on 2020/4/20.
 */
public class BaseTest {

  public static void main(String[] args) throws UnknownHostException {
    //
    //    ([\s\S]*?)
    String PRINTBARCODE_FUNCTION = "printBarCode/([\\s\\S]*?),([\\s\\S]*?)/";
    Pattern p = Pattern.compile(PRINTBARCODE_FUNCTION);
    Matcher m = p.matcher("printBarCode/\n123123123/");
    while (m.find()) {
      System.out.println("match");
    }

    String test = "asdf";

    OtterSampleBill bill = new OtterSampleBill();
    bill.getDataFrom();

    String productUuids[] = test.split(";");

    System.out.println(productUuids.length);

    List<Man> manList = new ArrayList<>();
    manList.add(new Man("y", 27));
    manList.add(new Man("x", 33));
    System.out.println(manList.toString());

    List<String> sizes = new ArrayList<String>();
    for (File file : File.listRoots()) {
      sizes.add(Long.toString(file.getTotalSpace()));
    }
    System.out.println(sizes);

  }
}

//      try {
//        System.out.println("m.groupCount()=" + m.groupCount());
//        String function = m.group(0);
//        System.out.println("function:" + function);
//        if (function.matches(PRINTBARCODE_FUNCTION)) {
//          String barcode = m.group(1);
//          System.out.println("barcode:" + barcode);
//          String dot = m.group(2);
//          System.out.println("dot:" + dot);
//          String dpi = m.group(3);
//          System.out.println("dpi:" + dpi);
//        }
//      } catch (Exception e) {
//        System.out.println(e.getMessage());
//        throw e;
//      }