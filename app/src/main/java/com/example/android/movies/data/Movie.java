package com.example.android.movies.data;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.net.URL;

import static android.R.attr.description;

/**
 * Created by yau_c on 20/01/2017.
 */

public class Movie implements Serializable {

    private URL mImageUrl;

    private String mTitle;

    private String mDescription;

    private String mYear;

    private String mScore;

    private String mPopularity;

    public Movie(URL mImageUrl, String mTitle, String mDescription, String mPopularity, String mScore, String mYear) {
        this.mImageUrl = mImageUrl;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mYear = mYear.substring(0,4);
        this.mScore = mScore;
        this.mPopularity = mPopularity;
    }
    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }


    public URL getmImageUrl() {
        return mImageUrl;
    }

    public String getmYear() {
        return mYear;
    }

    public String getmScore() {
        return mScore;
    }

    public String getmPopularity() {
        return mPopularity;
    }
}
