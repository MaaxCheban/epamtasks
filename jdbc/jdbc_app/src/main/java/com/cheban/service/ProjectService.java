package com.cheban.service;

import com.cheban.DAO.implementation.ProjectDAOImpl;
import com.cheban.model.ProjectEntity;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 23.02.2018.
 */
public class ProjectService {

    public ArrayList<ProjectEntity> readProject() throws SQLException{
        return new ProjectDAOImpl().read();
    }

    public int updateProject(ProjectEntity entity) throws SQLException{
        return new ProjectDAOImpl().update(entity);
    }

    public int createProject(ProjectEntity entity) throws SQLException{
        return new ProjectDAOImpl().create(entity);
    }

    public int deleteProject(String project_no) throws SQLException{
        return new ProjectDAOImpl().delete(project_no);
    }

}
