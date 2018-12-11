package com.example.markd.popularmovies;

import java.util.Date;

public class Movie {
    public Movie(String id, String posterUrl, String title, String description, float popularity, String releaseDate) {
        this.id = id;
        this.posterUrl = posterUrl;
        this.title = title;
        this.description = description;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
    }

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

    public float getPopularity() {
        return popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    private String id;//imdb id number
    private String posterUrl;
    private String title;
    private String description;
    private float popularity;
    private String releaseDate;




}
