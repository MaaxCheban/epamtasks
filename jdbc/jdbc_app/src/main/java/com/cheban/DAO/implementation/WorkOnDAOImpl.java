package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.WorkOnDAO;
import com.cheban.Transformer.TransformProject;
import com.cheban.Transformer.TransformWorkOn;
import com.cheban.Transformer.Transformer;
import com.cheban.model.WorksOnEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MAX on 23.02.2018.
 */
public class WorkOnDAOImpl implements WorkOnDAO {
    private final String FINDALL = "SELECT * FROM works_on";
    private final String CREATE = "INSERT INTO works_on VALUES(?, ?, ?, ?)";
    private final String UPDATE = "UPDATE works_on SET job = ?, enter_date = ? WHERE emp_no = ? AND project_no = ?";
    private final String DELETE = "DELETE FROM project WHERE project_no = ?";
    Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<WorksOnEntity> read() throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        System.out.println("Works on table");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(FINDALL);

        Transformer transformer = new Transformer(new TransformWorkOn());
        ArrayList<WorksOnEntity> list = transformer.transform(rs);

        return list;
    }

    @Override
    public int create(WorksOnEntity worksOnEntity) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(CREATE)) {

            pr.setInt(1, worksOnEntity.getEmpNo());
            pr.setString(2, worksOnEntity.getProjectNo());
            pr.setString(3, worksOnEntity.getJob());
            pr.setDate(4, worksOnEntity.getEnterDate());

            return pr.executeUpdate();
        }

    }

    @Override
    public int update(WorksOnEntity worksOnEntity) throws SQLException {

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement pr = connection.prepareStatement(UPDATE)) {

            pr.setString(1, worksOnEntity.getJob());
            pr.setDate(2, worksOnEntity.getEnterDate());
            pr.setInt(3, worksOnEntity.getEmpNo());
            pr.setString(4, worksOnEntity.getProjectNo());

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
    public String toString(){
        return new String("Works on DaoImpl");
    }
}
