package com.cheban.DAO;

import com.cheban.model.TableStructure.TableStructure;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by MAX on 25.02.2018.
 */
public interface MetaDataDAO {
    public List<TableStructure> getTablesStructures() throws SQLException;
}
