package batchrename;

import java.awt.*;

public class Invoker {//程序入口

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        MyFontManager.setDeFaultFont();//注意:在绘制前调用,否则不生效!
        new MyUI().setVisible(true);
      }
    });
  }
}