package com.example.android.movies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.movies.data.Movie;
import com.squareup.picasso.Picasso;

import static java.lang.System.load;

/**
 * Created by yau_c on 20/01/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {


    private Movie[] mMovieData = null;

    private final MovieAdapterOnClickHandler mClickHandler;


    public interface MovieAdapterOnClickHandler {

        void onClick(Movie movieData);
    }

    public MovieAdapter(MovieAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }



    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        public final TextView mMovieTextView;

        public final ImageView mMovieImageView;

        public MovieAdapterViewHolder(View view) {
            super(view);

//            mMovieTextView = (TextView) view.findViewById(R.id.tv_movie);

            mMovieImageView = (ImageView) view.findViewById(R.id.iv_movie);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            Movie movie = mMovieData[adapterPosition];
            mClickHandler.onClick(movie);
        }
    }


    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

        int height = viewGroup.getMeasuredHeight() / 2;
        view.setMinimumHeight(height);

        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder movieAdapterViewHolder, int position) {

        Movie movie = mMovieData[position];

//        movieAdapterViewHolder.mMovieTextView.setText(movie.getmTitle());

        Picasso
                .with(movieAdapterViewHolder.mMovieImageView.getContext())
                .load(String.valueOf(movie.getmImageUrl()))
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(movieAdapterViewHolder.mMovieImageView);


    }




    @Override
    public int getItemCount() {
        if (null == mMovieData) return 0;
        return mMovieData.length;

    }

    public void setMovieData(Movie[] movieData) {
        mMovieData = movieData;
        notifyDataSetChanged();
    }

}
