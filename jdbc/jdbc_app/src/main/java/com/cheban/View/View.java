package com.cheban.View;

import com.cheban.service.DepartmentService;
import com.cheban.service.EmployeeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by MAX on 20.02.2018.
 */
public class View {
    private Map<String, String> menu;
    private Map<String, Printable> menuMethods;
    Scanner scanner;

    public View(){
        scanner = new Scanner(System.in);
        menu = new HashMap<String, String>();
        menuMethods = new HashMap<String, Printable>();


        menu.put("Q", "exit");
        menu.put("1", "Department");
        menu.put("2", "employee");
        menu.put("3", "project");
        menu.put("4", "works_on");

        //----------------------------------

        menu.put("11", "Create department");
        menu.put("12", "Read departments");
        menu.put("13", "Update department");
        menu.put("14", "Delete department");
        menu.put("15", "Read department by dept_no");

        //----------------------------------

        menu.put("21", "Create employee");
        menu.put("22", "Read employee");
        menu.put("23", "Update employee");
        menu.put("24", "Delete employee");

        //----------------------------------

        menuMethods.put("11", this::createDepartment);
        menuMethods.put("12", this::readDepartment);
        menuMethods.put("13", this::updateDepartment);
        menuMethods.put("14", this::deleteDepartment);
        menuMethods.put("15", this::readDepartmentByDeptNo);

        //----------------------------------

        menuMethods.put("21", this::createEmployee);
        menuMethods.put("22", this::readEmployee);
        menuMethods.put("23", this::updateEmployee);
        menuMethods.put("24", this::deleteEmployee);

    }

    public void showMenu(){
        System.out.println("Menu");
        for(Map.Entry<String, String> entry: menu.entrySet()){
            if(entry.getKey().length() == 1){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public void showSubMenu(String choice){
        System.out.println("Sub Menu");
        for(Map.Entry<String, String> entry: menu.entrySet()){
            if(entry.getKey().substring(0, 1).equals(choice) && entry.getKey().length() != 1 ){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

//----------------------------------------------------
    public void readDepartment(){
        DepartmentService ds = new DepartmentService();
        ResultSet rs = null;
        try{
            rs = ds.readDepartment();
            while(rs.next()){
                System.out.print(rs.getString(1) + '\t' +
                        rs.getString(2) + '\t' +
                        rs.getString(3) + '\t');

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readDepartmentByDeptNo(){
        DepartmentService ds = new DepartmentService();

        String dept_no;
        System.out.println("Print please dept_no");

        dept_no = scanner.nextLine();
        try(ResultSet rs = ds.readDepartmentByDeptNo(dept_no)) {
            while(rs.next()){
                System.out.print(rs.getString(1) + '\t' +
                        rs.getString(2) + '\t' +
                        rs.getString(3) + '\t');

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createDepartment(){
        DepartmentService ds = new DepartmentService();

        try {

            ds.createDepartment();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateDepartment(){
        DepartmentService ds = new DepartmentService();

        try {
            ds.updateDepartment();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDepartment(){
        DepartmentService ds = new DepartmentService();

        try {
            ds.deleteDepartment();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------


    public void readEmployee(){

       EmployeeService es = new EmployeeService();


        try(ResultSet rs = es.readEmployee()) {
            while(rs.next()){
                System.out.print(rs.getString(1) + '\t' +
                        rs.getString(2) + '\t' +
                        rs.getString(3) + '\t' +
                        rs.getString(4) + '\t');

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createEmployee(){
        EmployeeService es = new EmployeeService();

        try {
            es.createEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateEmployee(){
        EmployeeService es = new EmployeeService();

        try {
            es.updateEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteEmployee(){
        EmployeeService es = new EmployeeService();

        try {
            es.deleteEmployee();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------
    public void showView(){
        String choice;
        do {
            showMenu();

            System.out.println("Select menu point");
            choice = scanner.nextLine();

            if(!choice.equals("Q")){
                showSubMenu(choice);
                System.out.println("Select submenu point");

                choice = scanner.nextLine();

                try {
                    menuMethods.get(choice).print();
                } catch (Exception e) {
                }
            }
        }while(!choice.equals("Q"));

    }

}
