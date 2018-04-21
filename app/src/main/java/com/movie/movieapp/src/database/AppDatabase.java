package com.movie.movieapp.src.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.movie.movieapp.src.dao.MovieDao;
import com.movie.movieapp.src.dao.UserDao;
import com.movie.movieapp.src.model.Movie;
import com.movie.movieapp.src.model.User;

@Database(entities = {User.class, Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract MovieDao movieDao();
}