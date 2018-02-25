package com.cheban.service;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.implementation.DepartmentDAOImpl;
import com.cheban.DAO.implementation.EmployeeDAOImpl;
import com.cheban.model.DepartmentEntity;
import com.cheban.model.EmployeeEntity;

import java.sql.Connection;
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

    public int deleteWithEmployeeMove(String depToDelete, String depToMove) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int deletedCount = 0;
        try {
            connection.setAutoCommit(false);

            if(new DepartmentDAOImpl().readByDeptNo(depToDelete).isEmpty()){
                throw new SQLException("Wrong department to delete");
            }

            ArrayList<EmployeeEntity> employeeEntities = new EmployeeDAOImpl().readByDeptNo(depToDelete);


            for(EmployeeEntity entity : employeeEntities){
                entity.setDeptNo(depToMove);
                new EmployeeDAOImpl().update(entity);
            }


            deletedCount = new DepartmentDAOImpl().delete(depToDelete);

            System.out.println(deletedCount + " deleted rows");

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }

        return deletedCount;
    }
}
