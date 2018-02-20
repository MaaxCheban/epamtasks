package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.EmployeeDAO;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by MAX on 20.02.2018.
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    private final String FINDALL = "SELECT * FROM employee";
    private final String CREATE = "INSERT INTO employee VALUES(?, ?, ?, ?)";
    private final String UPDATE = "UPDATE employee SET emp_fname = ?, emp_lname = ?, dept_no = ?  WHERE emp_no = ?";
    private final String DELETE = "DELETE FROM employee WHERE emp_no = ?";
    Scanner scanner = new Scanner(System.in);

    @Override
    public ResultSet read() throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        System.out.println(this);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(FINDALL);
        return rs;

    }

    @Override
    public int create() throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(CREATE)) {

            Integer emp_no;
            String emp_fname, emp_lname, dept_no;

            System.out.println("Print emp_no to update");
            emp_no = Integer.parseInt(scanner.nextLine());

            System.out.println("Print emp_fname");
            emp_fname = scanner.nextLine();

            System.out.println("Print emp_lname");
            emp_lname = scanner.nextLine();

            System.out.println("Print dept_no");
            dept_no = scanner.nextLine();


            pr.setInt(1, emp_no);
            pr.setString(2, emp_fname);
            pr.setString(3, emp_lname);
            pr.setString(4, dept_no);

            return pr.executeUpdate();
        }

    }

    @Override
    public int update() throws SQLException {

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement pr = connection.prepareStatement(UPDATE)) {

            Integer emp_no;
            String emp_fname, emp_lname, dept_no;

            System.out.println("Print emp_no to update");
            emp_no = Integer.parseInt(scanner.nextLine());

            System.out.println("Print updated emp_fname");
            emp_fname = scanner.nextLine();

            System.out.println("Print updated emp_lname");
            emp_lname = scanner.nextLine();

            System.out.println("Print updated dept_no");
            dept_no = scanner.nextLine();



            pr.setInt(1, emp_no);
            pr.setString(2, emp_fname);
            pr.setString(3, emp_lname);
            pr.setString(4, dept_no);


            return pr.executeUpdate();
        }
    }

    @Override
    public int delete() throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(DELETE)) {
            System.out.println("Print emp_no to delete");
            int emp_no = scanner.nextInt();
            pr.setInt(1, emp_no);

            return pr.executeUpdate();
        }
    }

    @Override
    public String toString(){
        return new String("Employee table");
    }
}
