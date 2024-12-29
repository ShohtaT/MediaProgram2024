import controllers.Keyboard;
import controllers.StartCursorController;
import models.EnumShootingScreen;
import views.StartView;

import javax.swing.*;
import java.awt.*;

public class GameApp extends JPanel {
  private EnumShootingScreen screen = EnumShootingScreen.START; // 現在の画面状態
  private final StartCursorController startController;
  private final StartView startView;

  public GameApp() {
    this.startController = new StartCursorController();
    this.startView = new StartView(startController);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // 現在の画面に応じた描画処理
    switch (screen) {
      case START:
        screen = startView.render(g); // `render` メソッドで画面遷移を管理
        break;
      case GAME1:
        // TODO: Not implemented yet
        break;
      case GAME2:
        // TODO: Not implemented yet
        break;
      case GAME_OVER:
        // TODO: Not implemented yet
        break;
      case FINISH:
        // TODO: Not implemented yet
        break;
    }
  }

  public void run() {
    int fps = 60;
    long startTime;
    long frameTime = 1000 / fps;

    while (true) {
      startTime = System.currentTimeMillis();

      // 入力処理
      startController.handleInput();

      // 再描画
      repaint();

      // FPS制御
      long elapsedTime = System.currentTimeMillis() - startTime;
      if (elapsedTime < frameTime) {
        try {
          Thread.sleep(frameTime - elapsedTime);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Shooting Game");
    Keyboard keyboard = new Keyboard();
    frame.addKeyListener(keyboard);
    GameApp app = new GameApp();
    frame.add(app);
    frame.setSize(1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setFocusable(true);
    frame.setFocusTraversalKeysEnabled(false);

    app.run(); // ゲームループの実行
  }
}
