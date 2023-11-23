package json.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.json.JSONArray;
import org.apache.tapestry.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * </br>
 * Created by yangxiaohua on 2023/2/8.
 */
public class ReqTest implements Serializable {
  private static final long serialVersionUID = 9122759723114823545L;
  @JsonProperty(value = "YLB")
  private List<SubC> subCList = new ArrayList<>();

  public List<SubC> getSubCList() {
    return subCList;
  }

  public void setSubCList(List<SubC> subCList) {
    this.subCList = subCList;
  }

  // create by build json plugin
  public JSONObject toJson() {
    JSONObject jo = new JSONObject();
    for (SubC s : subCList) {
      jo.accumulate("subCList", s.toJson());
    }
    return jo;
  }

  @Override
  public String toString() {
    return toJson().toString();
  }

  public static void main(String[] args) throws JsonProcessingException {
    ReqTest r = new ReqTest();
    for (int i = 0; i < 3; i++) {
      //      SubC sc = new SubC();
      //      sc.setName(i + "");
      //      sc.setXss("234234" + i);
      //      r.getSubCList().add(sc);
    }
    JSONObject jo = r.toJson();
    jo.put("afasf", new JSONArray());
    //    ObjectMapper om = new ObjectMapper();
    //    om.setSerializationInclusion(Include.NON_NULL);
    //    om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //    SimpleModule module = new SimpleModule();
    //    om.registerModule(module);

    System.out.println(jo.toString());
  }
}


