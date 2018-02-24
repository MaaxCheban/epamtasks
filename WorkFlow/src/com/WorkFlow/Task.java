package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public class Task{
    private State state;
    private boolean isAsigned;

    public Task(){
        state = new Opened();
        isAsigned = false;
    }

    public void resolveState(){
        state.resolveState(this);
    }
    public void reopenState(){
        state.reopenedState(this);
    }
    public void closeState(){
        state.closeState(this);
    }


    void setState(State _state){
        state = _state;
    }

    public void showState(){
        state.showState();
    }

    public void setAssign(boolean val){
        isAsigned = val;
    }

}