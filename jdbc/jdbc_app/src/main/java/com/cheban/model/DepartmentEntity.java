package com.cheban.model;

import com.cheban.service.DepartmentService;

/**
 * Created by MAX on 20.02.2018.
 */
public class DepartmentEntity {
    private String dept_no, dept_name, location;

    public DepartmentEntity(String _dept_no, String _dept_name, String _location){
        dept_no = _dept_no;
        dept_name = _dept_name;
        location = _location;
    }

    public String getDeptNo(){
        return dept_no;
    }

    public void setDeptNo(String _dept_no){
        dept_no = _dept_no;
    }

    public String getDeptName(){
        return dept_name;
    }

    public void setDeptName(String _dept_name){
        dept_name = _dept_name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String _location){
        location = _location;
    }


    @Override
    public String toString(){
        return new String(dept_no + '\t' + '\t'
                + dept_name + '\t' + '\t'
                + location);
    }
}
