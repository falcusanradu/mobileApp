package com.movie.movieapp.src.mockdata;

import android.arch.persistence.room.Room;

import com.movie.movieapp.src.dao.MovieDao;
import com.movie.movieapp.src.dao.UserDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.model.Movie;
import com.movie.movieapp.src.model.User;

import java.util.List;

public class DataHelper {


    public static void insertMovies(AppDatabase db) {
        final MovieDao movieDao = db.movieDao();
        Movie m1 = new Movie(1, "movie1", "a", "horror", 8, "status");
        Movie m2 = new Movie(2, "movie1", "descrdsadasiption1", "horrasdasdsadsaor", 8, "status");
        Movie m3 = new Movie(3, "movie1", "d", "horror", 8, "status");
        Movie m4 = new Movie(4, "movie1", "description1", "horror", 8, "status");
        Movie m5 = new Movie(5, "movie1", "description1", "horror", 8, "status");
        Movie m6 = new Movie(6, "asdasdasdsadsadasd", "description1", "horror", 8, "status");
        Movie m7 = new Movie(7, "movie1", "description1", "horror", 8, "status");
        Movie m8 = new Movie(8, "movie1", "dsa", "horror", 8, "status");
        Movie m11 = new Movie(9, "asd", "description1", "horror", 8, "status");
        Movie m10 = new Movie(10, "movie1", "asdas", "horror", 8, "status");
        Movie m9 = new Movie(11, "movie1", "descripddsadtion1", "horror", 8, "status");
        Movie m12 = new Movie(12, "movie1", "description1", "horror", 8, "status");
        Movie m13 = new Movie(13, "asd", "description1", "sadas", 8, "status");
        Movie m14 = new Movie(14, "movie1", "description1", "horror", 8, "status");
        Movie m15 = new Movie(15, "modasvie1", "description1", "horror", 8, "status");
        Movie m16 = new Movie(16, "movie1", "description1", "horror", 8, "status");
        Movie m17 = new Movie(17, "movie1", "description1", "horror", 8, "status");
        Movie m18 = new Movie(18, "movie1", "dsad", "horror", 8, "status");
        Movie m19 = new Movie(19, "das", "f", "horror", 8, "status");
        Movie m20 = new Movie(20, "movie1", "description1", "horror", 8, "status");
        Movie m21 = new Movie(33, "movie1", "bfd", "horror", 8, "status");
        Movie m22 = new Movie(21, "movdasie1", "b", "horror", 8, "status");
        Movie m23 = new Movie(22, "movie1", "description1", "horror", 8, "status");
        Movie m24 = new Movie(24, "movie1", "b", "horror", 8, "status");

        movieDao.deleteAll();
        movieDao.insertAll(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16,
                m17, m18, m19, m20, m21, m22, m23, m24);

    }


    public static void insertUsers(AppDatabase db) {
        final UserDao userDao = db.userDao();
        User u1 = new User(1, "username", "password", "admin");
        User u2 = new User(2, "1", "1", "1");

        userDao.deleteAll();
        userDao.insertAll(u1, u2);
    }


}
