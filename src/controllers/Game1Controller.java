package controllers;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import models.Enemy;
import models.EnumShootingScreen;

public class Game1Controller {
  public static EnumShootingScreen call(Graphics graphics) {
    int HP = 100; // HP(初期体力100)
    ArrayList<Enemy> enemies_up = new ArrayList<>();
    ArrayList<Enemy> enemies_down = new ArrayList<>();
    int playerX = 640;
    int playerY = 560;
    int time = 0;

    // 枠(黒、白のfillRectを時期の奥になるよう、ここに記述)
    graphics.setColor(Color.white);
    graphics.fillRect(400, 300, 500, 300);
    graphics.setColor(Color.black);
    graphics.fillRect(410, 310, 480, 280);

    graphics.setColor(Color.yellow); // HPバー
    graphics.fillRect(420, 610, HP * 4, 25);

    graphics.setColor(Color.red);
    for (int i = 0; i < enemies_down.size(); i++) {
      Enemy enemy = enemies_down.get(i);
      graphics.fillRect(enemy.x, enemy.y, 480, 10);
      enemy.y += 10;
      if (enemy.y > 580) enemies_down.remove(i);
      if (!(enemy.x + 480 < playerX || playerX + 30 < enemy.x || enemy.y + 10 < playerY || playerY + 30 < enemy.y)) {
        HP -= 1; // 1hitHP20減少
        if (HP == 0) {
          return EnumShootingScreen.GAME_OVER;
        }
      }
    }
    if (time % 30 == 0) {
      enemies_down.add(new Enemy(170, 0));
    }

    graphics.setColor(Color.red);
    for (int i = 0; i < enemies_up.size(); i++) {
      Enemy enemy = enemies_up.get(i);
      graphics.fillRect(enemy.x, enemy.y, 480, 10);
      enemy.y -= 10;
      if (enemy.y <= 0) enemies_up.remove(i);
      if (!(enemy.x + 480 < playerX || playerX + 30 < enemy.x || enemy.y + 10 < playerY || playerY + 30 < enemy.y)) {
        HP -= 1; // 1hitHP20減少
        if (HP == 0) {
          return EnumShootingScreen.GAME_OVER;
        }
      }
    }
    if (time % 30 == 0) {
      enemies_up.add(new Enemy(650, 720));
    }
    time++;

    graphics.setColor(Color.RED);
    graphics.fillRect(playerX, playerY, 30, 30);
    if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX > 410)
      playerX -= 10;                   //なぜかここで動かしてる....
    if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX < 860) playerX += 10;
    if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY > 310) playerY -= 10;
    if (Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && playerY < 560) playerY += 10;
    if (time == 500) {
      return EnumShootingScreen.GAME2;
    }

    return EnumShootingScreen.FINISH;
  }
}
