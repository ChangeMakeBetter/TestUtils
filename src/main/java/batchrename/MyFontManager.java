package batchrename;

import java.awt.Font;

import javax.swing.UIManager;

public class MyFontManager {
  public static void setDeFaultFont() {
    Font font = new Font("微软雅黑", Font.BOLD, 18);
    String componentNames[] = {
      "Label", "CheckBox", "PopupMenu", "MenuItem", "CheckBoxMenuItem",
      "JRadioButtonMenuItem", "ComboBox", "Button", "Tree", "ScrollPane",
      "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
      "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
      "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
      "PasswordField", "TextField", "Table", "Label", "Viewport", "JSpinner",
      "RadioButtonMenuItem", "RadioButton", "DesktopPane", "InternalFrame"
    };
    for (String componentName : componentNames) {
      UIManager.put(componentName + ".font", font);
    }

  }
}