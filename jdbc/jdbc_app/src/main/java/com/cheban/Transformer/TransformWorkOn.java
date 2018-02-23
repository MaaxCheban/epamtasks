package com.cheban.Transformer;

import com.cheban.model.WorksOnEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by MAX on 23.02.2018.
 */
public class TransformWorkOn implements Transformable<WorksOnEntity> {

    @Override
    public ArrayList<WorksOnEntity> transform(ResultSet resultSet) throws SQLException{
        ArrayList<WorksOnEntity> entities = new ArrayList<>();

        while(resultSet.next()){
            int emp_no = resultSet.getInt(1);
            String project_no = resultSet.getString(2);
            String job = resultSet.getString(3);
            Date enter_date = resultSet.getDate(4);

            WorksOnEntity entity = new WorksOnEntity(emp_no, project_no, job, enter_date);

            entities.add(entity);
        }

        return entities;
    }
}
