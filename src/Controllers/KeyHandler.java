package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upAction;
    public boolean downAction;
    public boolean leftAction;
    public boolean rightAction;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_W-> {
                upAction = true;
                downAction = false;
                leftAction = false;
                rightAction = false;
            }
            case KeyEvent.VK_S-> {
                upAction = false;
                downAction = true;
                leftAction = false;
                rightAction = false;

            }
            case KeyEvent.VK_D-> {
                upAction = false;
                downAction = false;
                leftAction = false;
                rightAction = true;

            }
            case KeyEvent.VK_A-> {
                upAction = false;
                downAction = false;
                leftAction = true;
                rightAction = false;

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
