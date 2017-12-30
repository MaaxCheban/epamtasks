package com;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by MAX on 29.12.2017.
 */
public class TrainSystemSettings {
    private ArrayList<ArrayList<Station>> stationsList;
    private ArrayList<Train> trainsArray;

    TrainSystemSettings(){
        stationsList = new ArrayList<ArrayList<Station>>(4);
        initStations();
        initTrains();
    }
    private void initStations(){

        stationsList.add(new ArrayList());
        stationsList.add(new ArrayList());
        stationsList.add(new ArrayList());
        stationsList.add(new ArrayList());


        stationsList.get(0).add(new Station("Chernivtsi", new int[]{6, 1},10));
        stationsList.get(0).add(new Station("Kolomia", new int[]{7, 0},10));
        stationsList.get(0).add(new Station("Ivano Frankivsk", new int[]{8, 1}, 10));
        stationsList.get(0).add(new Station("Lviv", new int[]{9, 55}, 0));

        stationsList.get(1).add(new Station("Odessa", new int[]{23, 30},10));
        stationsList.get(1).add(new Station("Chernivtsi", new int[]{8, 0},10));
        stationsList.get(1).add(new Station("Lviv", new int[]{9, 55}, 0));

        stationsList.get(2).add(new Station("Kolomia", new int[]{7, 0},10));
        stationsList.get(2).add(new Station("Ivano Frankivsk", new int[]{8, 1}, 10));
        stationsList.get(2).add(new Station("Lviv", new int[]{9, 55}, 10));
        stationsList.get(2).add(new Station("Kovel", new int[]{9, 55}, 0));

        stationsList.get(3).add(new Station("Odessa", new int[]{23, 35},10));
        stationsList.get(3).add(new Station("Chernivtsi", new int[]{4, 1}, 10));
        stationsList.get(3).add(new Station("Ivano Frankivsk", new int[]{4, 55}, 10));
        stationsList.get(3).add(new Station("Lviv", new int[]{7, 15}, 15));
        stationsList.get(3).add(new Station("Kiev", new int[]{10, 0}, 0));
    }
    private void initTrains(){
        trainsArray = new ArrayList();

        trainsArray.add(new Train(stationsList.get(0), 300, new int[]{1,2,3,4,5,6,7}));//Second parametr is an array of days when train starts its new trip
        trainsArray.add(new Train(stationsList.get(1), 300, new int[]{1,2,3,4,5,6,7}));//that means train go through every station and do it again in n day
        trainsArray.add(new Train(stationsList.get(2), 300, new int[]{1,2,3,4,5,6,7}));
        trainsArray.add(new Train(stationsList.get(3), 300, new int[]{1,2,3,4,5,6,7}));
    }
    public void addTrain(Train t){
        trainsArray.add(t);
    }
    public ArrayList<Train> getTrains(){
        return trainsArray;
    }
}
