package com;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Car car = new Car(CarState.UNWASHED);

        WashingSystem ws = new WashingSystem(car);
        ws.startWork();
    }
}
