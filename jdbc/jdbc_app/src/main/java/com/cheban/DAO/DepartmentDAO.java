package com.cheban.DAO;

import com.cheban.model.DepartmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 20.02.2018.
 */
public interface DepartmentDAO extends GeneralDAO<DepartmentEntity>{

    ArrayList<DepartmentEntity> readByDeptNo(String dept_no) throws SQLException;
    int delete(String dep_no) throws SQLException;
}