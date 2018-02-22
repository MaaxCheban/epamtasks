package com.cheban.Transformer;

import com.cheban.model.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 22.02.2018.
 */
public class TransformEmployee implements Transformable<EmployeeEntity> {

    @Override
    public ArrayList<EmployeeEntity> transform(ResultSet resultSet) throws SQLException{
        ArrayList<EmployeeEntity> entityList = new ArrayList<>();

        while(resultSet.next()){
            int num = resultSet.getInt(1);
            String fname = resultSet.getString(2);
            String lname = resultSet.getString(3);
            String dep_num = resultSet.getString(4);

            EmployeeEntity entity = new EmployeeEntity(num, fname, lname, dep_num);

            entityList.add(entity);
        }
        return entityList;
    }
}
