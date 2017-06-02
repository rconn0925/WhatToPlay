package com.rossconnacher.whattoplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LauncherActivity extends AppCompatActivity {

    private static final String TAG = "LauncherActivity";
    private IGDBEngine mGameEngine;
    private JSONArray gameData;
    private JSONArray genreData;
    private JSONArray themeData;
    private JSONArray playerPerspectiveData;
    private JSONArray catagoryData;
    private JSONArray platformData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        if(isDataAlreadyCached()){
            //go to main activity
        } else {
            //pull data then go to main activity
            mGameEngine = new IGDBEngine();
            gameData = new JSONArray();
            genreData = new JSONArray();
            themeData = new JSONArray();
            playerPerspectiveData = new JSONArray();
            catagoryData = new JSONArray();
            platformData = new JSONArray();

            //get games

            getGames();
            /*
            try {
                Cache.writeObject(this,"gamedata",gameData);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d(TAG,"size: "+gameData.length());
            */
            //get genres
            //get platform
            //get themes
            //get game modes
            //get player perspectives
            //get catagory

        }
    }
    
    public void getGames(){
        String[] fields = new String[]{"id","name","url","created_at","updated_at","summary",
                "storyline","collection","franchise","hypes","rating","popularity","aggregated_rating",
                "rating_count","game","developers","publishers","game_engines","category","time_to_beat",
                "player_perspectives","game_modes","keywords","themes","genres","first_release_date",
                "status","release_dates","alternative_names","screenshots","videos","cover","esrb",
                "pegi","websites","tags"};
        for(int counter = 0;counter<10300;counter+=50){
            Call<String> allGames = mGameEngine.getGames(fields,50,counter,"aggregated_rating:desc");
            allGames.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d(TAG,"message: " + response.message());
                    Log.d(TAG,"body: "+ response.body());
                    try {
                        if(response.body()!=null){
                            JSONArray allGamesJson = new JSONArray(response.body());
                            gameData = allGamesJson;

                            for(int i = 0; i < allGamesJson.length();i++){
                                JSONObject gameJson = allGamesJson.getJSONObject(i);
                                Log.d(TAG,gameJson.toString(4));


                            }
                        } else {

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
    }

    public boolean isDataAlreadyCached (){
        boolean isCached = false;

        return isCached;
    }
    public JSONArray MergeJSONArray(JSONArray o1, JSONArray o2){
        JSONArray mergedObj = o1;
        for (int i = 0; i < o2.length(); i++) {
            try {
                mergedObj.put(o2.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return mergedObj;
    }
}
