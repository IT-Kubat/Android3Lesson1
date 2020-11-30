package com.example.android3lesson1.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1.R;
import com.example.android3lesson1.data.Card;

import java.security.PrivilegedAction;

public class EmojiGameAdapter extends RecyclerView.Adapter<EmojiGameAdapter.EmojiHolder> {

    private EmojiGame game;
    private final CardCallback cardCallback;

    public EmojiGameAdapter(EmojiGame game, CardCallback cardCallback) {

        this.game = game;
        this.cardCallback = cardCallback;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emoji_card, parent, false);
        return new EmojiHolder(view, cardCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    static class EmojiHolder extends RecyclerView.ViewHolder {

        private final TextView content;
        private CardCallback cardCallback;


        public EmojiHolder(@NonNull View itemView, CardCallback cardCallback) {
            super(itemView);
            content = itemView.findViewById(R.id.tv_card_emoji);
            this.cardCallback = cardCallback;
        }

        public void bind(final Card<String> card) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cardCallback.choose(card);
                }
            });
            if (card.isFaceUp()) {
                content.setText(card.getContent());
                itemView.setBackgroundColor(Color.WHITE);
            } else {
                content.setText("");
                itemView.setBackgroundColor(Color.BLUE);
            }
        }
    }
    interface CardCallback {
        void choose (Card<String> card);
    }
}