package views;

import controllers.StartCursorController;
import models.EnumShootingScreen;

import java.awt.*;

public class StartView {
  private final StartCursorController controller;
  DrawPlayer drawsans = new DrawPlayer();
  public int phase =0;
  public StartView(StartCursorController controller) {
    this.controller = controller;
  }

  public EnumShootingScreen render(Graphics graphics) {
    int HP = 100; // HP(初期体力100)
 
    drawsans.paintSans(580, 30, graphics);
    // 背景の描画
    graphics.setColor(Color.white);
    graphics.fillRect(210, 300, 800, 150);
    graphics.setColor(Color.black);
    graphics.fillRect(220, 310, 780, 130);

    // HPバー
    graphics.setColor(Color.yellow);
    graphics.fillRect(460, 460, HP * 3, 25);
    graphics.setColor(Color.white);
    Font YourInfo = new Font("Serif", Font.BOLD, 30);
    graphics.setFont(YourInfo);
    graphics.drawString("YOU", 225, 480);
    graphics.drawString("LV ??", 325, 480);
    Font HPBar = new Font("Dialog", Font.BOLD, 20);
    graphics.setFont(HPBar);
    graphics.drawString("HP", 425, 480);
    graphics.drawString(" HP  /  100", 850, 480);

    // コマンドボタン
    for (int i = 0; i < 800; i += 200) {
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
    }

    // プレイヤーの描画
    graphics.setColor(Color.red);
    graphics.fillRect(controller.getCursor().getX(), 600, 30, 30); // Controller の Cursor を使用

    // Enterキーが押された場合の描画と遷移
    // FIXME: 今はどこを選択しても GAME1 に遷移するようになっている
    if (controller.isEnterPressed()) {
      
      switch (phase) {
        case 0:
        phase =phase +1;
          return EnumShootingScreen.GAME1;
        case 1:
        phase =phase +1;
          return EnumShootingScreen.GAME2;
        case 2:
        return EnumShootingScreen.FINISH;
      }
      
    }

    return EnumShootingScreen.START_MENU;
  }
}
