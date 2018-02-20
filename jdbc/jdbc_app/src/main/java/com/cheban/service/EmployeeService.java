package com.cheban.service;

import com.cheban.DAO.implementation.DepartmentDAOImpl;
import com.cheban.DAO.implementation.EmployeeDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MAX on 20.02.2018.
 */
public class EmployeeService {

    public ResultSet readEmployee() throws SQLException {
        return new EmployeeDAOImpl().read();
    }

    public int createEmployee() throws SQLException{
        return new EmployeeDAOImpl().create();
    }

    public int updateEmployee() throws SQLException{
        return new EmployeeDAOImpl().update();
    }

    public int deleteEmployee() throws SQLException{
        return new EmployeeDAOImpl().delete();
    }


}
