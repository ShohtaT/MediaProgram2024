package controllers;

import models.EnumShootingScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartController {

  public static EnumShootingScreen call(Graphics graphics) {
    graphics.setColor(Color.WHITE);
    Font font = new Font("SansSelif", Font.PLAIN, 40);
    graphics.setFont(font);
    FontMetrics metrics = graphics.getFontMetrics(font);
    graphics.drawString("yamamoto_1205.Shooting", 640 - (metrics.stringWidth("yamamoto_1205.Shooting") / 2), 300);
    font = new Font("SansSelif", Font.PLAIN, 20);
    metrics = graphics.getFontMetrics(font);
    graphics.drawString("Press SPACE to Start", 540 - (metrics.stringWidth("Press SPACE to Start") / 2), 500);          //無理やりで真ん中に持ってきてる
    if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
      return EnumShootingScreen.GAME1;
    }

    return EnumShootingScreen.START;
  }
}
