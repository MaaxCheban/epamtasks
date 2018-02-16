package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public class Closed implements State{
    public void showState(){
        System.out.println("Closed state");
    }

    @Override
    public String toString(){
        return new String("Closed state");
    }
}
