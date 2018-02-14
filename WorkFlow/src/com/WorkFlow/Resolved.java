package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public class Resolved extends State{
    public void showState(){
        System.out.println("Resolved state");
    }

    @Override
    public void closeState(Task task){
        task.setState(new Closed());
    }

    @Override
    public void reopenedState(Task task){
        task.setState(new Reopened());
    }

    @Override
    public String toString(){
        return new String("Resolved state");
    }
}
