package com.example.hangningman;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PreferenceManagerClass{

    private static final String LIST_KEY = "list_key";
    private static final PreferenceManagerClass instance =  new PreferenceManagerClass();
    private List<ScoreListData> scoreLists;


    private PreferenceManagerClass() {

    }

    public static PreferenceManagerClass getInstance() {
        return instance;
    }

    public void saveData(Context context, ScoreListData list) {

        Gson gson = new Gson();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString("list_key","Tomt");
        if(jsonString.equals("Tomt")){
            scoreLists = new ArrayList<>();
        }else {
            scoreLists = readData(context);
        }

        jsonString = gson.toJson(list);
        scoreLists.add(list);

        pref.edit().putString("list_key",jsonString).apply();

    }

    public List<ScoreListData> readData(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString("list_key",null);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ScoreListData>>() {}.getType();

         List<ScoreListData> list= gson.fromJson(jsonString,type);

        return list;
    }

}
