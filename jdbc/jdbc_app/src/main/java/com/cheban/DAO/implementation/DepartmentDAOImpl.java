package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.DepartmentDAO;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by MAX on 20.02.2018.
 */
public class DepartmentDAOImpl implements DepartmentDAO {
    private final String FINDALL = "SELECT * FROM department";
    private final String FINDBYDEPT_NO = "SELECT * FROM department WHERE dept_no = ?";
    private final String CREATE = "INSERT INTO department VALUES(?, ?, ?)";
    private final String UPDATE = "UPDATE department SET dept_name = ?, location = ?  WHERE dept_no = ?";
    private final String DELETE = "DELETE FROM department WHERE dept_no = ?";
    Scanner scanner = new Scanner(System.in);

    @Override
    public ResultSet read() throws SQLException{
        Connection connection = ConnectionManager.getConnection();

        System.out.println(this);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(FINDALL);
        return rs;

    }

    @Override
    public ResultSet readByDeptNo(String dept_no) throws SQLException{
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(FINDBYDEPT_NO);

        ps.setString(1, dept_no);

        return ps.executeQuery();

    }

    @Override
    public int create() throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(CREATE)) {

            String dept_no, dept_name, location;

            System.out.println("Print dept_name");
            dept_no = scanner.nextLine();

            System.out.println("Print dept_no");
            dept_name = scanner.nextLine();

            System.out.println("Print location");
            location = scanner.nextLine();
            pr.setString(1, dept_no);
            pr.setString(2, dept_name);
            pr.setString(3, location);

            return pr.executeUpdate();
        }

    }

    @Override
    public int update() throws SQLException {

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement pr = connection.prepareStatement(UPDATE)) {

            System.out.println("Print dept_no where to change");
            String dept_no = scanner.nextLine();

            System.out.println("Print name to change");
            String dept_name = scanner.nextLine();

            System.out.println("Print location to change");
            String location = scanner.nextLine();

            pr.setString(1, dept_name);
            pr.setString(2, location);
            pr.setString(3, dept_no);

            return pr.executeUpdate();
        }
    }

    @Override
    public int delete() throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(DELETE)) {
            System.out.println("Print dept_no to delete");
            String dep_no = scanner.nextLine();
            pr.setString(1, dep_no);

            return pr.executeUpdate();
        }
    }

    @Override
    public String toString(){
        return new String("Department table");
    }
}
