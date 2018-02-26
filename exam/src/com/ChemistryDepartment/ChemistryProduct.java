package com.ChemistryDepartment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MAX on 26.02.2018.
 */
public abstract class ChemistryProduct {
    protected Map<String, Boolean> tasks = new HashMap<>();

    private double weight;
    public ChemistryProduct(double _weight){
        weight = _weight;
        tasks.put("kitchen", false);
        tasks.put("garden", false);
        tasks.put("livingRoom", false);
        tasks.put("washingRoomAfterRepair", false);
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double _weight){
        weight = _weight;
    }

    public void replaceTask(String taskToBeReplaced){
        boolean val = tasks.get(taskToBeReplaced);
        tasks.replace(taskToBeReplaced, !val);
    }

    public void addTask(String taskToBeAdded){
        tasks.put(taskToBeAdded, false);
    }

    public boolean findTask(String task){
        return tasks.get(task);
    }

}
