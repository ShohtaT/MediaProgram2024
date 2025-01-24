package views;

import controllers.Game1Controller;
import models.EnumShootingScreen;
import models.Player;
import models.Enemy;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
import views.DrawPlayer;
public class Game1View {
  ArrayList<Enemy>enemies_up = new ArrayList<>();
  ArrayList<Enemy>enemies_down = new ArrayList<>();

  boolean guard = false;
  int time =0;
  DrawPlayer drawsans = new DrawPlayer();
  private final Game1Controller controller;
  public BufferedImage image;
  public Player player = new Player(640, 360, 0);
  public Game1View(Game1Controller controller) {
    this.controller = controller;
    this.image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
  }

  public EnumShootingScreen render(Graphics graphics) {
     time++;

    // 枠(黒、白のfillRectを時期の奥になるよう、ここに記述)
    graphics.setColor(Color.white);
    graphics.fillRect(400, 300, 500, 300);
    graphics.setColor(Color.black);
    graphics.fillRect(410, 310, 480, 280);

    drawsans.paintSans(580, 30, graphics);

    //playerの動き
    player.Show_Move(graphics, 7);
    player.remove_Gravity();
    //
    
//敵の動き
              for(int i = 0;i<enemies_up.size();i++){
               Enemy enemy = enemies_up.get(i);
               enemy.up_Enemy(5);
               enemy.Show_enemy(graphics, 480, 10);
               if(enemy.y<=0)enemies_up.remove(i);
                  if(!(enemy.x +480 <player.get_playerX() || player.get_playerX()+30<enemy.x ||enemy.y+10 <player.get_playerY() || player.get_playerY() +30<enemy.y)){
                      if(!guard){
                          player.Down_HP(20);
                          guard = true; // mutekizikannhuyo
                          new Timer(5000, e -> guard = false).start(); // 5byougo,mutekikaizyo
                         if(player.return_HP()==0){return EnumShootingScreen.GAME_OVER;}// HP==0de,GAMEOVER
                      }
                  }
              }
             
              for(int i = 0;i<enemies_down.size();i++){
                Enemy enemy = enemies_down.get(i);
                enemy.Show_enemy(graphics, 480, 10);
                enemy.down_Enemy(5);;
                if(enemy.y>580)enemies_down.remove(i);
                if(!(enemy.x +480 <player.get_playerX() || player.get_playerX()+30<enemy.x ||enemy.y+10 <player.get_playerY() || player.get_playerY() +30<enemy.y)){
                  if(!guard){
                      player.Down_HP(20);
                      guard = true; // mutekizikannhuyo
                      new Timer(5000, e -> guard = false).start(); // 5byougo,mutekikaizyo
                      if(player.return_HP()==0){return EnumShootingScreen.GAME_OVER;}// HP==0de,GAMEOVER
                  }
              }
            }
            
            
            if(time%40 == 0){
               enemies_up.add(new Enemy(650,720));
               enemies_down.add(new Enemy(170,0));
              }
//
 




// HPバー
    graphics.setColor(Color.yellow);
    graphics.fillRect(420, 610, 4*player.return_HP(), 25);

    graphics.setColor(Color.red);

    // TODO: Not implemented yet for Game1
    if(time >=500)return EnumShootingScreen.START_MENU;
     return EnumShootingScreen.GAME1;
  }
 
}
