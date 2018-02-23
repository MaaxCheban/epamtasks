package com.cheban.Transformer;

import com.cheban.DAO.ProjectDAO;
import com.cheban.model.ProjectEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by MAX on 23.02.2018.
 */
public class TransformProject implements Transformable<ProjectEntity> {

    @Override
    public ArrayList<ProjectEntity> transform(ResultSet resultSet) throws SQLException{
        ArrayList<ProjectEntity> entityList = new ArrayList<>();

        while(resultSet.next()){
            String project_no = resultSet.getString(1);
            String project_name = resultSet.getString(2);
            int budget = resultSet.getInt(3);

            ProjectEntity entity = new ProjectEntity(project_no, project_name, budget);

            entityList.add(entity);
        }

        return entityList;
    }
}
