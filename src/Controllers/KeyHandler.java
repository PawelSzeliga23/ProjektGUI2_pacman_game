package Controllers;

import Components.CustomJTable;
import Data.Hero;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upAction;
    public boolean downAction;
    public boolean leftAction;
    public boolean rightAction;
    private final Hero hero;
    private final CustomJTable table;

    public KeyHandler(Hero hero, CustomJTable table) {
        this.hero = hero;
        this.table = table;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int heroPositionX = hero.getHeroPositionX();
        int heroPositionY = hero.getHeroPositionY();
        switch (keyCode) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                if (heroPositionY - 1 >= 0 && (int) (table.getValueAt(heroPositionY - 1, heroPositionX)) > 98) {
                    upAction = true;
                    downAction = false;
                    leftAction = false;
                    rightAction = false;
                }
            }
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                if (heroPositionY + 1 < table.getRowCount() && (int) (table.getValueAt(heroPositionY + 1, heroPositionX)) > 98) {
                    upAction = false;
                    downAction = true;
                    leftAction = false;
                    rightAction = false;
                }
            }
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                if (heroPositionX + 1 >= 0 && (int) (table.getValueAt(heroPositionY, heroPositionX + 1)) > 98) {
                    upAction = false;
                    downAction = false;
                    leftAction = false;
                    rightAction = true;
                }
            }
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                if (heroPositionY - 1 < table.getRowCount() && (int) (table.getValueAt(heroPositionY, heroPositionX - 1)) > 98) {
                    upAction = false;
                    downAction = false;
                    leftAction = true;
                    rightAction = false;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
