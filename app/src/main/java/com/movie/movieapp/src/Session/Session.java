package com.movie.movieapp.src.Session;

import com.movie.movieapp.src.model.User;

/**
 * Created by Alex on 22/04/2018.
 */

public class Session {

    User user;

    private static Session INSTANCE = new Session();

    private void Session(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Session getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(Session INSTANCE) {
        Session.INSTANCE = INSTANCE;
    }
}
