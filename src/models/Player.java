package models;

import controllers.Keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Keyboard {
  public int playerX;
  public int playerY;
  public int speed;
  public int apper_time;
  public int gravity_time;
  public boolean gravity;

  public Player(int x, int y, int apper_time) {
    this.playerX = x;
    this.playerY = y;
    this.apper_time = apper_time;
    this.gravity_time = 0;
    this.gravity = true;
  }

  public void set_player(int x, int y) {
    playerX = x;
    playerY = y;
  }

  public int get_playerX() {
    return playerX;
  }

  public int get_playerY() {
    return playerY;
  }

  public void up_player(int speed) {
    playerY = playerY - speed;
  }

  public void down_player(int speed) {
    playerY = playerY + speed;
  }

  public void right_player(int speed) {
    playerX = playerX + speed;
  }

  public void left_player(int speed) {
    playerX = playerX - speed;
  }

  public void Show_Move(Graphics g, int speed) {
    g.setColor(Color.BLUE);
    g.fillRect(playerX, playerY, 30, 30);
    if (gravity == false) {
      if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX > 410) left_player(speed);
      if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX < 860) right_player(speed);
      ;
      if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY > 310) up_player(speed);
      if (Keyboard.isKeyPressed(KeyEvent.VK_DOWN) && playerY < 560) down_player(speed);
    }

    if (gravity == true) {
      if (playerY < 560) {
        gravity_time++;
        playerY += (gravity_time) * (gravity_time) / 10;
      }
      if (playerY == 560) {
        gravity_time = 0;
      }
      if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT) && playerX > 410) left_player(speed);
      if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT) && playerX < 860) right_player(speed);
      if (Keyboard.isKeyPressed(KeyEvent.VK_UP) && playerY > 310) up_player(20);
      if (playerY > 560) {
        playerY = 560;
      }
    }
  }

  public void set_Gravity() {
    gravity = true;
  }

  public void remove_Gravity() {
    gravity = false;
  }
}
