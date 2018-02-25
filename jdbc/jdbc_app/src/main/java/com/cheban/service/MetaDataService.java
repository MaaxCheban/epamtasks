package com.cheban.service;

import com.cheban.DAO.implementation.MetaDataDaoImpl;
import com.cheban.model.TableStructure.TableStructure;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MAX on 25.02.2018.
 */
public class MetaDataService {
    public List<TableStructure> showTableStructure() throws SQLException{
        return new MetaDataDaoImpl().getTablesStructures();
    }
}
