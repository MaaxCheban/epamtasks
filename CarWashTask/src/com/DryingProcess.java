package com;

/**
 * Created by MAX on 08.03.2018.
 */
public class DryingProcess implements Runnable{
    Thread thrd;
    private Car car;

    public DryingProcess(Car _car){
        thrd = new Thread(this);
        car = _car;
        thrd.start();
    }

    @Override
    public void run(){
        System.out.println("Drying process");
        try {
            Thread.sleep(1000);
            car.setState(CarState.DRIED);
            System.out.println("drying: " + car.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

     synchronized private void dry(){
         try {
             while (car.getState() != CarState.WASHED) {
               System.out.println("waiting in dryp");
               wait();
              }
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         car.setState(CarState.DRIED);
         System.out.println("drying: " + car.getState());
         //notifyAll();
    }
}
