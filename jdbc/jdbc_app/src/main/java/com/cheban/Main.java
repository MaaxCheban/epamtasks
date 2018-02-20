package com.cheban;

import com.cheban.ConnectionManager.ConnectionManager;
import com.cheban.View.View;

import java.sql.*;

/**
 * Created by MAX on 20.02.2018.
 */
public class Main {
    public static void main(String args[]){

        View view = new View();

        view.showView();

        /*try {

            Connection con = ConnectionManager.getConnection();


            Statement st = con.createStatement();

            String cre = "UPDATE department SET dept_name = ?, location = ?  WHERE dept_no = ?";

            PreparedStatement pr = con.prepareStatement(cre);

            pr.setString(1, "nubkyaa");
            pr.setString(2, "asd");
            pr.setString(3, "jopa");

            pr.execute();


            /*ResultSet rs = st.executeQuery("SELECT * FROM department");

            while(rs.next()){
                String dp_no = rs.getString(1);
                String dp_name = rs.getString(2);
                String dp_loc = rs.getString(3);

                System.out.println(dp_no + " " + dp_name + " " + dp_loc);
            }

        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }*/

    }

}
