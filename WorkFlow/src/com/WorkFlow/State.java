package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public interface State {
    void showState();

    default void openState(Task task){
        System.out.println("no opened state");
    }
    default void resolveState(Task task){
        System.out.println("no resolve state");
    }
    default void reopenedState(Task task){
        System.out.println("no reopened state");
    }
    default void closeState(Task task){
        System.out.println("no closed state");
    }
}
