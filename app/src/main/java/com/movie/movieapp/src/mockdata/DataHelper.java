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
        Movie m1 = new Movie(1, "A Quiet Place", "A family is forced to live in silence while hiding from creatures that hunt by sound.", "horror", 8, "unseen");
        Movie m2 = new Movie(2, "Hard Candy", "A teenage girl raids a man's home in order to expose him under suspicion that he is a pedophile.", "thriller", 6, "unseen");
        Movie m3 = new Movie(3, "Coco", "Aspiring musician Miguel, confronted with his family's ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.", "animation", 9, "unseen");
        Movie m4 = new Movie(4, "The Conjuring", "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.", "horror", 8, "unseen");
        Movie m5 = new Movie(5, "The Purge", "A wealthy family are held hostage for harboring the target of a murderous syndicate during the Purge, a 12-hour period in which any and all crime is legal.", "horror", 6, "unseen");
        Movie m6 = new Movie(6, "The Ring", "A journalist must investigate a mysterious videotape which seems to cause the death of anyone in a week of viewing it.", "horror", 6, "unseen");
        Movie m7 = new Movie(7, "Split", "Three girls are kidnapped by a man with a diagnosed 23 distinct personalities. They must try to escape before the apparent emergence of a frightful new 24th.", "horror", 9, "unseen");
        Movie m8 = new Movie(8, "You Were Never Really Here", "A traumatized veteran, unafraid of violence, tracks down missing girls for a living. When a job spins out of control, Joe's nightmares overtake him as a conspiracy is uncovered leading to what may be his death trip or his awakening.", "thriller", 9, "unseen");
        Movie m11 = new Movie(9, "Red Sparrow", "Ballerina Dominika Egorova is recruited to 'Sparrow School,' a Russian intelligence service where she is forced to use her body as a weapon. Her first mission, targeting a C.I.A. agent, threatens to unravel the security of both nations.", "thriller", 10, "status");
        Movie m10 = new Movie(10, "Get Out!", "A young African-American visits his white girlfriend's parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point.", "thriller", 5, "unseen");
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
        User u2 = new User(2, "admin", "admin", "admin");

        userDao.deleteAll();
        userDao.insertAll(u1, u2);
    }


}
