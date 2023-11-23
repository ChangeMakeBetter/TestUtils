package json.test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.entity.Range;
import json.entity.TestRequest;

public class JsonTest {

  public static void main(String[] args) {
    String jsonStr = "{\"days\": [],\"useLimit\": true,\"ranges\": [{\"beginTime\": \"00: 00 \",\\\"endTime\\\": \"23: 59\"}],\\\"cycleType\\\": \\\"Daily\\\"}";
    String responseStr = null;
    try {
      Map<String, Range> testMap = new HashMap<String, Range>();
      Range range = new Range();
      range.setBeginTime("111");
      range.setEndTime("222");
      testMap.put("test1", range);
      testMap.put("test12", range);

      TestRequest request = new TestRequest();
      request.setRangeMap(testMap);

      final ObjectMapper jsonObjectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

      String result = jsonObjectMapper.writeValueAsString(request);
      System.out.println(result);

    } catch (Exception e) {
      e.printStackTrace();
    }

    //    LimitTimeRange ltr = new LimitTimeRange();
    //    List<Range> rangeList = new ArrayList<>();
    //    Range r = new Range();
    //    r.setBeginTime("00:00");
    //    r.setEndTime("23:59");
    //    rangeList.add(r);
    //    ltr.setRanges(rangeList);
    //    ltr.setCycleType("test");
    //    ltr.setUseLimit(false);
    //    System.out.println(ltr.toString());
  }

}
