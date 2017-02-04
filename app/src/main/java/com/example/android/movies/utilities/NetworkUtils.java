package com.example.android.movies.utilities;

import android.net.Uri;
import android.util.Log;

import com.example.android.movies.Properties;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by yau_c on 20/01/2017.
 */

public class NetworkUtils implements Properties {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String STATIC_BASE_URL =
            "http://api.themoviedb.org/3/movie";

    final static String QUERY_PARAM = "api_key";

    private static final String STATIC_BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";


    private static final String IMAGE_SIZE = "w342";



    public static URL buildUrl(String listType) {
        Uri builtUri = Uri.parse(STATIC_BASE_URL).buildUpon()
                .appendPath(listType)
                .appendQueryParameter(QUERY_PARAM, API_KEY)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {


        Log.v(TAG,"attempting to connect to the internet");

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
