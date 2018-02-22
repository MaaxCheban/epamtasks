package com.cheban.DAO;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 20.02.2018.
 */
public interface GeneralDAO <T>{
    ArrayList<T> read() throws SQLException;
    int create(T entity) throws SQLException;
    int update(T entity) throws SQLException;
}