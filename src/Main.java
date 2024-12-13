//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import views.ShootingFrame;
import controllers.Keyboard;
import models.Enemy;
import models.EnumShootingScreen;

public class Main {
  public static ShootingFrame shootingFrame;
  public static boolean loop;

  public static void main(String[] args) {

    shootingFrame = new ShootingFrame();
    loop = true;


    Graphics gra = shootingFrame.panel.image.getGraphics();
    long startTime;           //FPS処理のための初めの時間
    long fpsTime = 0;
    int fps = 30;
    int FPS = 0;
    int FPSCount = 0;
    int HP = 100; // HP(初期体力100)
    boolean guard = false; // 無敵時間の変数(if0で普通、if1で無敵)
    boolean gravity_system = true;
    boolean gravity = true;
    EnumShootingScreen screen = EnumShootingScreen.START;
    //GAMEに使う関数
    int playerX, playerY;
    int move;
    ArrayList<Enemy> enemies_up = new ArrayList<>();
    ArrayList<Enemy> enemies_down = new ArrayList<>();
    playerX = 640;
    playerY = 560;
    Random random = new Random();
    int time = 0;
    int gravity_time = 0;
    //------------------------------------------------------------------------------------
    //ここからゲームの動きをループで再現
    while (loop) {
      if ((System.currentTimeMillis() - fpsTime) > 1000) {
        fpsTime = System.currentTimeMillis();
        FPS = FPSCount;
        //System.out.println(FPS);
        FPSCount = 0;
      }
      FPSCount++;
      startTime = System.currentTimeMillis();


      gra.setColor(Color.BLACK);
      gra.fillRect(0, 0, 1280, 720);                                     //背景色


      switch (screen) {                                                     //ここでゲームの画面を変更する。
        //--------------------------------------------START画面---------------------------------------------------
        case START:
          gra.setColor(Color.WHITE);
          Font font = new Font("SansSelif", Font.PLAIN, 40);
          gra.setFont(font);
          FontMetrics metrics = gra.getFontMetrics(font);
          gra.drawString("yamamoto_1205.Shooting", 640 - (metrics.stringWidth("yamamoto_1205.Shooting") / 2), 300);
          font = new Font("SansSelif", Font.PLAIN, 20);
          metrics = gra.getFontMetrics(font);
          gra.drawString("Press SPACE to Start", 540 - (metrics.stringWidth("Press SPACE to Start") / 2), 500);          //無理やりで真ん中に持ってきてる
          if (Keyboard.isKeyPressed(KeyEvent.VK_SPACE)) {
            screen = EnumShootingScreen.GAME1;
            enemies_down = new ArrayList<>();
            enemies_up = new ArrayList<>();                               //一応初期化
            playerX = 640;
            playerY = 360;
            time = 100;
          }

          break;
        //--------------------------------------------GAME本編------------------------------------------------------
        case GAME1:

          // 枠(黒、白のfillRectを時期の奥になるよう、ここに記述)
          gra.setColor(Color.white);
          gra.fillRect(400, 300, 500, 300);
          gra.setColor(Color.black);
          gra.fillRect(410, 310, 480, 280);


          gra.setColor(Color.yellow); // HPバー
          gra.fillRect(420, 610, HP * 4, 25);


          gra.setColor(Color.red);
          for (int i = 0; i < enemies_down.size(); i++) {
            Enemy enemy = enemies_down.get(i);
            gra.fillRect(enemy.x, enemy.y, 480, 10);
            enemy.y += 10;
            if (enemy.y > 580) enemies_down.remove(i);
            if (!(enemy.x + 480 < playerX || playerX + 30 < enemy.x || enemy.y + 10 < playerY || playerY + 30 < enemy.y)) {
              HP -= 1; // 1hitHP20減少
              if (HP == 0) {
                screen = EnumShootingScreen.GAME_OVER;
              }
            }
          }
          if (time % 30 == 0) {
            enemies_down.add(new Enemy(170, 0));
          }

          gra.setColor(Color.red);
          for (int i = 0; i < enemies_up.size(); i++) {
            Enemy enemy = enemies_up.get(i);
            gra.fillRect(enemy.x, enemy.y, 480, 10);
            enemy.y -= 10;
            if (enemy.y <= 0) enemies_up.remove(i);
            if (!(enemy.x + 480 < playerX || playerX + 30 < enemy.x || enemy.y + 10 < playerY || playerY + 30 < enemy.y)) {
              HP -= 1; // 1hitHP20減少
              if (HP == 0) {
                screen = EnumShootingScreen.GAME_OVER;
              }
            }
          }
          if (time % 30 == 0) {
            enemies_up.add(new Enemy(650, 720));
          }
          time++;


          gra.setColor(Color.RED);
          gra.fillRect(playerX, playerY, 30, 30);
          if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX > 410)
            playerX -= 10;                   //なぜかここで動かしてる....
          if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX < 860) playerX += 10;
          if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY > 310) playerY -= 10;
          if (Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && playerY < 560) playerY += 10;
          if (time == 500) {
            screen = EnumShootingScreen.GAME2;
            enemies_down = new ArrayList<>();
            enemies_up = new ArrayList<>();                               //一応初期化
            playerX = 640;
            playerY = 390;
            time = 100;
            gravity_time = 0;
          }
          break;
        //------------------------------------------------------------------------------------------------------------
        case GAME2:
          gra.setColor(Color.white);
          gra.fillRect(400, 300, 500, 300);
          gra.setColor(Color.black);
          gra.fillRect(410, 310, 480, 280);


          gra.setColor(Color.yellow); // HPバー
          gra.fillRect(420, 610, HP * 4, 25);
          gra.setColor(Color.blue);
          gra.fillRect(playerX, playerY, 30, 30);
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
          break;
        //--------------------------------------------GAMEOVER-------------------------------------------------------
        case GAME_OVER:
          break;
      }


      gra.setFont(new Font("SansSerif", Font.PLAIN, 10));
      gra.drawString(FPS + "FPS", 0, 620);


      shootingFrame.panel.draw();


      try {
        long runTime = System.currentTimeMillis() - startTime;
        if (runTime <= (1000 / fps)) {
          Thread.sleep(1000 / fps - (runTime));
        }
        //ここでFpsの設定
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //System.out.println(System.currentTimeMillis()-startTime);               //FPSの値を出力。33くらいが目安。
    }
  }
}

