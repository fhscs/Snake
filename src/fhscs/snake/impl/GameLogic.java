package fhscs.snake.impl;

import java.awt.Point;

import fhscs.snake.Game;

/**
 * Handles the logic of the game.
 * Controls snake movement, score updating, and game ending.
 */
public class GameLogic implements Runnable {

    private final Game game;
    
    public GameLogic(Game game) {
        this.game = game;
    }
    
    @Override
    public void run() {
        game.getSnake().move();
        Point head = game.getSnake().getHead();
        game.getApple().eatApple(game.getSnake());
        //if outside
        if(game.getBoard().isOutside(head)){
            game.setRunning(false);
        } 
        
         else if(head.equals(game.getApple())) {
            game.getSnake().elongate();
            game.getBoard().incrementScore();
            game.getApple().eatApple(game.getSnake());
            //new apple
          
            
        }
        
    }
    
}
