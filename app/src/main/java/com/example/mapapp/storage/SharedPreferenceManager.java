package com.example.mapapp.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

public class SharedPreferenceManager {



    private static SharedPreferenceManager SharedInstance;
    public static final String Shared_Pref_Name = "UserDataStorage";
    private Context SharedContext; // Context to handle Shared Preference

    private SharedPreferenceManager(Context SharedContext){
        this.SharedContext = SharedContext;
    }

    // We need only a single Instance So a Synchronized method is created
    public static synchronized SharedPreferenceManager getInstance(Context SharedContext){
        if(SharedInstance == null){
            SharedInstance = new SharedPreferenceManager(SharedContext);
        }

        return SharedInstance;
    }

    // To logout
    public void clear(){
        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();
    }

    public void setNotificationCount(int notificationCount){

        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("notificationCount", notificationCount);

        editor.apply();
    }

    public int getNotificationCount(){
        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);

        return sharedPreferences.getInt("notificationCount", 0);
    }

    public void setAnnouncementCount(int announcementCount){

        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("announcementCount", announcementCount);

        editor.apply();
    }

    public int getAnnouncementCount(){
        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);

        return sharedPreferences.getInt("announcementCount", 0);
    }


    public void isFirstTime(int value){

        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("first", value);

        editor.apply();
    }

    public int getIsFirstTime(){
        SharedPreferences sharedPreferences = SharedContext.getSharedPreferences(Shared_Pref_Name, Context.MODE_PRIVATE);

        return sharedPreferences.getInt("first", 0);
    }

}
