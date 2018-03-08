package com;

/**
 * Created by MAX on 08.03.2018.
 */
public class Car {
    private CarState state;

    public Car(CarState _state){
        state = _state;
    }

    public void setState(CarState _state, Runnable process){
        synchronized (process){
            state = _state;
            process.notify();
        }
    }

    synchronized public void setState(CarState _state){
        state = _state;
    }

    synchronized public CarState getState(){
        return state;
    }
}
