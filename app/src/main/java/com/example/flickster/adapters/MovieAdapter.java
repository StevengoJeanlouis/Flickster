package com.example.flickster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flickster.R;
import com.example.flickster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        log.d("smile","onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        log.d("smile","onBindViewHolder"+ position);
        Movie movie = movies.get(position);
        // Bind the movie data into the view holder
        holder.bind(movies);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           tvTitle = itemView.findViewById(R.id.tvTitle);
           tvOverview =itemView.findViewById(R.id.tvOverview);
           ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(List<Movie> movie) {
          tvTitle.setText(movie.getTitle());
          tvOverview.setText(movie.getOverview());
          Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }
    }
}
