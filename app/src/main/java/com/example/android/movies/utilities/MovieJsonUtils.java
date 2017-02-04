package com.example.android.movies.utilities;

import android.content.Context;
import android.util.Log;

import com.example.android.movies.MainActivity;
import com.example.android.movies.data.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

import static android.os.Build.VERSION_CODES.M;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by yau_c on 20/01/2017.
 */

public class MovieJsonUtils {

    private static final String TAG = MovieJsonUtils.class.getSimpleName();

    public static Movie[] getMoviesFromJson(String movieJsonStr) throws JSONException {

        Log.v(TAG, movieJsonStr);

        Movie[] parsedMovieData = null;

        JSONObject movieJson = new JSONObject(movieJsonStr);

        JSONArray movieJsonArray = movieJson.getJSONArray("results");

        parsedMovieData = new Movie[movieJsonArray.length()];

        for (int i = 0; i < movieJsonArray.length(); i++) {

            JSONObject movieData = movieJsonArray.getJSONObject(i);

            String imageUrlString = movieData.getString("poster_path");

            URL imageUrl = null;

            try {
                 imageUrl = new URL("http://image.tmdb.org/t/p/w342/" + imageUrlString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            String title = movieData.getString("title");
            String description = movieData.getString("overview");
            String popularity = movieData.getString("popularity");
            String score = movieData.getString("vote_average");
            String releaseDate = movieData.getString("release_date");



            parsedMovieData[i] = new Movie(imageUrl, title, description, popularity, score, releaseDate);
        }

        return parsedMovieData;

    }
}
