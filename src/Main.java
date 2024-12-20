//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.awt.*;

import controllers.Game2Controller;
import controllers.StartController;
import controllers.Game1Controller;
import views.ShootingFrame;
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
    EnumShootingScreen screen = EnumShootingScreen.START;
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
      gra.fillRect(0, 0, 1280, 720); //背景色

      switch (screen) { //ここでゲームの画面を変更する。
        //--------------------------------------------START画面---------------------------------------------------
        case START:
          screen = StartController.call(gra);
          break;
        //--------------------------------------------GAME本編------------------------------------------------------
        case GAME1:
          screen = Game1Controller.call(gra);
          break;
        //------------------------------------------------------------------------------------------------------------
        case GAME2:
          screen = Game2Controller.call(gra);
          break;
        //--------------------------------------------GAMEOVER-------------------------------------------------------
        case GAME_OVER:
          break;
        //--------------------------------------------FINISH-------------------------------------------------------
        case FINISH:
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
