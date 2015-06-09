/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Nebojsa
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Testing
{
  GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
  GraphicsDevice device = env.getScreenDevices()[0];
  DisplayMode oldMode = device.getDisplayMode();
  DisplayMode newMode = new DisplayMode(800,600,oldMode.getBitDepth(),oldMode.getRefreshRate());
  public void buildGUI()
  {
    int i=1;
    JPanel p = new JPanel();
    JButton b1 = new JButton("Old Res.");
    JButton b2 = new JButton("800 x 600");
    JButton b3 = new JButton("Exit");
    p.add(b1);
    p.add(b2);
    p.add(b3);
    final JFrame f = new JFrame();
    f.getContentPane().add(p);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    b1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        device.setDisplayMode(oldMode);
      }
    });
    b2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        device.setFullScreenWindow(f);
        device.setDisplayMode(newMode);
      }
    });
    b3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ae){
        System.exit(0);
      }
    });
  }
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Testing().buildGUI();
      }
    });
  }
}
