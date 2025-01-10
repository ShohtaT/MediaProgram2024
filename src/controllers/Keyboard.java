package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

public class Keyboard extends KeyAdapter {

  private static HashSet<Integer> pressedButtons = new HashSet<>();

  // キーが押されているかを確認
  public static synchronized boolean isKeyPressed(int keyCode) {
    return pressedButtons.contains(keyCode);
  }

  @Override
  public synchronized void keyPressed(KeyEvent e) {
    pressedButtons.add(e.getKeyCode());
  }

  @Override
  public synchronized void keyReleased(KeyEvent e) {
    pressedButtons.remove(e.getKeyCode());
  }
}
