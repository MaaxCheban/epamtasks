package com.WorkFlow;

/**
 * Created by MAX on 14.02.2018.
 */
public class Task {
    State state;

    public Task(){
        state = new Opened();
    }

    public void changeState(State _state){

        switch(_state.toString()){
            case "Resolved state": state.resolveState(this); break;
            case "Reopened state": state.reopenedState(this); break;
            case "Closed state": state.closeState(this); break;
        }
    }

    void setState(State _state){
        state = _state;
    }

    public void showState(){
        state.showState();
    }
}