package com.example.markd.popularmovies;

import java.util.Date;

public class Movie {
<<<<<<< HEAD
    public Movie(String id, String posterUrl, String title, String description, double popularity, String releaseDate) {
=======
    public Movie(String id, String posterUrl, String title, String description, float popularity, Date releaseDate) {
>>>>>>> dec714f06e996c9fa1732203cfb5bc59787a8f26
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

<<<<<<< HEAD
    public double getPopularity() {
        return popularity;
    }

    public String getReleaseDate() {
=======
    public float getPopularity() {
        return popularity;
    }

    public Date getReleaseDate() {
>>>>>>> dec714f06e996c9fa1732203cfb5bc59787a8f26
        return releaseDate;
    }

    private String id;//imdb id number
    private String posterUrl;
    private String title;
    private String description;
<<<<<<< HEAD
    private double popularity;
    private String releaseDate;
=======
    private float popularity;
    private Date releaseDate;
>>>>>>> dec714f06e996c9fa1732203cfb5bc59787a8f26




}
