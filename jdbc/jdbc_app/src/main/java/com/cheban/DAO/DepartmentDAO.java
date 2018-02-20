package com.cheban.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MAX on 20.02.2018.
 */
public interface DepartmentDAO extends GeneralDAO{

    ResultSet readByDeptNo(String dept_no) throws SQLException;

}