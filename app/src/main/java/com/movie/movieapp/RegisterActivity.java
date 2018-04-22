package com.movie.movieapp;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.movie.movieapp.src.dao.UserDao;
import com.movie.movieapp.src.database.AppDatabase;
import com.movie.movieapp.src.mockdata.DataHelper;
import com.movie.movieapp.src.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private static List<User> users;
    private static UserDao userDao;
    // from UI
    private AutoCompleteTextView username;
    private AutoCompleteTextView password;
    private AutoCompleteTextView confirmPassword;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        userDao = db.userDao();
        //DataHelper.insertUsers(db);
        users = userDao.getAll();
        //set up elements
        this.username = (AutoCompleteTextView) findViewById(R.id.username_register);
        this.password = (AutoCompleteTextView) findViewById(R.id.password_register);
        this.confirmPassword = (AutoCompleteTextView) findViewById(R.id.confirm_password);
        this.registerBtn = (Button) findViewById(R.id.registerBtn);
        this.clickRegister();
    }

    private void clickRegister() {
        this.registerBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });
    }

    private void attemptRegister() {
        String username = this.username.getText().toString();
        String password = this.password.getText().toString();
        String conformPassword = this.confirmPassword.getText().toString();
        if (username.isEmpty() || password.isEmpty() || conformPassword.isEmpty())
            this.alertDialog("Username, password and confirmed password must not be null");
        else if (this.checkIfUsernameAlreadyExists(username)) {
            this.alertDialog("Username already exists");
        } else if (!password.equals(conformPassword)) {
            this.alertDialog("password and confirmation do not match");
        } else {
            User user = new User(this.giveTheGreatestId(), username, password, "normal user");
            userDao.insertAll(user);
            Intent myIntent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(myIntent);
        }
    }

    private Integer giveTheGreatestId() {
        List<Integer> intList = new ArrayList<>();
        for (User u : users) {
            intList.add(u.getIdUser());
        }
        return Collections.max(intList) + 1;
    }

    private boolean checkIfUsernameAlreadyExists(String str) {
        for (User u : users) {
            if (u.getUsername().equals(str)) return true;
        }
        return false;
    }

    private void alertDialog(final String message) {
        AlertDialog.Builder alertDialogBuidler = new AlertDialog.Builder(this);
        alertDialogBuidler.setMessage(message).setCancelable(false).setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuidler.create();
        alertDialog.setTitle("Error!");
        alertDialog.show();
    }

}
