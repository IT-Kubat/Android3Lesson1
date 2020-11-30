package com.example.android3lesson1.ui;

import com.example.android3lesson1.data.Card;
import com.example.android3lesson1.data.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmojiGame {

    private final Game<String> game;

    public EmojiGame(){

        List<String> content = new ArrayList<>();
            content.add("\uD83D\uDC4B");
            content.add("\uD83D\uDC4D");
            content.add("✊");
            content.add("\uD83E\uDD1D");
            content.add("\uD83D\uDCAA");


              Collections.shuffle(content);
        game = new Game<>(content);
    }

    public void choose (Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();

    }
}
