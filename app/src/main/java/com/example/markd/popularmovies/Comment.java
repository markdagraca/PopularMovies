package com.example.markd.popularmovies;

import java.util.Date;
import java.util.List;

public class Comment {
   private String username,comment;
   private Date date;
   private int id;

    public Comment(String username, String comment, Date date, int id) {
        this.username = username;
        this.comment = comment;
        this.date = date;
        this.id = id;
    }
    public Comment()
    {

    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }
}
