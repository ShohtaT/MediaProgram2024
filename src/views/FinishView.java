package views;

import controllers.Game1Controller;
import models.EnumShootingScreen;
import models.Player;
import models.Enemy;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import views.DrawPlayer;
public class FinishView {

  boolean guard = false;
  int time =0;
  private final Game1Controller controller;
  public BufferedImage image;
  public FinishView(Game1Controller controller) {
    this.controller = controller;
    this.image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
  }

  public EnumShootingScreen render(Graphics graphics) {
    graphics.setColor(Color.white);
    Font CLEAR = new Font("Serif", Font.BOLD, 50);
    graphics.setFont(CLEAR);
    graphics.drawString("GAME CLEAR", 225, 480);
 return EnumShootingScreen.FINISH;
}
}
