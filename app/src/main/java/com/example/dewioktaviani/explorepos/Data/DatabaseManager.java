package com.example.dewioktaviani.explorepos.Data;

import android.content.Context;

/**
 * Created by Dewi Oktaviani on 12/14/2017.
 */

public class DatabaseManager {
    static private DatabaseManager instance;
    static public void init(Context context){
        if (null==instance){
            instance = new DatabaseManager(context);

        }
    }
    static public DatabaseManager getInstance(){
        return instance;
    }
    private DatabaseHelper helper;

    private DatabaseManager(Context context){
        helper = new DatabaseHelper(context);
    }

    public DatabaseHelper getHelper(){
        return helper;
    }
}
