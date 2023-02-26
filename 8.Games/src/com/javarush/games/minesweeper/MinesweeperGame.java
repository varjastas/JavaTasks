package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles  = SIDE * SIDE;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellValueEx(x, y, Color.ORANGE, "");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();

    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
    private void countMineNeighbors(){
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                GameObject cell = gameField[y][x];
                if (cell.isMine){
                    continue;
                }

                for (GameObject i: getNeighbors(cell)) {
                    if (i.isMine){
                        cell.countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y){
        GameObject cell = gameField[y][x];
        if (cell.isOpen | cell.isFlag | isGameStopped){
            return;
        }
        cell.isOpen = true;
        setCellColor(x, y, Color.GREEN);
        if (cell.countMineNeighbors == 0 & !cell.isMine){
            for (GameObject i: getNeighbors(cell)) {
                openTile(i.x, i.y);
            }
        }
        if (cell.isMine){
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            countClosedTiles --;
            score += 5;
            setScore(score);
            if (cell.countMineNeighbors != 0) {
                setCellNumber(x, y, cell.countMineNeighbors);
            } else {
                setCellValue(x, y, "");
            }
            if (countClosedTiles == countMinesOnField){
                win();
            }
        }

    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped){
            restart();
        }
        else {
            openTile(x, y);
        }
    }

    private void markTile(int x, int y){
        GameObject cell = gameField[y][x];
        if (cell.isOpen | isGameStopped ){
            return;
        }

        if (cell.isFlag){
            countFlags++;
            cell.isFlag = false;
            setCellValueEx(x, y, Color.ORANGE, "");
        } else if (countFlags > 0) {
            countFlags--;

            cell.isFlag = true;
            setCellValueEx(x, y, Color.YELLOW, FLAG);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.AQUA, "You lost", Color.BLACK, 80);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.AQUA, "You win", Color.BLACK, 80);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(0);

        createGame();
    }
}