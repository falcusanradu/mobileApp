package com.movie.movieapp.src.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Arrays;
import java.util.List;

@Entity
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private Integer idMovie;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "note")
    private Integer note;

    @ColumnInfo(name = "status")
    private String status;


    public Movie(Integer idMovie, String name, String description, String genre, Integer note, String status) {
        this.idMovie = idMovie;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.note = note;
        this.status = status;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}








