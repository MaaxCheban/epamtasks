package com.cheban.DAO;

import com.cheban.model.WorksOnEntity;

import java.sql.SQLException;

/**
 * Created by MAX on 23.02.2018.
 */
public interface WorkOnDAO extends GeneralDAO<WorksOnEntity> {
    int delete(int emp_no) throws SQLException;
}
