package com.cheban.service;

import com.cheban.DAO.implementation.EmployeeDAOImpl;
import com.cheban.model.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 22.02.2018.
 */
public class EmployeeService {

    public ArrayList<EmployeeEntity> readEmployee() throws SQLException {
        return new EmployeeDAOImpl().read();
    }

    public int createEmployee(EmployeeEntity employeeEntity) throws SQLException{
        return new EmployeeDAOImpl().create(employeeEntity);
    }

    public int updateEmployee(EmployeeEntity employeeEntity) throws SQLException{
        return new EmployeeDAOImpl().update(employeeEntity);
    }

    public int deleteEmployee(int emp_no) throws SQLException{
        return new EmployeeDAOImpl().delete(emp_no);
    }

}
