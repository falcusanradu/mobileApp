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
        Movie m9 = new Movie(11, "I Kill Giants", "Barbara Thorson struggles through life by escaping into a fantasy life of magic and monsters.", "thriller", 5, "unseen");
        Movie m12 = new Movie(12, " Avengers: Infinity War", "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.", "action", 8, "unseen");
        Movie m13 = new Movie(13, "Ready Player One", "When the creator of a virtual reality world called the OASIS dies, he releases a video in which he challenges all OASIS users to find his Easter Egg, which will give the finder his fortune.", "action", 9, "unseen");
        Movie m14 = new Movie(14, "Rampage", "When three different animals become infected with a dangerous pathogen, a primatologist and a geneticist team up to stop them from destroying Chicago.", "action", 6, "unseen");
        Movie m15 = new Movie(15, "Black Panther", "T'Challa, the King of Wakanda, rises to the throne in the isolated, technologically advanced African nation, but his claim is challenged by a vengeful outsider who was a childhood victim of T'Challa's father's mistake.", "action", 7, "unseen");
        Movie m16 = new Movie(16, "Tomb Raider", "Lara Croft, the fiercely independent daughter of a missing adventurer, must push herself beyond her limits when she discovers the island where her father disappeared.", "action", 8, "unseen");
        Movie m17 = new Movie(17, "Blockers", "Three parents try to stop their daughters from losing their virginity on prom night.", "comedy", 5, "unseen");
        Movie m18 = new Movie(18, "Jumanji: Welcome to the Jungle", "Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.", "comedy", 7, "unseen");
        Movie m19 = new Movie(19, "Game Night", "A group of friends who meet regularly for game nights find themselves entangled in a real-life mystery.", "comedy", 9, "unseen");
        Movie m20 = new Movie(20, "Game Over, Man!", "Three friends are on the verge of getting their video game financed when their benefactor is taken hostage by terrorists.", "comedy", 6, "unseen");
        Movie m21 = new Movie(21, "Lady Bird", "In 2002, an artistically inclined seventeen-year-old girl comes of age in Sacramento, California.", "comedy", 8, "unseen");
        Movie m22 = new Movie(22, "The Beguiled", "The unexpected arrival of a wounded Union soldier at a girls school in Virginia during the American Civil War leads to jealousy and betrayal.", "drama", 6, "unseen");
        Movie m23 = new Movie(23, "Crooked House", "In Agatha Christie's most twisted tale, a spy-turned-private-detective is lured by his former lover to catch her grandfather's murderer before Scotland Yard exposes dark family secrets.", "drama", 7, "unseen");
        Movie m24 = new Movie(24, "Brooklyn", "An Irish immigrant lands in 1950s Brooklyn, where she quickly falls into a romance with a local. When her past catches up with her, however, she must choose between two countries and the lives that exist within.", "drama", 10, "unseen");
        Movie m25 = new Movie(25, "The Post", "A cover-up that spanned four U.S. Presidents pushed the country's first female newspaper publisher and a hard-driving editor to join an unprecedented battle between the press and the government.", "drama", 6, "unseen");
        Movie m26 = new Movie(26, "Mud", "Two young boys encounter a fugitive and form a pact to help him evade the vigilantes that are on his trail and to reunite him with his true love.", "drama", 9, "unseen");
        Movie m27 = new Movie(27, "Dallas Buyers Club", "In 1985 Dallas, electrician and hustler Ron Woodroof works around the system to help AIDS patients get the medication they need after he is diagnosed with the disease.", "drama", 8, "unseen");
        Movie m28 = new Movie(28, "The Lost City of Z", "A true-life drama, centering on British explorer Col. Percival Fawcett, who disappeared while searching for a mysterious city in the Amazon in the 1920s.", "adventure", 7, "unseen");
        Movie m29 = new Movie(29, "Okja", "A young girl risks everything to prevent a powerful, multinational company from kidnapping her best friend - a fascinating beast named Okja.", "adventure", 7, "unseen");
        Movie m30 = new Movie(30, "Barry Lyndon", "An Irish rogue wins the heart of a rich widow and assumes her dead husband's aristocratic position in 18th-century England.", "adventure", 10, "unseen");
        Movie m31 = new Movie(31, "Annihilation", "A biologist signs up for a dangerous, secret expedition into a mysterious zone where the laws of nature don't apply.", "adventure", 3, "unseen");
        Movie m32 = new Movie(32, "Star Wars: The Last Jedi", "Rey develops her newly discovered abilities with the guidance of Luke Skywalker, who is unsettled by the strength of her powers. Meanwhile, the Resistance prepares for battle with the First Order.", "adventure", 9, "unseen");
        Movie m33 = new Movie(33, "The Shape of Water", "At a top secret research facility in the 1960s, a lonely janitor forms a unique relationship with an amphibious creature that is being held in captivity.", "fantasy", 9, "unseen");

        movieDao.deleteAll();
        movieDao.insertAll(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16,
                m17, m18, m19, m20, m21, m22, m23, m24, m25, m26, m27, m28, m29, m30, m31, m32, m33);

    }


    public static void insertUsers(AppDatabase db) {
        final UserDao userDao = db.userDao();
        User u1 = new User(1, "username", "password", "admin");
        User u2 = new User(2, "admin", "admin", "admin");

        userDao.deleteAll();
        userDao.insertAll(u1, u2);
    }


}
