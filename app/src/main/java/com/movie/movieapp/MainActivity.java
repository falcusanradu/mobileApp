package com.movie.movieapp;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.movie.movieapp.src.dao.MovieDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.mockdata.DataHelper;
import com.movie.movieapp.src.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MovieDao movieDao;

    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        movieDao = db.movieDao();
        DataHelper.insertMovies(db);
        this.movies = movieDao.getAll();

        this.initializeListView(createStringList(this.movies));
    }

    private List<String> createStringList(final List<Movie> movies) {
        List<String> stringMovies = new ArrayList<>();
        for (Movie movie : movies) {
            stringMovies.add(movie.getName() + " " + movie.getGenre() + " " + movie.getStatus());
        }
        return stringMovies;
    }


    private void initializeListView(final List<String> usersName_type_rating) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usersName_type_rating);

        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }


//    public MainActivity() {}
}
