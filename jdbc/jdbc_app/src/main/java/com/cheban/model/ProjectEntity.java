package com.cheban.model;

/**
 * Created by MAX on 23.02.2018.
 */
public class ProjectEntity {

    private String project_no, project_name;
    private int budget;

    public ProjectEntity(String _project_no, String _project_name, int _budget){
        project_no = _project_no;
        project_name = _project_name;
        budget = _budget;
    }

    public String getProjectNo(){
        return project_no;
    }

    public void setProjectNo(String _project_no){
        project_no = _project_no;
    }

    public String getProjectName(){
        return project_name;
    }

    public void setProjectName(String _project_name){
        project_name = _project_name;
    }

    public int getBudget(){
        return budget;
    }

    public void setBudget(int _budget){
        budget = _budget;
    }

    @Override
    public String toString(){
        return new String(project_no + '\t' + '\t'
                + project_name + '\t' + '\t'
                + budget);
    }

}
