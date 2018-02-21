package com;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Car lightCar = new Car(new LightCar(), new EngineA());
        Car heavyCar = new Car(new HeavyCar(), new EngineB());

        lightCar.drive();
        lightCar.showEngine();
        heavyCar.drive();
        heavyCar.showEngine();
    }
}
