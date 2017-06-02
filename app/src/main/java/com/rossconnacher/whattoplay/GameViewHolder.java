package com.rossconnacher.whattoplay;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Ross on 6/2/2017.
 */

public class GameViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.gameTitle)
    public TextView gameTitle;
    @InjectView(R.id.gameGenre)
    public TextView gameGenre;
    @InjectView(R.id.gamePlatforms)
    public TextView gamePlatforms;
    @InjectView(R.id.gameRating)
    public TextView gameRating;
    @InjectView(R.id.gameReleaseDate)
    public TextView gameReleaseData;
    @InjectView(R.id.gameImage)
    public ImageView gameImage;


    public GameViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this, itemView);
    }
}
