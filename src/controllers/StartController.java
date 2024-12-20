package controllers;

import models.EnumShootingScreen;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartController {

  public static EnumShootingScreen call(Graphics graphics) {
    int HP = 100; // HP(初期体力100)
    int playerX = 640;

    graphics.setColor(Color.white);
    graphics.fillRect(210, 300, 800, 150);
    graphics.setColor(Color.black);
    graphics.fillRect(220, 310, 780, 130);

    graphics.setColor(Color.yellow); // HPバー
    graphics.fillRect(460, 460, HP * 3, 25);
    graphics.setColor(Color.white); // HPバー周りの情報
    Font YourInfo = new Font("Serif", Font.BOLD, 30);
    graphics.setFont(YourInfo);
    graphics.drawString("YOU", 225, 480);
    graphics.drawString("LV ??", 325, 480); // HPに関する情報
    Font HPBar = new Font("Dialog", Font.BOLD, 20);
    graphics.setFont(HPBar);
    graphics.drawString("HP", 425, 480);
    graphics.drawString(" HP  /  100", 850, 480);

    for (int i = 0; i < 800; i += 200) { // for文で画面下4つのコマンドボタン作成
      graphics.setColor(Color.ORANGE);
      graphics.drawRect(230 + i, 580, 180, 70);
      Font CommandButton = new Font("Monospaced", Font.BOLD, 41);
      graphics.setFont(CommandButton);
      if (i == 0) {
        graphics.drawString("FIGHT", 300, 630);
      } else if (i == 200) {
        graphics.drawString("ACT", 300 + i, 630);
      } else if (i == 400) {
        graphics.drawString("ITEM", 300 + i, 630);
      } else if (i == 600) {
        graphics.drawString("MERCY", 300 + i, 630);
      }
    } // ここまでが4コマンドボタン

    graphics.setColor(Color.red); // ここから4行間が自機の動き
    graphics.fillRect(playerX, 600, 30, 30);
    if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT)) playerX -= 200;                   //なぜかここで動かしてる....
    if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) playerX += 200;

    if (Keyboard.isKeyPressed(KeyEvent.VK_ENTER)) {
      graphics.setColor(Color.white);
      Font WhiteWindow = new Font("Sansserif", Font.BOLD, 20);
      graphics.setFont(WhiteWindow);
      graphics.drawString("ENEMY", 250, 350);
      return EnumShootingScreen.GAME1;
    }

    return EnumShootingScreen.START;
  }
}
