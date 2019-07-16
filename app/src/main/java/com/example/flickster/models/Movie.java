package com.example.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String title;
    String overview;

    public  Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview =jsonObject.getString("overview");
    }

    public static List<Movie> fromJsonArray(JSONArray moviejsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for (int i =0; i <moviejsonArray.length();i++) {
            movies.add(new Movie(moviejsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/", posterPath) ;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}

