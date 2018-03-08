package com;

/**
 * Created by MAX on 08.03.2018.
 */
public class WashingSystem {
    private Car car;
    public WashingSystem(Car _car){
        car = _car;
    }

    public void startWork() throws InterruptedException {
        FoamingProcess fp = new FoamingProcess(car);
    }
}
