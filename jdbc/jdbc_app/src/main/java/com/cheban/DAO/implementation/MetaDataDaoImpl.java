package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.model.TableStructure.ColumnStructure;
import com.cheban.model.TableStructure.TableStructure;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAX on 24.02.2018.
 */
public class MetaDataDaoImpl {


    public List<TableStructure> getTablesStructures() throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        String dbName = connection.getCatalog(), tableName;
        DatabaseMetaData metaData = connection.getMetaData();
        String[] type = {"TABLE"};
        List<TableStructure> list = new ArrayList<>();

        ResultSet resultTables = metaData.getTables(dbName, null, "%", type);

        while(resultTables.next()){
            tableName = resultTables.getString("TABLE_NAME");
            TableStructure table = new TableStructure();
            table.setDbName(dbName);
            table.setTableName(tableName);

            //------GETTING PRIMARY KEYS LIST---------
            List<String> primaryKeys = new ArrayList<>();
            ResultSet pkResultSet = metaData.getPrimaryKeys(connection.getCatalog(), null, tableName);

            while (pkResultSet.next()) {
                primaryKeys.add(pkResultSet.getString("COLUMN_NAME"));
            }
            //----------------------------------------

            //------GETTING FOREIGN KEYS LIST---------
            List<String> foreignKeys = new ArrayList<>();
            ResultSet fkResultSet = metaData.getImportedKeys(dbName, null, tableName);
            while (fkResultSet.next()) {
                foreignKeys.add(fkResultSet.getString("FKCOLUMN_NAME"));
            }
            //-----------------------------------------

            ResultSet resultColumns = metaData.getColumns(dbName, null, tableName, "%");
            List<ColumnStructure> columns = new ArrayList<>();
            while(resultColumns.next()){
                ColumnStructure columnStructure = new ColumnStructure();
                columnStructure.setColumnName(resultColumns.getString("COLUMN_NAME"));
                columnStructure.setColumnType(resultColumns.getString("TYPE_NAME"));
                columnStructure.setColumnSize(resultColumns.getInt("COLUMN_SIZE"));
                columnStructure.setIsNull(resultColumns.getString("IS_NULLABLE").equals("YES") ? true : false);
                columnStructure.setIsAutoIncremented(resultColumns.getString("IS_AUTOINCREMENT").equals("IS_AUTOINCREMENT") ? true : false);
                columnStructure.setPrimaryKey(false);

                for(String primaryKey : primaryKeys){
                    if(primaryKey.equals(columnStructure.getColumnName())){
                        columnStructure.setPrimaryKey(true);
                    }
                }

                for(String foreignKey : foreignKeys){
                    if(foreignKey.equals(columnStructure.getColumnName())){
                        columnStructure.setIsForeignKey(true);
                    }
                }

                columns.add(columnStructure);
            }
            table.setColumns(columns);
            list.add(table);
        }

        return list;
    }

}
