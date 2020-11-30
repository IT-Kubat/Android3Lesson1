package com.example.android3lesson1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android3lesson1.R;
import com.example.android3lesson1.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiGameAdapter.CardCallback  {

    private RecyclerView emojiRecycler;
    private EmojiGameAdapter emojiGameAdapter;
    private EmojiGame emojiGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiRecycler = findViewById(R.id.rv_cards);
        emojiGame = new EmojiGame();
        emojiGameAdapter = new EmojiGameAdapter(emojiGame, this);
        emojiRecycler.setAdapter(emojiGameAdapter);

    }

    @Override
    public void choose(Card<String> card) {
        emojiGame.choose(card);
        emojiGameAdapter.notifyDataSetChanged();
    }
}