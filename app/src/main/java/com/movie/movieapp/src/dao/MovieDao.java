package com.movie.movieapp.src.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.movie.movieapp.src.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    List<Movie> getAll();


//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
//            + "last_name LIKE :last LIMIT 1")
//    User findByName(String first, String last);

    @Insert
    void insertAll(Movie... movies);

    @Delete
    void delete(Movie movie);


    @Query("DELETE  FROM movie WHERE idMovie like '%'")
    void deleteAll();

    @Update
    void update(Movie movie);
}
