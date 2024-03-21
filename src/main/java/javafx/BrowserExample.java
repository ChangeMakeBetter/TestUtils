package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class BrowserExample extends Application {

  @Override
  public void start(Stage primaryStage) {
    // 创建一个WebView对象
    WebView webView = new WebView();

    // 加载一个网页
    webView.getEngine().load(
      "http://www.baidu.com");

    // 创建一个布局容器，并将WebView添加到其中
    StackPane root = new StackPane();
    root.getChildren().add(webView);

    // 创建一个场景，将布局容器添加到场景中
    Scene scene = new Scene(root, 800, 600);

    // 将场景设置到主舞台（窗口）上，并设置窗口标题
    primaryStage.setScene(scene);
    primaryStage.setTitle("JavaFX Browser Example");

    // 显示主舞台（窗口）
    primaryStage.show();
  }

  public static void main(String[] args) {
    // 启动JavaFX应用程序
    launch(args);
  }
}
