package com.cheban.service;

import com.cheban.DAO.implementation.ProjectDAOImpl;
import com.cheban.DAO.implementation.WorkOnDAOImpl;
import com.cheban.model.ProjectEntity;
import com.cheban.model.WorksOnEntity;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 23.02.2018.
 */
public class WorksOnService {

    public ArrayList<WorksOnEntity> readWorkOn() throws SQLException {
        return new WorkOnDAOImpl().read();
    }

    public int updateWorkOn(WorksOnEntity entity) throws SQLException{
        return new WorkOnDAOImpl().update(entity);
    }

    public int createWorkOn(WorksOnEntity entity) throws SQLException{
        return new WorkOnDAOImpl().create(entity);
    }

    public int deleteWorkOn(int emp_no) throws SQLException{
        return new WorkOnDAOImpl().delete(emp_no);
    }


}
