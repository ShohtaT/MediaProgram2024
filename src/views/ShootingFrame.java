package views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controllers.Keyboard;


public class ShootingFrame extends JFrame {
  public ShootingPanel panel;

  public ShootingFrame() {

    panel = new ShootingPanel();
    this.add(panel);


    this.addWindowListener(new WindowAdapter() {
      //@Override
      public void WindowClosed(WindowEvent e) {
        super.windowClosed(e);
        // Main.loop = false;
      }
    });

    this.addKeyListener(new Keyboard());

    this.setSize(1280, 720);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setTitle("yamamoto_1205.Shooting");
    this.setResizable(false);
    this.setVisible(true);
  }

  public static void main(String argv[]) {
    new ShootingFrame();
  }
}
