package com.cheban.model;

/**
 * Created by MAX on 22.02.2018.
 */
public class EmployeeEntity {
    private int emp_no;
    private String emp_fname, emp_lname, dept_no;

    public EmployeeEntity(int _emp_no, String _emp_fname, String _emp_lname, String _dept_no){
        emp_no = _emp_no;
        emp_fname = _emp_fname;
        emp_lname = _emp_lname;
        dept_no = _dept_no;
    }

    public String getDeptNo(){
        return dept_no;
    }

    public void setDeptNo(String _dept_no){
        dept_no = _dept_no;
    }

    public int getEmpNo(){
        return emp_no;
    }

    public void setEmpNo(int _emp_no){
        emp_no = _emp_no;
    }

    public String getFname(){
        return emp_fname;
    }

    public void setFname(String _emp_fname){
        emp_fname = _emp_fname;
    }

    public String getLname(){
        return emp_lname;
    }

    public void setLname(String _emp_lname){
        emp_lname = _emp_lname;
    }

    @Override
    public String toString(){
        return new String(emp_no + "" + '\t' + '\t'
                + emp_fname + '\t' + '\t'
                + emp_lname + '\t' + '\t'
                + dept_no);
    }
}
