package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class DrawPlayer extends JPanel{
    Image img= Toolkit.getDefaultToolkit().getImage("src/A.jpg");
    Image img_sans = Toolkit.getDefaultToolkit().getImage("src/B.jpg");
    public void paintComponent(int playerX,int playerY,Graphics g){
        super.paintComponent(g);
        g.drawImage(img, playerX, playerY, this);
    }
        
    public void paintSans(int playerX,int playerY,Graphics g){
            super.paintComponent(g);
            g.drawImage(img_sans, playerX, playerY, this);
        }
}