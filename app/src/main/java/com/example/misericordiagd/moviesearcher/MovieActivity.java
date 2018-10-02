package com.example.misericordiagd.moviesearcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MovieActivity extends AppCompatActivity {

    //referencies a objecte de la pantalla
    private Movie movie;
    private TextView titleView;
    private TextView yearView;
    private TextView ratedView;
    private TextView runtimeView;
    private TextView genreView;
    private TextView plotView;
    private TextView directorView;
    private TextView writerView;
    private TextView actorsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        try {
            InputStream stream = getAssets().open("lord.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            movie = gson.fromJson(reader, Movie.class);
        } catch (IOException e) {
            Toast.makeText(this, "No he pogut llegir el fitxer", Toast.LENGTH_SHORT).show();
        }

        titleView = findViewById(R.id.titleview);
        yearView = findViewById(R.id.yearview);
        ratedView = findViewById(R.id.ratedview);
        runtimeView = findViewById(R.id.runtimeview);
        genreView = findViewById(R.id.genreview);
        plotView = findViewById(R.id.plotview);
        directorView = findViewById(R.id.directorview);
        writerView = findViewById(R.id.writerview);
        actorsView = findViewById(R.id.actorsview);

        titleView.setText(movie.getTitle());
        yearView.setText(movie.getYear());
        ratedView.setText(movie.getRated());
        runtimeView.setText(movie.getRuntime());
        genreView.setText(movie.getGenre());
        plotView.setText(movie.getPlot());
        directorView.setText(movie.getDirector());
        writerView.setText(movie.getWriter());
        actorsView.setText(movie.getActors().replace(", ", "\n"));

    }
}
