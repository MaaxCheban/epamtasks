package com;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        ArrayList<Station> stations = new ArrayList();
        ArrayList<Station> stations2 = new ArrayList();
        ArrayList<Station> stations3 = new ArrayList();
        ArrayList<Station> stations4 = new ArrayList();

        stations.add(new Station("Chernivtsi", new int[]{6, 1},10));
        stations.add(new Station("Kolomia", new int[]{7, 0},10));
        stations.add(new Station("Ivano Frankivsk", new int[]{8, 1}, 10));
        stations.add(new Station("Lviv", new int[]{9, 55}, 0));

        stations2.add(new Station("Odessa", new int[]{23, 30},10));
        stations2.add(new Station("Chernivtsi", new int[]{8, 0},10));
        stations2.add(new Station("Lviv", new int[]{9, 55}, 0));

        stations3.add(new Station("Kolomia", new int[]{7, 0},10));
        stations3.add(new Station("Ivano Frankivsk", new int[]{8, 1}, 10));
        stations3.add(new Station("Lviv", new int[]{9, 55}, 10));
        stations3.add(new Station("Kovel", new int[]{9, 55}, 0));

        stations4.add(new Station("Odessa", new int[]{23, 35},10));
        stations4.add(new Station("Chernivtsi", new int[]{4, 1}, 10));
        stations4.add(new Station("Ivano Frankivsk", new int[]{5, 55}, 10));
        stations4.add(new Station("Lviv", new int[]{7, 15}, 15));
        stations4.add(new Station("Kiev", new int[]{10, 0}, 0));




        ArrayList<GregorianCalendar> pauseDates = new ArrayList();
        pauseDates.add(new GregorianCalendar(2017, 11,31));

        ArrayList<Train> trainsArray = new ArrayList();
        trainsArray.add(new Train(stations, 300, new int[]{1,2,3,4,5,6,7}, pauseDates));//Second parametr is an array of days when train starts its new trip
        trainsArray.add(new Train(stations2, 300, new int[]{1,2,3,4,5,6,7}, pauseDates));//that means train go through every station and do it again in n day
        trainsArray.add(new Train(stations3, 300, new int[]{1,2,3,4,5,6,7}, pauseDates));
        trainsArray.add(new Train(stations4, 300, new int[]{1,2,3,4,5,6,7}, pauseDates));


        TicketsMenu tm = new TicketsMenu(trainsArray);



        ArrayList<Train> trains = tm.findTrains("Odessa", "Kiev", new GregorianCalendar(2018, 1, 5, 8,0));




    }
}
