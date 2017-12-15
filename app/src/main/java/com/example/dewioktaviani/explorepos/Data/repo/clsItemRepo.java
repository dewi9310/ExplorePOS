package com.example.dewioktaviani.explorepos.Data.repo;

import android.content.Context;

import com.example.dewioktaviani.explorepos.Data.DatabaseHelper;
import com.example.dewioktaviani.explorepos.Data.DatabaseManager;
import com.example.dewioktaviani.explorepos.Data.common.clsItem;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dewi Oktaviani on 12/15/2017.
 */

public class clsItemRepo implements crud {
    private DatabaseHelper helper;

    public clsItemRepo(Context context){
        DatabaseManager.init(context);
        helper = DatabaseManager.getInstance().getHelper();
    }
    @Override
    public int create(Object item) throws SQLException {
        int index = -1;
        clsItem object = (clsItem) item;
        try {
            index = helper.getmItemDao().create(object);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int createOrUpdate(Object item) throws SQLException {
        int index = -1;
        clsItem object = (clsItem) item;
        try {
            Dao.CreateOrUpdateStatus status = helper.getmItemDao().createOrUpdate(object);
            index = status.getNumLinesChanged();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int update(Object item) throws SQLException {
        int index = -1;
        clsItem object = (clsItem) item;
        try {
            index = helper.getmItemDao().update(object);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public int delete(Object item) throws SQLException {
        int index = -1;
        clsItem object = (clsItem) item;
        try {
            index = helper.getmItemDao().delete(object);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return index;
    }

    @Override
    public Object findById(int id) throws SQLException {
        clsItem item = null;
        try {
            item = helper.getmItemDao().queryForId(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<?> findAll() throws SQLException {
        List<clsItem> items = null;
        try {
            items = helper.getmItemDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return items;
    }
}
