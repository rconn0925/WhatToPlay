package com.rossconnacher.whattoplay;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Ross on 5/29/2017.
 */

public interface TwitchService {

    @GET("/kraken/streams")
    Call<String> getAllStreams(@Header("Client-ID") String clientID, @Query("stream_type") String stream_type, @Query("game") String game);

    @GET("/kraken/oauth2/authorize")
    Call<String> authenticate(@Query("client-id") String clientID, @Query("redirect_uri") String redirectUri, @Query("response_type") String responseType, @Query("scope") String scope);
}
