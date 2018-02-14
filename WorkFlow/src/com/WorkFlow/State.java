package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public abstract class State {
    abstract void showState();

    void openState(Task task){
    }
    void resolveState(Task task){
    }
    void reopenedState(Task task){
    }
    void closeState(Task task){
    }
}
