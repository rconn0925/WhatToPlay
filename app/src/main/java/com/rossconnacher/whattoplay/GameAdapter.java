package com.rossconnacher.whattoplay;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross on 6/2/2017.
 */

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder> {
    private Context mContext;
    private List<Game> mGames;

    public GameAdapter(Context context, ArrayList<Game> games){
        mContext = context;
        mGames = games;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.game_item, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        final Game game = mGames.get(position);
        holder.gameGenre.setText(game.getGenres().toString());
        holder.gameTitle.setText(game.getName());
        holder.gamePlatforms.setText(game.getPlatforms().toString());
        holder.gameRating.setText("Rating: " + game.getRating());
        holder.gameReleaseData.setText("Date: "+ game.getReleaseDate());
        Picasso.with(mContext).load(game.getImageUrl()).into(holder.gameImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
