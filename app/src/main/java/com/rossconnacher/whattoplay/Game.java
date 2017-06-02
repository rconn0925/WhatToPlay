package com.rossconnacher.whattoplay;

import java.util.Date;

/**
 * Created by Ross on 6/2/2017.
 */

public class Game {

    private int id;
    private String name;
    private String[] genres;
    private long releaseDate;
    private String[] platforms;
    private double rating;
    private double aggregatedRating;
    private double popularity;
    private String imageUrl;
    private String summary;
    private String[] playerPerspectives;
    private String videoUrl;
    //private


    public Game(int id,String name,String[] genres,long releaseDate,String[] platforms,
                double rating,double aggregatedRating,double popularity, String imageUrl,
                String summary,String[] playerPerspectives,String videoUrl){

        this.id = id;
        this.name = name;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.platforms = platforms;
        this.rating = rating;
        this.aggregatedRating = aggregatedRating;
        this.popularity = popularity;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.playerPerspectives = playerPerspectives;
        this.videoUrl = videoUrl;

    }

    public double getAggregatedRating() {
        return aggregatedRating;
    }

    public int getId() {
        return id;
    }

    public double getPopularity() {
        return popularity;
    }

    public double getRating() {
        return rating;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String[] getGenres() {
        return genres;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public String[] getPlayerPerspectives() {
        return playerPerspectives;
    }
}
