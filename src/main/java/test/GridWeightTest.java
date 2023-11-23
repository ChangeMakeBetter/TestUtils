package test;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TestUtils<br> Created by yangxiaohua on 2019/12/11.
 */
public class GridWeightTest {

  public static void main(String[] args) {
    JFrame frame = new JFrame("GridWeightTest");
    frame.setLocation(10, 10);
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    JPanel centerPane = new JPanel();

    frame.add(centerPane, BorderLayout.CENTER);

    centerPane.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;

    JButton btn1 = new JButton("方格1");
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.gridheight = 2;
    gbc.weightx = 0.5;
    gbc.weighty = 0.8;
    centerPane.add(btn1, gbc);

//    JButton btn2 = new JButton("方格2");
//    gbc.gridx = 2;
//    gbc.gridy = 0;
//    gbc.gridwidth = 1;
//    gbc.gridheight = 3;
//    gbc.weightx = 0.5;
//    gbc.weighty = 1;
//    centerPane.add(btn2, gbc);

    JButton btn3 = new JButton("方格3");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    gbc.weightx = 0.5;
    gbc.weighty = 0.2;
    centerPane.add(btn3, gbc);

    frame.setVisible(true);
  }
}
