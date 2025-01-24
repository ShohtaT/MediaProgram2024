package controllers;

import java.awt.event.KeyEvent;

import models.StartCursor;

public class StartCursorController {
  StartCursor cursor = new StartCursor();

  public void handleInput() {
    if (Keyboard.isKeyPressed(KeyEvent.VK_LEFT)) {
      this.left();
    }
    if (Keyboard.isKeyPressed(KeyEvent.VK_RIGHT)) {
      this.right();
    }
  }

  public boolean isEnterPressed() {
    return Keyboard.isKeyPressed(KeyEvent.VK_ENTER);
  }

  public StartCursor getCursor() {
    return cursor;
  }

  public void right() {
    if (cursor.x >= 840) return;
    cursor.x += 200;
  }

  public void left() {
    if (cursor.x <= 240) return;
    cursor.x -= 200;
  }
}
