package com.alexpadilla.retrofittutorial.rest;

import com.alexpadilla.retrofittutorial.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by alexpadillajr on 11/29/17.
 */

public class ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("/id") int id, @Query("api_key") String apiKey);
}
