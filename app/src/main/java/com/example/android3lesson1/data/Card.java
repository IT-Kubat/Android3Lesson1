 package com.example.android3lesson1.data;

import android.os.Build;

import java.util.Objects;

public class Card<T> {
    private int id;
    private boolean isFaceUp;
    private boolean isMatched;
    private T content;

    public Card(boolean isFaceUp, boolean isMatched, T content, int id) {
        this.isFaceUp = isFaceUp;
        this.isMatched = isMatched;
        this.content = content;
        this.id = id;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void setFaceUp(boolean faceUp) {
        isFaceUp = faceUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return id == card.id &&
                isFaceUp == card.isFaceUp &&
                isMatched == card.isMatched &&
                content.equals(card.content);
    }

    @Override
    public int hashCode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.hash(id, isFaceUp, isMatched, content);
        }
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "isFaceUp=" + isFaceUp +
                ", isMatched=" + isMatched +
                ", content=" + content +
                '}';
    }
}
