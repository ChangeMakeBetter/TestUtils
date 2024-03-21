package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

  @Override
  public void start(Stage primaryStage) {
    // 创建一个文本标签
    Label label = new Label("Hello, JavaFX!");

    // 创建一个布局容器，并将标签添加到其中
    StackPane root = new StackPane();
    root.getChildren().add(label);

    // 创建一个场景，将布局容器添加到场景中
    Scene scene = new Scene(root, 300, 200);

    // 将场景设置到主舞台（窗口）上，并设置窗口标题
    primaryStage.setScene(scene);
    primaryStage.setTitle("Hello JavaFX Application");

    // 显示主舞台（窗口）
    primaryStage.show();
  }

  public static void main(String[] args) {
    // 启动JavaFX应用程序
    launch(args);
  }
}
