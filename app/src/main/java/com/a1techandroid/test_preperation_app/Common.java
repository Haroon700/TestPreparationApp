package com.a1techandroid.test_preperation_app;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Common {

    public static void setForceType(String name, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences("type", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.apply();
    }

    public static String getForceType(Context context){
        SharedPreferences prefs = context.getSharedPreferences("type", MODE_PRIVATE);
        String name = prefs.getString("name", "");//"No name defined" is the default value.
        return name;
    }

    public static void setSession(String name, Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences("session", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.apply();
    }

    public static String getSession(Context context){
        SharedPreferences prefs = context.getSharedPreferences("session", MODE_PRIVATE);
        String name = prefs.getString("name", "");//"No name defined" is the default value.
        return name;
    }
}
