package com.example.android.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.movies.data.Movie;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private Movie mMovieData;

    private ImageView mPoster;

    private TextView mTitle;

    private TextView mYear;

    private TextView mScore;

    private TextView mDescrption;

    private TextView mPopularity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mMovieData = (Movie) getIntent().getSerializableExtra("Movie");

        mPoster = (ImageView) findViewById(R.id.iv_details_poster);

        mTitle = (TextView) findViewById(R.id.tv_details_title);

        mYear = (TextView) findViewById(R.id.tv_details_year);

        mScore = (TextView) findViewById(R.id.tv_details_score);

        mDescrption = (TextView) findViewById(R.id.tv_details_description);

        mPopularity = (TextView) findViewById(R.id.tv_details_popularity);




        Picasso.with(this).load(String.valueOf(mMovieData.getmImageUrl())).into(mPoster);

        mTitle.setText(mMovieData.getmTitle());

        mYear.setText(mMovieData.getmYear());

        mScore.setText(mMovieData.getmScore() + "/10");

        mDescrption.setText(mMovieData.getmDescription());



    }
}
