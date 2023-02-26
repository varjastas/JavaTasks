package com.javarush.games.snake;

import java.util.ArrayList;
import java.util.List;
import com.javarush.engine.cell.*;
public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";

    private static final String BODY_SIGN = "\u26AB";

    public boolean isAlive = true;

    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        GameObject temp = snakeParts.get(0);
        GameObject temp1 = snakeParts.get(1);

        if ((this.direction == Direction.LEFT | this.direction == Direction.RIGHT) & temp.x == temp1.x){
            return;
        }
        if ((this.direction == Direction.UP | this.direction == Direction.DOWN) & temp.y == temp1.y){
            return;
        }
        if ((direction == Direction.UP & this.direction != Direction.DOWN)
                | (direction == Direction.DOWN & this.direction != Direction.UP)
                | (direction == Direction.LEFT & this.direction != Direction.RIGHT)
                | (direction == Direction.RIGHT & this.direction != Direction.LEFT)){

            this.direction = direction;
        }

    }

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game){
        Color color = isAlive ? Color.BLACK : Color.RED;
        GameObject head = snakeParts.get(0);
        game.setCellValueEx(head.x, head.y, Color.NONE, HEAD_SIGN, color, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            GameObject part = snakeParts.get(i);
            game.setCellValueEx(part.x, part.y, Color.NONE, BODY_SIGN, color, 75);
        }
    }



    public void move(Apple apple){

        GameObject newHead = createNewHead();
        if (newHead.x >= SnakeGame.WIDTH
                || newHead.x < 0
                || newHead.y >= SnakeGame.HEIGHT
                || newHead.y < 0
                || checkCollision(newHead)){
            isAlive = false;
            return;
        }
        snakeParts.add(0, newHead);
        if (newHead.x == apple.x & newHead.y == apple.y) {
            apple.isAlive = false;
        } else {
            removeTail();
        }




    }

    public GameObject createNewHead(){
        GameObject previousHead = snakeParts.get(0);
        switch (direction){
            case LEFT: {
                return new GameObject(previousHead.x - 1, previousHead.y);
            }
            case RIGHT: {
                return new GameObject(previousHead.x + 1, previousHead.y);
            }
            case UP: {
                return new GameObject(previousHead.x, previousHead.y - 1);
            }
            case DOWN: {
                return new GameObject(previousHead.x, previousHead.y + 1);
            }
        }
        return null;
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject part){
        for (GameObject i: snakeParts) {
            if (i.y == part.y & i.x == part.x ){
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }
}
