package models;

import java.awt.Color;
import java.awt.*;

public class Enemy {
  public int x, y;

  public Enemy(int x,int y){
    this.x = x;
    this.y = y;
}
public int get_enemyX(){
    return x;
}
public int get_enemyY(){
    return y;
}

 public  void up_Enemy(int speed){
    y = y-speed;
}
public void down_Enemy(int speed){
    y = y+speed;
}
public void right_Enemy(int speed){
    x = x-speed;
}
public void left_Enemy(int speed){
    x = x+speed;
}
public void Show_enemy(Graphics g,int width,int hight){
    g.setColor(Color.WHITE);
    g.fillRect(x,y, width, hight); 
}
}
