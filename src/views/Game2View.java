package views;

import controllers.Game2Controller;
import models.EnumShootingScreen;
import models.Player;
import models.Enemy;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.ArrayList;
public class Game2View {
  ArrayList<Enemy>enemies_1 = new ArrayList<>();
  ArrayList<Enemy>enemies_2 = new ArrayList<>();
  ArrayList<Enemy>enemies_3 = new ArrayList<>();
  ArrayList<Enemy>enemies_4 = new ArrayList<>();
  DrawPlayer drawsans = new DrawPlayer();
  boolean guard = false;
  int time =0;

  private final Game2Controller controller;
  public BufferedImage image;
  public Player player = new Player(640, 360, 0);
  public Game2View(Game2Controller controller) {
    this.controller = controller;
    this.image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
  }

  public EnumShootingScreen render(Graphics graphics) {
     time++;
     drawsans.paintSans(580, 30, graphics);
    // 枠(黒、白のfillRectを時期の奥になるよう、ここに記述)
    graphics.setColor(Color.white);
    graphics.fillRect(400, 300, 500, 300);
    graphics.setColor(Color.black);
    graphics.fillRect(410, 310, 480, 280);

    //playerの動き
    player.Show_Move(graphics, 7);
    //

    //敵の動き
    for(int i = 0;i<enemies_1.size();i++){
      Enemy enemy = enemies_1.get(i);
      enemy.Show_enemy(graphics, 15, 50);
      enemy.left_Enemy(5);   
      if(enemy.y<=0)enemies_1.remove(i);
         if(!(enemy.x +15 <player.get_playerX() || player.get_playerX()+30<enemy.x ||enemy.y+50 <player.get_playerY() || player.get_playerY() +30<enemy.y)){
             if(!guard){
                 player.Down_HP(20);
                 guard = true; // mutekizikannhuyo
                 new Timer(5000, e -> guard = false).start(); // 5byougo,mutekikaizyo
                 if(player.return_HP()==0){return EnumShootingScreen.GAME_OVER;}// HP==0de,GAMEOVER
             }
         }
     }

     for(int i = 0;i<enemies_2.size();i++){
      Enemy enemy = enemies_2.get(i);
      enemy.Show_enemy(graphics, 15, 50);
      enemy.right_Enemy(5);
      if(enemy.y<=0)enemies_2.remove(i);
         if(!(enemy.x +15 <player.get_playerX() || player.get_playerX()+30<enemy.x ||enemy.y+50 <player.get_playerY() || player.get_playerY() +30<enemy.y)){
             if(!guard){
                 player.Down_HP(20);
                 guard = true; // mutekizikannhuyo
                 new Timer(5000, e -> guard = false).start(); // 5byougo,mutekikaizyo
                 if(player.return_HP()==0){return EnumShootingScreen.GAME_OVER;}// HP==0de,GAMEOVER
             }
         }
     }

     for(int i = 0;i<enemies_3.size();i++){
      Enemy enemy = enemies_3.get(i);
      enemy.Show_enemy(graphics, 15, 200);
      enemy.left_Enemy(5);
      if(enemy.y<=0)enemies_3.remove(i);
         if(!(enemy.x +15 <player.get_playerX() || player.get_playerX()+30<enemy.x ||enemy.y+200 <player.get_playerY() || player.get_playerY() +30<enemy.y)){
             if(!guard){
                 player.Down_HP(20);
                 guard = true; // mutekizikannhuyo
                 new Timer(5000, e -> guard = false).start(); // 5byougo,mutekikaizyo
                 if(player.return_HP()==0){return EnumShootingScreen.GAME_OVER;}// HP==0de,GAMEOVER
             }
         }
     }
     for(int i = 0;i<enemies_4.size();i++){
      Enemy enemy = enemies_4.get(i);
      enemy.Show_enemy(graphics, 15, 200);
      enemy.right_Enemy(5);    
      if(enemy.y<=0)enemies_4.remove(i);
         if(!(enemy.x +15 <player.get_playerX() || player.get_playerX()+30<enemy.x ||enemy.y+200 <player.get_playerY() || player.get_playerY() +30<enemy.y)){
             if(!guard){
                 player.Down_HP(20);
                 guard = true; // mutekizikannhuyo
                 new Timer(5000, e -> guard = false).start(); // 5byougo,mutekikaizyo
                 if(player.return_HP()==0){return EnumShootingScreen.GAME_OVER;}// HP==0de,GAMEOVER
             }
         }
     }


     if(time%60 == 0){
      enemies_1.add(new Enemy(0,550));
      enemies_2.add(new Enemy(1270,550));
      enemies_3.add(new Enemy(0,300));
      enemies_4.add(new Enemy(1270,300));
     }

 




// HPバー
    graphics.setColor(Color.yellow);
    graphics.fillRect(420, 610, 4*player.return_HP(), 25);

    graphics.setColor(Color.red);

    // TODO: Not implemented yet for Game1
    if(time ==500)return EnumShootingScreen.START_MENU;
    
     return EnumShootingScreen.GAME2;
  }
 
}
