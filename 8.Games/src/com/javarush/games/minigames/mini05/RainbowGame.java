package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(10, 7);
        drawRainbow();
    }

    private void drawRainbow(){
        Color[] colors = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET};
        int counter = 0;
        for (Color i: colors) {
            for (int j = 0; j < getScreenWidth(); j++) {
                setCellColor(j, counter, i);

            }
            counter += 1;
        }
    }
}
