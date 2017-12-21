package com.example.dewioktaviani.explorepos.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.dewioktaviani.explorepos.Data.common.clsItem;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Dewi Oktaviani on 12/14/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String DATABASE_NAME = "tesPOS.db";
    private static final int DATABASE_VERSION =1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    protected Dao<clsItem, Integer> mItemDao;

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, clsItem.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Dao<clsItem, Integer> dao = null;
        try {
            dao = getmItemDao();
            if (oldVersion < 2) {
                // we added the age column in version 2
                dao.executeRaw("ALTER TABLE `clsItem` ADD COLUMN txtTes TEXT;");
            }
            if (oldVersion < 3) {
                // we added the weight column in version 3
                dao.executeRaw("ALTER TABLE `clsItem` ADD COLUMN txtTes2 TEXT;");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        try {
//            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
//            TableUtils.dropTable(connectionSource, clsItem.class, true);
//
//            //after we drop the old databases, we create the new ones
//            onCreate(database, connectionSource);
//        } catch (SQLException e) {
//            Log.e(DatabaseHelper.class.getName(), "Can't drop database", e);
//            throw new RuntimeException(e);
//        }
    }

    public void clearAllDataInDatabase(){
        try {
            TableUtils.createTable(connectionSource, clsItem.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearDataAfterLogout(){
        try {
            TableUtils.clearTable(connectionSource, clsItem.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<clsItem, Integer> getmItemDao() throws SQLException{
        if (mItemDao == null){
            mItemDao = getDao(clsItem.class);
        }
        return mItemDao;
    }

    @Override
    public void close() {
        super.close();
        mItemDao = null;
    }
}
