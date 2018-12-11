package com.example.markd.popularmovies;

import java.util.ArrayList;

public class Movie {

    public Movie(String id, String posterUrl, String title, String description, int movieDbID, String backdropPath, String releaseDate, String video, ArrayList<Integer> similarMovie) {
        this.id = id;
        this.posterUrl = posterUrl;
        this.title = title;
        this.description = description;
        this.movieDbID = movieDbID;
        this.backdropPath = backdropPath;
        this.releaseDate = releaseDate;
        this.video = video;
        this.similarMovie = similarMovie;
    }
    private String id;//imdb id number
    private String posterUrl;
    private String title;
    private String description;
    private int movieDbID;
    private String backdropPath;
    private String releaseDate;
    private String video;

    public String getId() {
        return id;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getMovieDbID() {
        return movieDbID;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getVideo() {
        return video;
    }
    private ArrayList<Integer> similarMovie;


    public ArrayList<Integer> getSimilarMovie() {
        return similarMovie;
    }
}
