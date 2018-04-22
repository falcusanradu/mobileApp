package com.movie.movieapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.movie.movieapp.src.dao.MovieDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.mockdata.DataHelper;
import com.movie.movieapp.src.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MovieDao movieDao;

    private List<Movie> movies;
    private ListView lv;

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

        //DataHelper.insertMovies(db);
        this.movies = movieDao.getAll();

        setContentView(R.layout.activity_main);

        String search = getIntent().getStringExtra("searchKey");
        List<String> genres = Arrays.asList("action","Action","horror","Horror",
                "Drama","drama","Adventure","adventure",
                "Thriller","thriller","Comedy","comedy");



        final List<Movie> movieList = new ArrayList<>();
        if (search.equals("all")){
            for(Movie m: movies){
                movieList.add(m);
            }
        } else if (!search.equals("other")) {
            for (Movie m : movies) {
                if (m.getName().toLowerCase().contains(search.toLowerCase())
                        || m.getGenre().toLowerCase().equals(search.toLowerCase())) {
                    movieList.add(m);
                }
            }
        } else {
            for (Movie m: movies){
                if (!genres.contains(m.getGenre().toLowerCase())){
                    movieList.add(m);
                }
            }
        }

        movies = movieList;

        this.initializeListView(createStringList(movieList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final int index = this.listView.getSelectedItemPosition();

                final Intent myIntent = new Intent(MainActivity.this, ShowDetailsActivity.class);
                ShowDetailsActivity.movie = movies.get(position);
                startActivity(myIntent);
            }
        });


        //set title

        setTitle("Movie list results for: " + search);

    }

    private List<String> createStringList(final List<Movie> movies) {
        List<String> stringMovies = new ArrayList<>();
        for (Movie movie : movies) {
            stringMovies.add("Title: " + movie.getName() + " \nGenre: " + movie.getGenre()
                    + "\t\t\t\t\t\t\t\t\t\tRating: " + movie.getNote() + "/10" + " \nStatus: " + movie.getStatus());
        }
        return stringMovies;
    }


    private void initializeListView(final List<String> usersName_type_rating) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, usersName_type_rating);

        //setContentView(R.layout.activity_main);
        this.lv = findViewById(R.id.listView);
        this.lv.setAdapter(adapter);
    }

    protected void onRestart() {
        super.onRestart();

        this.movies = movieDao.getAll();

        setContentView(R.layout.activity_main);

        String search = getIntent().getStringExtra("searchKey");
        List<String> genres = Arrays.asList("action","Action","horror","Horror",
                "Drama","drama","Adventure","adventure",
                "Thriller","thriller","Comedy","comedy");


        final List<Movie> movieList = new ArrayList<>();
        if (search.equals("all")){
            for(Movie m: movies){
                movieList.add(m);
            }
        } else if (!search.equals("other")) {
            for (Movie m : movies) {
                if (m.getName().toLowerCase().contains(search.toLowerCase())
                        || m.getGenre().toLowerCase().equals(search.toLowerCase())) {
                    movieList.add(m);
                }
            }
        } else {
            for (Movie m: movies){
                if (!genres.contains(m.getGenre().toLowerCase())){
                    movieList.add(m);
                }
            }
        }

        movies = movieList;

        this.initializeListView(createStringList(movieList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final int index = this.listView.getSelectedItemPosition();

                final Intent myIntent = new Intent(MainActivity.this, ShowDetailsActivity.class);
                ShowDetailsActivity.movie = movies.get(position);
                startActivity(myIntent);
            }
        });

        Toast.makeText(MainActivity.this, "Movie list Loaded", Toast.LENGTH_LONG).show();

    }

}
