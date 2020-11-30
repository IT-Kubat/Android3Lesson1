package com.example.android3lesson1.data;

import java.util.ArrayList;
import java.util.List;

public class Game<CardContent> {

    private List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i * 2));
            cards.add(new Card<>(false, false, contents.get(i), i * 2+1));
        }
    }

    public void choose(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            checkPairs(card);
        }
    }

    private void checkPairs(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards) {
            if (anotherCard.getId() != card.getId()) {
                if (anotherCard.getContent().equals(card.getContent()) && anotherCard.isFaceUp()) {
                    anotherCard.setMatched(true);
                    card.setMatched(true);
                }
            }
        }
        removePairs();
    }

    private void removePairs() {
        List<Card<CardContent>> newList = new ArrayList<>(cards);
        for (Card<CardContent> card : cards) {
            if (card.isMatched()) newList.remove(card);
        }
        cards.clear();
        cards.addAll(newList);
    }


    public List<Card<CardContent>> getCards() {
        return cards;
    }
}
