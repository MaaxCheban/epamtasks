package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.DepartmentDAO;
import com.cheban.Transformer.TransformDepartment;
import com.cheban.Transformer.TransformEmployee;
import com.cheban.Transformer.Transformer;
import com.cheban.model.DepartmentEntity;
import com.cheban.model.EmployeeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MAX on 20.02.2018.
 */
public class DepartmentDAOImpl implements DepartmentDAO {
    private final String FINDALL = "SELECT * FROM department";
    private final String FINDBYDEPTNO = "SELECT * FROM department WHERE dept_no = ?";
    private final String CREATE = "INSERT INTO department VALUES(?, ?, ?)";
    private final String UPDATE = "UPDATE department SET dept_name = ?, location = ?  WHERE dept_no = ?";
    private final String DELETE = "DELETE FROM department WHERE dept_no = ?";
    Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<DepartmentEntity> read() throws SQLException{
        Connection connection = ConnectionManager.getConnection();

        System.out.println("Department table");
        Statement statement = connection.createStatement();

        Transformer transformer = new Transformer(new TransformDepartment());
        ArrayList<DepartmentEntity> list = transformer.transform(statement.executeQuery(FINDALL));

        return list;

    }

    @Override
    public ArrayList<DepartmentEntity> readByDeptNo(String dept_no) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(FINDBYDEPTNO);

        ps.setString(1, dept_no);


        Transformer transformer = new Transformer(new TransformDepartment());
        ArrayList<DepartmentEntity> list = transformer.transform(ps.executeQuery());

        return list;

    }

    @Override
    public int create(DepartmentEntity departmentEntity) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(CREATE)) {

            pr.setString(1, departmentEntity.getDeptNo());
            pr.setString(2, departmentEntity.getDeptName());
            pr.setString(3, departmentEntity.getLocation());

            return pr.executeUpdate();
        }

    }

    @Override
    public int update(DepartmentEntity departmentEntity) throws SQLException {

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement pr = connection.prepareStatement(UPDATE)) {

            pr.setString(1, departmentEntity.getDeptName());
            pr.setString(2, departmentEntity.getLocation());
            pr.setString(3, departmentEntity.getDeptNo());

            return pr.executeUpdate();
        }
    }

    @Override
    public int delete(String dep_no) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(DELETE)) {

            pr.setString(1, dep_no);

            return pr.executeUpdate();
        }
    }

    @Override
    public String toString(){
        return new String("Department DaoImpl");
    }
}
