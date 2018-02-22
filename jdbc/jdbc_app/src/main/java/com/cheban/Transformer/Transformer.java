package com.cheban.Transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 22.02.2018.
 */
public class Transformer {
    Transformable strategy;

    public Transformer(Transformable _strategy){
        strategy = _strategy;
    }

    public void setStrategy(Transformable _strategy){
        strategy = _strategy;
    }

    public ArrayList transform(ResultSet resultSet) throws SQLException{
        return strategy.transform(resultSet);
    }

}
