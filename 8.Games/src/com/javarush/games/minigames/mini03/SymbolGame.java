package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Простая программа
*/

public class SymbolGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(8, 3);
        String[] word = new String[]{"J","A","V","A","R","U","S","H",};
        for (int i = 0; i < word.length; i++) {
            setCellValueEx(i, 1, Color.ORANGE, word[i]);
        }
    }

}
