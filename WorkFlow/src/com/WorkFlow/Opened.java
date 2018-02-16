package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public class Opened implements State {
    public void showState(){
        System.out.println("Opened state");
    }

    @Override
    public void resolveState(Task task){
        task.setState(new Resolved());
    }

    @Override
    public String toString(){
        return new String("Opened state");
    }
}