package com.rossconnacher.whattoplay;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Ross on 5/29/2017.
 */

public interface IGDBService {


    @GET("/genres/")
    Call<String> getGenres (@Header("X-Mashape-Key") String api_key,@Query("fields") String field, @Query("limit") int limit );

    @GET("/games/")
    Call<String> getGames (@Header("X-Mashape-Key") String api_key,@Header("Accept") String content_type, @Query("fields") String field, @Query("limit") int limit, @Query("offset") int offset,@Query("order") String order);
}
