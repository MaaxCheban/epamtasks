package com;

/**
 * Created by MAX on 21.02.2018.
 */
public class Car {
    private CarApi carApi;
    private EngineApi engineApi;

    public Car(CarApi _carApi, EngineApi _engineApi){
        carApi = _carApi;
        engineApi = _engineApi;
    }

    public void drive(){
        carApi.driveCar();
    }

    public void showEngine(){
        engineApi.showEngine();
    }

}
