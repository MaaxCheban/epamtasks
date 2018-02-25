package com.cheban.model.TableStructure;

import java.util.List;

/**
 * Created by MAX on 25.02.2018.
 */
public class TableStructure {
    private String dbName;
    private String tableName;
    private List<ColumnStructure> columns;

    public String getDbName(){
        return dbName;
    }

    public void setDbName(String _dbName){
        dbName = _dbName;
    }

    public String getTableName(){
        return tableName;
    }

    public void setTableName(String _tableName){
        tableName = _tableName;
    }

    public List<ColumnStructure> getColumns(){
        return columns;
    }

    public void setColumns(List<ColumnStructure> _columns){
        columns = _columns;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Database: " + dbName + "\n");
        sb.append("Table: " + tableName + "\n");
        for (ColumnStructure column : columns){
            sb.append(column + "\n");
        }
        return sb.toString();
    }
}