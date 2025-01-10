package views;

import controllers.Game1Controller;
import models.EnumShootingScreen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game1View {
  private final Game1Controller controller;
  public BufferedImage image;

  public Game1View(Game1Controller controller) {
    this.controller = controller;
    this.image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
  }

  public EnumShootingScreen render(Graphics graphics) {
    // 枠(黒、白のfillRectを時期の奥になるよう、ここに記述)
    graphics.setColor(Color.white);
    graphics.fillRect(400, 300, 500, 300);
    graphics.setColor(Color.black);
    graphics.fillRect(410, 310, 480, 280);

    // HPバー
    graphics.setColor(Color.yellow);
    graphics.fillRect(420, 610, 500, 25);

    graphics.setColor(Color.red);

    // TODO: Not implemented yet for Game1

    return EnumShootingScreen.GAME1;
  }
}
