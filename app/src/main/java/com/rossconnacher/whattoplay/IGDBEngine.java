package com.rossconnacher.whattoplay;

import com.rossconnacher.whattoplay.IGDBService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Ross on 5/29/2017.
 */

public class IGDBEngine {

    private IGDBService mService;
    private static final String API_KEY = "zWLiedooAKmshOXIp8MVfQo62IAbp1OhV8djsncwR2BaPj11D8";

    public IGDBEngine(){
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://api.themoviedb.org/3/")
                .baseUrl("https://igdbcom-internet-game-database-v1.p.mashape.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mService = retrofit.create(IGDBService.class);
    }

    public Call<String> getGenres(String[] fields,int limit){
        String fieldString = "";
        for(int i = 0; i<fields.length;i++){
            if(i==fields.length-1){
                fieldString+=fields[i];
            } else {
                fieldString+= (fields[i]+",");
            }
        }
        return mService.getGenres(API_KEY,fieldString,limit);
    }
    public Call<String> getGames(String[] fields, int limit, int offset){
        String fieldString = "";
        for(int i = 0; i<fields.length;i++){
            if(i==fields.length-1){
                fieldString+=fields[i];
            } else {
                fieldString+= (fields[i]+",");
            }
        }
        return mService.getGames(API_KEY,"application/json",fieldString,limit,offset);
    }
}
