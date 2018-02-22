package com.cheban.Transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 22.02.2018.
 */
public interface Transformable <E>{
    ArrayList<E> transform(ResultSet resultSet) throws SQLException;
}
