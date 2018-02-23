package com.cheban.DAO;

import com.cheban.model.ProjectEntity;

import java.sql.SQLException;

/**
 * Created by MAX on 23.02.2018.
 */
public interface ProjectDAO extends GeneralDAO<ProjectEntity>{
    int delete(String project_no) throws SQLException;
}
