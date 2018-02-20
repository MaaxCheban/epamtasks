package com.cheban.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MAX on 20.02.2018.
 */
public interface GeneralDAO {
    ResultSet read() throws SQLException;
    int create() throws SQLException;
    int update() throws SQLException;
    int delete() throws SQLException;
}