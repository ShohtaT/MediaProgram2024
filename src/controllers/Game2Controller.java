package controllers;

import models.EnumShootingScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Game2Controller {
  public static EnumShootingScreen call(Graphics graphics) {
    int playerX = 640;
    int playerY = 560;
    int HP = 100; // HP(初期体力100)
    int gravity_time = 0;

    graphics.setColor(Color.white);
    graphics.fillRect(400, 300, 500, 300);
    graphics.setColor(Color.black);
    graphics.fillRect(410, 310, 480, 280);

    graphics.setColor(Color.yellow); // HPバー
    graphics.fillRect(420, 610, HP * 4, 25);
    graphics.setColor(Color.blue);
    graphics.fillRect(playerX, playerY, 30, 30);
    if (!(Keyboard.isKeyPressed(KeyEvent.VK_UP)) && playerY < 560) {
      gravity_time++;
      playerY += gravity_time * (gravity_time - 1);
    }
    if (playerY == 560) {
      gravity_time = 0;
    }
    if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX > 410) playerX -= 15;
    if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX < 860) playerX += 15;
    if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY > 380) playerY -= 10;

    if (playerY > 560) {
      playerY = 560;
    }
    return EnumShootingScreen.FINISH;
  }
}
