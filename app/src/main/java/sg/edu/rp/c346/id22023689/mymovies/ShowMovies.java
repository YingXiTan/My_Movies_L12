package sg.edu.rp.c346.id22023689.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowMovies extends AppCompatActivity {
    ListView lvMovies;
    ArrayList<Movies> alMoviesList;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_movies);

        lvMovies = findViewById(R.id.lvMovies);
        alMoviesList = new ArrayList<>();

        Movies item1 = new Movies("Orphan", "Horror", 2009, "M18");
        alMoviesList.add(item1);

        Movies item2 = new Movies("Saving Private Ryan", "Drama", 1998, "NC16");
        alMoviesList.add(item2);

        Movies item3 = new Movies("True Lies", "Action", 1992, "PG13");
        alMoviesList.add(item3);

        caMovies = new CustomAdapter(this, R.layout.row, alMoviesList);
        lvMovies.setAdapter(caMovies);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movies currentMovie = alMoviesList.get(position);

                Intent intent = new Intent(ShowMovies.this, MoviesList.class);

                intent.putExtra("Title", currentMovie.getTitle());
                intent.putExtra("Genre", currentMovie.getGenre());
                intent.putExtra("Year", currentMovie.getYear());

                startActivity(intent);
            }
        });
    }
}