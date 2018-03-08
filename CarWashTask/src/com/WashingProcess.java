package com;

/**
 * Created by MAX on 08.03.2018.
 */
public class WashingProcess implements Runnable {
    Thread thrd;
    private Car car;

    public WashingProcess(Car _car){
        thrd = new Thread(this);
        car = _car;
        thrd.start();
    }

    @Override
    public void run(){
        System.out.println("Washing process");
        try {
            while(car.getState() != CarState.FOAMED){
                wait();
            }
            Thread.sleep(1000);

            DryingProcess dp = new DryingProcess(car);
            car.setState(CarState.WASHED, dp);
            System.out.println("washing: " + car.getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
