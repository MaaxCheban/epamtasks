package com.cheban.View;

import com.cheban.DAO.DepartmentDAO;
import com.cheban.model.DepartmentEntity;
import com.cheban.model.EmployeeEntity;
import com.cheban.model.ProjectEntity;
import com.cheban.model.WorksOnEntity;
import com.cheban.service.DepartmentService;
import com.cheban.service.EmployeeService;
import com.cheban.service.ProjectService;
import com.cheban.service.WorksOnService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        menu.put("16", "Delete department with employee move");

        //----------------------------------

        menu.put("21", "Create employee");
        menu.put("22", "Read employee");
        menu.put("23", "Update employee");
        menu.put("24", "Delete employee");

        //----------------------------------

        menu.put("31", "Create project");
        menu.put("32", "Read project");
        menu.put("33", "Update project");
        menu.put("34", "Delete project");

        //----------------------------------

        menu.put("41", "Create work on");
        menu.put("42", "Read works on");
        menu.put("43", "Update work on");
        menu.put("44", "Delete work on");

        //----------------------------------

        menuMethods.put("11", this::createDepartment);
        menuMethods.put("12", this::readDepartment);
        menuMethods.put("13", this::updateDepartment);
        menuMethods.put("14", this::deleteDepartment);
        menuMethods.put("15", this::readDepartmentByDeptNo);
        menuMethods.put("16", this::deleteWithEmployeeMove);

        //----------------------------------

        menuMethods.put("21", this::createEmployee);
        menuMethods.put("22", this::readEmployee);
        menuMethods.put("23", this::updateEmployee);
        menuMethods.put("24", this::deleteEmployee);

        //----------------------------------

        menuMethods.put("31", this::createProject);
        menuMethods.put("32", this::readProject);
        menuMethods.put("33", this::updateProject);
        menuMethods.put("34", this::deleteProject);

        //----------------------------------

        menuMethods.put("41", this::createWorkOn);
        menuMethods.put("42", this::readWorkOn);
        menuMethods.put("43", this::updateWorkOn);
        menuMethods.put("44", this::deleteWorkOn);
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
            if((entry.getKey().substring(0, 1).equals(choice)) && entry.getKey().length() != 1 ){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public <T> void showEntity(ArrayList<T> entitiesList){
        for(T entity: entitiesList){
            System.out.println(entity.toString());
        }
    }

    //----------------------------------------------------------

    public void readDepartment(){
        DepartmentService ds = new DepartmentService();
        try{
            ArrayList<DepartmentEntity> enitities = ds.readDepartment();

            showEntity(enitities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void readDepartmentByDeptNo(){
        DepartmentService ds = new DepartmentService();

        String dept_no;
        System.out.println("Print please dept_no");

        dept_no = scanner.nextLine();
        try {
            ArrayList<DepartmentEntity> enitities = ds.readDepartmentByDeptNo(dept_no);

            showEntity(enitities);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createDepartment(){
        DepartmentService ds = new DepartmentService();

        try {
            String dept_no, dept_name, location;

            System.out.println("Print dept_name");
            dept_no = scanner.nextLine();

            System.out.println("Print dept_no");
            dept_name = scanner.nextLine();

            System.out.println("Print location");
            location = scanner.nextLine();

            DepartmentEntity departmentEntity = new DepartmentEntity(dept_no, dept_name, location);

            ds.createDepartment(departmentEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteWithEmployeeMove(){
        DepartmentService ds = new DepartmentService();

        try {
            System.out.println("Print dept_no to delete");
            String dept_delete = scanner.nextLine();

            System.out.println("Print dept_no to update");
            String dept_update = scanner.nextLine();

            ds.deleteWithEmployeeMove(dept_delete, dept_update);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void updateDepartment(){
        DepartmentService ds = new DepartmentService();
        System.out.println("Print dept_no where to change");
        String dept_no = scanner.nextLine();

        System.out.println("Print name to change");
        String dept_name = scanner.nextLine();

        System.out.println("Print location to change");
        String location = scanner.nextLine();

        DepartmentEntity departmentEntity = new DepartmentEntity(dept_no, dept_name, location);
        try {
            ds.updateDepartment(departmentEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDepartment(){
        DepartmentService ds = new DepartmentService();

        try {

            System.out.println("Print dept_no to delete");
            String dept_no = scanner.nextLine();
            ds.deleteDepartment(dept_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //----------------------------------------------------------

    public void readEmployee(){

        EmployeeService es = new EmployeeService();

        try {

            ArrayList<EmployeeEntity> enitities = es.readEmployee();

            showEntity(enitities);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createEmployee(){

        try {
            Integer emp_no;
            String emp_fname, emp_lname, dept_no;

            System.out.println("Print emp_no to create");
            emp_no = Integer.parseInt(scanner.nextLine());

            System.out.println("Print emp_fname");
            emp_fname = scanner.nextLine();

            System.out.println("Print emp_lname");
            emp_lname = scanner.nextLine();

            System.out.println("Print dept_no");
            dept_no = scanner.nextLine();

            EmployeeEntity employeeEntity = new EmployeeEntity(emp_no, emp_fname, emp_lname, dept_no);

            EmployeeService es = new EmployeeService();
            es.createEmployee(employeeEntity);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateEmployee(){

        try {
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

            EmployeeEntity employeeEntity = new EmployeeEntity(emp_no, emp_fname, emp_lname, dept_no);

            EmployeeService es = new EmployeeService();
            es.updateEmployee(employeeEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteEmployee(){
        EmployeeService es = new EmployeeService();

        try {
            System.out.println("Print emp_no to delete");
            int emp_no = scanner.nextInt();
            es.deleteEmployee(emp_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------

    public void readWorkOn(){

        WorksOnService ws = new WorksOnService();

        try {

            ArrayList<WorksOnEntity> enitities = ws.readWorkOn();

            showEntity(enitities);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createWorkOn(){

        try {

            System.out.println("Print emp_no");
            int emp_no = Integer.parseInt(scanner.nextLine());

            System.out.println("Print project_no");
            String project_no = scanner.nextLine();

            System.out.println("Print job");
            String job = scanner.nextLine();

            System.out.println("Print enter_date, format yyyy-MM-dd");
            String enter_date = scanner.nextLine();
            java.sql.Date enterSqlDate = null;
            try {
                java.util.Date enterUtilDate = new SimpleDateFormat("yyyy-MM-dd").parse(enter_date);
                enterSqlDate = new java.sql.Date(enterUtilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }

            WorksOnEntity worksOnEntity = new WorksOnEntity(emp_no, project_no, job, enterSqlDate);

            WorksOnService ps = new WorksOnService();
            ps.createWorkOn(worksOnEntity);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateWorkOn(){

        try {
            System.out.println("Print emp_no to update");
            int emp_no = Integer.parseInt(scanner.nextLine());

            System.out.println("Print project_no to update");
            String project_no = scanner.nextLine();

            System.out.println("Print updated job");
            String job = scanner.nextLine();

            System.out.println("Print updated enter_date, format(yyyy-MM-dd");
            String enter_date = scanner.nextLine();
            java.sql.Date enterSqlDate = null;
            try {
                java.util.Date enterUtilDate = new SimpleDateFormat("yyyy-MM-dd").parse(enter_date);
                enterSqlDate = new java.sql.Date(enterUtilDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }

            WorksOnEntity worksOnEntity = new WorksOnEntity(emp_no, project_no, job, enterSqlDate);

            WorksOnService ps = new WorksOnService();
            ps.updateWorkOn(worksOnEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteWorkOn(){

        try {
            WorksOnService es = new WorksOnService();
            System.out.println("Print emp_no to delete");
            int emp_no = scanner.nextInt();
            es.deleteWorkOn(emp_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //----------------------------------------------------------

    public void readProject(){

        ProjectService ps = new ProjectService();

        try {

            ArrayList<ProjectEntity> enitities = ps.readProject();

            showEntity(enitities);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createProject(){

        try {


            System.out.println("Print project_no to create");
            String project_no = scanner.nextLine();

            System.out.println("Print project_name");
            String project_name = scanner.nextLine();

            System.out.println("Print budget");
            int budget = Integer.parseInt(scanner.nextLine());

            ProjectEntity projectEntity = new ProjectEntity(project_no, project_name, budget);

            ProjectService ps = new ProjectService();
            ps.createProject(projectEntity);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateProject(){

        try {
            System.out.println("Print project_no to update");
            String project_no = scanner.nextLine();

            System.out.println("Print updated project_name");
            String project_name = scanner.nextLine();

            System.out.println("Print updated budget");
            int budget = Integer.parseInt(scanner.nextLine());

            ProjectEntity projectEntity = new ProjectEntity(project_no, project_name, budget);

            ProjectService ps = new ProjectService();
            ps.updateProject(projectEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteProject(){
        ProjectService es = new ProjectService();

        try {
            System.out.println("Print emp_no to delete");
            String project_no = scanner.nextLine();
            es.deleteProject(project_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //----------------------------------------------------------

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
