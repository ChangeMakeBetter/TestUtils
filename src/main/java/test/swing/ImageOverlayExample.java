package test.swing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageOverlayExample {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      // Create the main JFrame
      JFrame mainFrame = new JFrame("Main Frame");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(400, 300);

      // Create a JButton (just for demonstration)
      JButton button = new JButton("Click me!");
      mainFrame.add(button);

      // Show the main frame
      mainFrame.setVisible(true);

      // Create the overlay JFrame
      JFrame overlayFrame = new JFrame();
      overlayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      overlayFrame.setSize(400, 300);
      overlayFrame.setUndecorated(true); // Remove decorations
      overlayFrame.setOpacity(0.5f); // Set opacity to make it semi-transparent

      // Create a JPanel to hold the image
      JPanel imagePanel = new JPanel() {
        private static final long serialVersionUID = -6196177521393445871L;

        @Override
        protected void paintComponent(Graphics g) {
          super.paintComponent(g);

          // Load and draw the image
          ImageIcon imageIcon = new ImageIcon("D://second_welcome.png");
          Image image = imageIcon.getImage();
          g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
      };
      overlayFrame.setContentPane(imagePanel);

      // Position the overlay frame
      overlayFrame.setLocation(mainFrame.getLocationOnScreen());
      // Set the overlay frame always on top
      overlayFrame.setAlwaysOnTop(true);
      // Show the overlay frame
      overlayFrame.setVisible(false);

      button.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
          overlayFrame.setVisible(true);
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
          overlayFrame.setVisible(false);
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {
        }
      });
    });
  }
}
