package com.cheban.service;

import com.cheban.DAO.implementation.DepartmentDAOImpl;
import com.cheban.model.DepartmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 20.02.2018.
 */
public class DepartmentService {
    public ArrayList<DepartmentEntity> readDepartment() throws SQLException{
        return new DepartmentDAOImpl().read();
    }

    public ArrayList<DepartmentEntity> readDepartmentByDeptNo(String dept_no) throws SQLException{
        return new DepartmentDAOImpl().readByDeptNo(dept_no);
    }

    public int createDepartment(DepartmentEntity departmentEntity) throws SQLException{
        return new DepartmentDAOImpl().create(departmentEntity);
    }

    public int updateDepartment(DepartmentEntity departmentEntity) throws SQLException{
        return new DepartmentDAOImpl().update(departmentEntity);
    }

    public int deleteDepartment(String dep_no) throws SQLException{
        return new DepartmentDAOImpl().delete(dep_no);
    }


}
