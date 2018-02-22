package com.cheban.Transformer;

import com.cheban.model.DepartmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 22.02.2018.
 */
public class TransformDepartment implements Transformable<DepartmentEntity> {

    @Override
    public ArrayList<DepartmentEntity> transform(ResultSet resultSet) throws SQLException {
        ArrayList<DepartmentEntity> entityList = new ArrayList<>();

        while(resultSet.next()){
            String dep_num = resultSet.getString(1);
            String dept_name = resultSet.getString(2);
            String location = resultSet.getString(3);

            DepartmentEntity entity = new DepartmentEntity(dep_num, dept_name, location);

            entityList.add(entity);
        }
        return entityList;
    }
}
