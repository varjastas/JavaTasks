package com.javarush.games.snake;
import com.javarush.engine.cell.*;
public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;

    private Apple apple;
    private boolean isGameStopped;
    private final static int GOAL = 28;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
        score = 0;
        setScore(score);
    }

    private void drawScene(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                setCellValueEx(j, i, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);

        if (!apple.isAlive){
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive){
            gameOver();
            
        }
        if (snake.getLength() > GOAL){
            win();

        }
        drawScene();

    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case UP: {
                snake.setDirection(Direction.UP);
                break;
            } case DOWN: {
                snake.setDirection(Direction.DOWN);
                break;
            } case RIGHT: {
                snake.setDirection(Direction.RIGHT);
                break;
            } case LEFT: {
                snake.setDirection(Direction.LEFT);
                break;
            } case SPACE:{
                if (isGameStopped){
                    createGame();
                }
            }

        }
    }

    private void createNewApple(){

        while (snake.checkCollision(apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT))) != false){

        }
    }

    private void gameOver(){
        stopTurnTimer();
        this.isGameStopped = true;
        showMessageDialog(Color.CADETBLUE, "GAME OVER", Color.BURLYWOOD, 75);
    }
    private void win(){
        stopTurnTimer();
        this.isGameStopped = true;
        showMessageDialog(Color.CADETBLUE, "YOU WIN", Color.BURLYWOOD, 75);
    }
}
