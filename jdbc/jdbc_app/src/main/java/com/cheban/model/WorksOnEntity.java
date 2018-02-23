package com.cheban.model;

import java.sql.Date;

/**
 * Created by MAX on 23.02.2018.
 */
public class WorksOnEntity {
    private int emp_no;
    private String project_no, job;
    private Date enter_date;

    public WorksOnEntity(int _emp_no, String _project_no, String _job, Date _enter_date){
        emp_no = _emp_no;
        project_no = _project_no;
        job = _job;
        enter_date = _enter_date;
    }

    public int getEmpNo(){
        return emp_no;
    }

    public void setEmpNo(int _emp_no){
        emp_no = _emp_no;
    }

    public String getProjectNo(){
        return project_no;
    }

    public void setProjectNo(String _project_no){
        project_no = _project_no;
    }

    public String getJob(){
        return job;
    }

    public void setJob(String _job){
        job = _job;
    }

    public void setEnterDate(Date _enter_date){
        enter_date = _enter_date;
    }

    public Date getEnterDate(){
        return enter_date;
    }

    @Override
    public String toString(){
        return new String(emp_no + "" + '\t' + '\t'
                + project_no + '\t' + '\t'
                + job + '\t' + '\t'
                + enter_date);
    }
}
