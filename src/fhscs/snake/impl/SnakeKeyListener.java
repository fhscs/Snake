package fhscs.snake.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fhscs.snake.Game;
import fhscs.snake.Movement;

public class SnakeKeyListener implements KeyListener {

    private final Game game;
    
    public SnakeKeyListener(Game game) {
        this.game = game;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        Movement movement = getMovement(e.getKeyCode());
        if(movement != null) {
            game.getSnake().setMovement(movement);
        }
    }
    
    private Movement getMovement(int keyCode) {
        switch(keyCode) {
            case KeyEvent.VK_LEFT:
                return Movement.WEST;
            case KeyEvent.VK_RIGHT:
                return Movement.EAST;
            case KeyEvent.VK_UP:
                return Movement.NORTH;
            case KeyEvent.VK_DOWN:
                return Movement.SOUTH;
            default:
                return null;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}
