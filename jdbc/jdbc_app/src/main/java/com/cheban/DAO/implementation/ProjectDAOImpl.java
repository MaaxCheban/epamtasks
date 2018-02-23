package com.cheban.DAO.implementation;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.DAO.ProjectDAO;
import com.cheban.Transformer.TransformProject;
import com.cheban.Transformer.Transformer;
import com.cheban.model.ProjectEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MAX on 23.02.2018.
 */
public class ProjectDAOImpl implements ProjectDAO{
    private final String FINDALL = "SELECT * FROM project";
    private final String CREATE = "INSERT INTO project VALUES(?, ?, ?)";
    private final String UPDATE = "UPDATE project SET project_name = ?, budget = ? WHERE project_no = ?";
    private final String DELETE = "DELETE FROM project WHERE project_no = ?";
    Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<ProjectEntity> read() throws SQLException {
        Connection connection = ConnectionManager.getConnection();

        System.out.println("Employee table");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(FINDALL);

        Transformer transformer = new Transformer(new TransformProject());
        ArrayList<ProjectEntity> list = transformer.transform(rs);

        return list;
    }

    @Override
    public int create(ProjectEntity projectEntity) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(CREATE)) {

            pr.setString(1, projectEntity.getProjectNo());
            pr.setString(2, projectEntity.getProjectName());
            pr.setInt(3, projectEntity.getBudget());

            return pr.executeUpdate();
        }

    }

    @Override
    public int update(ProjectEntity projectEntity) throws SQLException {

        Connection connection = ConnectionManager.getConnection();

        try (PreparedStatement pr = connection.prepareStatement(UPDATE)) {

            pr.setString(1, projectEntity.getProjectName());
            pr.setInt(2, projectEntity.getBudget());
            pr.setString(3, projectEntity.getProjectNo());

            return pr.executeUpdate();
        }
    }

    @Override
    public int delete(String project_no) throws SQLException{

        Connection connection = ConnectionManager.getConnection();

        try(PreparedStatement pr = connection.prepareStatement(DELETE)) {

            pr.setString(1, project_no);

            return pr.executeUpdate();
        }
    }

    @Override
    public String toString(){
        return new String("Project DaoImpl");
    }
}
