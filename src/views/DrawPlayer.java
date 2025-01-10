

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
class DrawPlayer extends JPanel{
    Image img= Toolkit.getDefaultToolkit().getImage("A.jpg");
    public void paintComponent(int playerX,int playerY,Graphics g){
        super.paintComponent(g);
        g.drawImage(img, playerX, playerY, this);
    }
}