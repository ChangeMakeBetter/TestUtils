package scale;

import org.apache.commons.lang3.StringUtils;

import com.digi.internal.common.IScaleContext;
import com.digi.port.ScalesConvertPlu;
import com.sun.istack.internal.NotNull;

/**
 * </br>
 * Created by yangxiaohua on 2020/12/24.
 */
public class DigiScaleJarTest {

  public static void main(String[] args) {

    IScaleContext context = new IScaleContext() {
      @Override
      public void parseProgress(int percentage) {
        System.out.println(String.format("Parse Percentage: %d", percentage));
      }

      @Override
      public void transferProgress(@NotNull String scaleIp, @NotNull String fileName, int percentage) {
        System.out
          .println(String.format("scaleIp:%s - FileName:%s - percentage: %d", scaleIp, fileName, percentage));
      }

      @Override
      public void getSuccessScales(@NotNull String scales) {
        System.out.println("success scales: " + scales);
      }

      @Override
      public void log(int logLevel, @NotNull String logText) {
        String strLevel = "";
        if (logLevel == IScaleContext.Companion.getLEVEL_DEBUG()) {
          strLevel = "D";
        } else if (logLevel == IScaleContext.Companion.getLEVEL_ERROR()) {
          strLevel = "E";
        } else if (logLevel == IScaleContext.Companion.getLEVEL_INFO()) {
          strLevel = "I";
        }

        System.out.println("Scale Log: " + strLevel + "  " + logText);
      }
    };

    String ipList = "172.17.3.240";
    String csvData = StringUtils.join(new String[] {
      "3,10003,菠萝 3,BOLO3,,,12.5,0,22,5,10,2,3,17,EAN,,,,,,,,,,,123456,0,0,0,21,20,20",
      "4,10004,菠萝 4,BOLO4,,,12.6,1,23,5,11,2,3,17,EAN,,,,,,,,,,,123456,0,0,0,21,20,20",
      "5,10005,菠萝 5,BOLO5,,,12.7,0,24,5,12,2,3,17,ITF,,,,,,,,,,,123456,0,0,0,21,20,20"
    }, "\r\n");
    new ScalesConvertPlu(context).importMaster(ipList, csvData);
  }
}
