package com.cheban.DAO;

import com.cheban.model.EmployeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 22.02.2018.
 */
public interface EmployeeDAO extends GeneralDAO<EmployeeEntity>{
    int delete(int dep_no) throws SQLException;
    ArrayList<EmployeeEntity> readByDeptNo(String dept_no) throws SQLException;
}