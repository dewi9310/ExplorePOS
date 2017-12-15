package com.example.dewioktaviani.explorepos.Data.repo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dewi Oktaviani on 12/15/2017.
 */

public interface crud {
    public int create(Object item) throws SQLException;
    public int createOrUpdate(Object item) throws SQLException;
    public int update(Object item) throws SQLException;
    public int delete(Object item) throws SQLException;
    public  Object findById(int id) throws SQLException;
    public List<?> findAll() throws SQLException;
}
