package com;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        TicketsMenu menu = new TicketsMenu();
        menu.findTrains("Ivano Frankivsk","Lviv",new GregorianCalendar(2018,1,15,2,0));

        //Example of adding new train into system
        ArrayList<Station> stationsList = new ArrayList();
        stationsList.add(new Station("Stambul", new int[]{23, 35},10));
        stationsList.add(new Station("Chernivtsi", new int[]{4, 1}, 10));
        stationsList.add(new Station("Ivano Frankivsk", new int[]{3, 40}, 10));
        stationsList.add(new Station("Lviv", new int[]{11, 15}, 15));
        stationsList.add(new Station("Kiev", new int[]{12, 0}, 0));

        Train t = new Train(stationsList, 300,new int[]{1,3,4,5,6,7});//Every day except monday(Monday's index is 2)
        //t.setPauseDays(new GregorianCalendar(2018,0,7)); // Possible configurations
        menu.getTrainSystem().addTrain(t);

        menu.findTrains("Ivano Frankivsk","Lviv",new GregorianCalendar(2018,0,7,2,0));


    }
}
