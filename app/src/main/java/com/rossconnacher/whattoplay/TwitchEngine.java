package com.rossconnacher.whattoplay;

import android.net.Uri;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Ross on 5/29/2017.
 */

public class TwitchEngine {

    //private static final String CLIENT_ID = "wxhref3x44pp98h4y46m7uvwmn0sqd";
    private static final String CLIENT_ID =  "ycb0h2kwvzvdwj3twp0kuh09kzwe63";
    private static final String REDIRECT_URI = "http://localhost";


    private TwitchService mService;


    public TwitchEngine(){
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://api.themoviedb.org/3/")
                .baseUrl("https://api.twitch.tv/kraken/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mService = retrofit.create(TwitchService.class);
    }

    public Call<String> getAllStreams(String stream_type,String game){
        return mService.getAllStreams(CLIENT_ID,stream_type,game);
    }

    public Call<String> authenticate(){
        return mService.authenticate(CLIENT_ID,REDIRECT_URI,"token","user_read");
    }
}
