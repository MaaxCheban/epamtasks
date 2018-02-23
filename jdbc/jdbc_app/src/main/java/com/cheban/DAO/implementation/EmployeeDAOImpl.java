package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.EmployeeDAO;
import com.cheban.Transformer.*;
import com.cheban.model.EmployeeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MAX on 22.02.2018.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private final String FINDALL = "SELECT * FROM employee";
    private final String FINDBYDEPTNAME = "SELECT * FROM employee WHERE dept_no = ?";
    private final String CREATE = "INSERT INTO employee VALUES(?, ?, ?, ?)";
    private final String UPDATE = "UPDATE employee SET emp_fname = ?, emp_lname = ?, dept_no = ?  WHERE emp_no = ?";
    private final String DELETE = "DELETE FROM employee WHERE emp_no = ?";
    Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<EmployeeEntity> read() throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        System.out.println("Employee table");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(FINDALL);

        Transformer transformer = new Transformer(new TransformEmployee());
        ArrayList<EmployeeEntity> list = transformer.transform(rs);

        return list;
    }

    @Override
    public int create(EmployeeEntity employeeEntity) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(CREATE)) {

            pr.setInt(1, employeeEntity.getEmpNo());
            pr.setString(2, employeeEntity.getFname());
            pr.setString(3, employeeEntity.getLname());
            pr.setString(4, employeeEntity.getDeptNo());

            return pr.executeUpdate();
        }

    }

    @Override
    public int update(EmployeeEntity employeeEntity) throws SQLException {

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement pr = connection.prepareStatement(UPDATE)) {

            pr.setString(1, employeeEntity.getFname());
            pr.setString(2, employeeEntity.getLname());
            pr.setString(3, employeeEntity.getDeptNo());
            pr.setInt(4, employeeEntity.getEmpNo());


            return pr.executeUpdate();
        }
    }

    @Override
    public int delete(int emp_no) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(DELETE)) {

            pr.setInt(1, emp_no);

            return pr.executeUpdate();
        }
    }

    @Override
    public ArrayList<EmployeeEntity> readByDeptNo(String dept_no) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        ArrayList<EmployeeEntity> entities = new ArrayList<>();

        PreparedStatement pr = connection.prepareStatement(FINDBYDEPTNAME);
        pr.setString(1, dept_no);

        Transformer transformer = new Transformer(new TransformEmployee());
        entities = transformer.transform(pr.executeQuery());

        return entities;
    }

    @Override
    public String toString(){
        return new String("Employee DaoImpl");
    }
}

