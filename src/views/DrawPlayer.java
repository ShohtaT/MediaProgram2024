package views;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Objects;

public class DrawPlayer extends JPanel {
  private Image img;
  private Image img_sans;

  // コンストラクタで画像をロード
  public DrawPlayer() {
    try {
      img = ImageIO.read(Objects.requireNonNull(getClass().getResource("./A.jpg")));
      img_sans = ImageIO.read(Objects.requireNonNull(getClass().getResource("./B.jpg")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }catch (NullPointerException e) {
      e.printStackTrace();
      System.out.println("画像ファイルが JAR に含まれていないか、パスが間違っています。");
    }
  }

  public void paintComponent(int playerX, int playerY, Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, playerX, playerY, this);
  }

  public void paintSans(int playerX, int playerY, Graphics g) {
    super.paintComponent(g);
    g.drawImage(img_sans, playerX, playerY, this);
  }
}
