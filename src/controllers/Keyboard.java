package controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;

public class Keyboard extends KeyAdapter implements KeyListener {

  private static ArrayList<Integer> pressedButtons = new ArrayList<>();

  public static boolean isKeyPressed(int keyCode) {
    return pressedButtons.contains(keyCode);

  }

  @Override
  public void keyPressed(KeyEvent e) {
    super.keyPressed(e);
    if (!pressedButtons.contains(e.getKeyCode())) pressedButtons.add(e.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent e) {
    super.keyReleased(e);
    pressedButtons.remove((Integer) e.getKeyCode());
  }
}
