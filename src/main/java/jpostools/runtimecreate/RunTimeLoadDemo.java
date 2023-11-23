package jpostools.runtimecreate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * </br>
 * Created by yangxiaohua on 2023/8/23.
 */
public class RunTimeLoadDemo {

  protected static String workspacePath() throws IOException {
    File workspace = new File(".").getCanonicalFile();
    return workspace.getAbsolutePath();
  }

  public static void main(String[] args) {
    //    RunTimeLoadDemo runTimeLoadDemo = new RunTimeLoadDemo();
    //    runTimeLoadDemo.createLoadTest();

    long time = 1697883096914l;
    Date d = new Date(time);
    System.out.println(d);
  }

  public void createLoadTest() {
    try {
      String javaCode = "public class DynamicClass {\n" +
        "    public static void main(String[] args) {\n" +
        "        System.out.println(\"Dynamic Hello, World!\");\n" +
        "    }\n" +
        "}";

      String path = workspacePath() + "\\tools\\src\\jpostools\\";

      File javaFile = new File(path + "DynamicClass.java");
      try (PrintWriter writer = new PrintWriter(new FileWriter(javaFile))) {
        writer.println(javaCode);
      }

      loadClass(javaFile, "main");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void loadClass(File javaFile, String methodName) {
    try {
      String fileName = javaFile.getName().substring(0, javaFile.getName().length() - 5);
      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
      compiler.run(null, null, null, javaFile.getPath());

      System.out.println("path:" + javaFile.getPath());
      System.out.println("URL:" + javaFile.getParentFile().toURI().toURL());

      URLClassLoader classLoader = new URLClassLoader(new URL[] { javaFile.getParentFile().toURI().toURL() });
      Class<?> dynamicClass = classLoader.loadClass(fileName);
      Method mainMethod = dynamicClass.getMethod(methodName, String[].class);
      mainMethod.invoke(null, (Object) new String[0]);

      javaFile.delete();
      File classFile = new File(javaFile.getParentFile() + "\\" + fileName + ".class");
      classFile.delete();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
