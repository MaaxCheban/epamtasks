package com;

/**
 * Created by MAX on 08.03.2018.
 */
public class FoamingProcess implements Runnable{
    Thread thrd;
    private Car car;

    public FoamingProcess(Car _car){
        thrd = new Thread(this);
        car = _car;
        thrd.start();
    }

    @Override
    public void run(){
        System.out.println("Foaming process");
        try {
            while(car.getState() != CarState.UNWASHED) {
                wait();
            }
            Thread.sleep(1000);
            WashingProcess wp = new WashingProcess(car);
            car.setState(CarState.FOAMED, wp);
            System.out.println("foaming: " + car.getState());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
