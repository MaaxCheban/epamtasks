package com.cheban.service;

import com.cheban.DAO.implementation.DepartmentDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MAX on 20.02.2018.
 */
public class DepartmentService {
    public ResultSet readDepartment() throws SQLException{
        return new DepartmentDAOImpl().read();
    }

    public ResultSet readDepartmentByDeptNo(String dept_no) throws SQLException{
        return new DepartmentDAOImpl().readByDeptNo(dept_no);
    }

    public int createDepartment() throws SQLException{
        return new DepartmentDAOImpl().create();
    }

    public int updateDepartment() throws SQLException{
        return new DepartmentDAOImpl().update();
    }

    public int deleteDepartment() throws SQLException{
        return new DepartmentDAOImpl().delete();
    }

}
