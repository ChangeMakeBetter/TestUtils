package test.artifact;

/**
 * </br>
 * Created by yangxiaohua on 2023/11/10.
 */
public class ArtifactBuilder {

  private static final String wholeName = "com.hd123.test.jpos.driver.aiscale.TestAiScaleDetectDll";

  public static void main(String[] args) {
    String[] s = wholeName.split("\\.");
    for (String s1 : s) {
      System.out.println(s1);
    }
  }

  private String build(String className, String dirElementStr) {
    String result = "<component name=\"ArtifactManager\">\n"
      + "  <artifact type=\"jar\" name=\"" + className + "\">\n"
      + "    <output-path>$PROJECT_DIR$/out/artifacts/" + className + "</output-path>\n"
      + "    <root id=\"archive\" name=\"" + className + ".jar\">\n"
      + dirElementStr
      + "      <element id=\"directory\" name=\"META-INF\">\n"
      + "        <element id=\"file-copy\" path=\"D:/jarRun/" + className + "/META-INF/MANIFEST.MF\" />\n"
      + "      </element>\n"
      + "    </root>\n"
      + "  </artifact>\n"
      + "</component>";
    return result;
  }

}
