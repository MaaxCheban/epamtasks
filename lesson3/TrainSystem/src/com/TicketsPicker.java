/*package com;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by MAX on 29.12.2017.
 */
 /*
public class TicketsPicker {
    private ArrayList<Station> stationsList[];
    private ArrayList<Train> trainsArray;
    private ArrayList<GregorianCalendar> pauseDates;
    TicketsMenu ticketsMenu;
    private int index;
    Ticket[] tickets;


    TicketsPicker(){
        index = 0;
        initPauseDates();
        initStations();
        initTrains();
        ticketsMenu =  new TicketsMenu(trainsArray);
    }
    private void initStations(){
        stationsList[index++] = new ArrayList();
        stationsList[index++] = new ArrayList();
        stationsList[index++] = new ArrayList();

        stationsList[0].add(new Station("Chernivtsi", new int[]{6, 1},10));
        stationsList[0].add(new Station("Kolomia", new int[]{7, 0},10));
        stationsList[0].add(new Station("Ivano Frankivsk", new int[]{8, 1}, 10));
        stationsList[0].add(new Station("Lviv", new int[]{9, 55}, 0));

        stationsList[1].add(new Station("Odessa", new int[]{23, 30},10));
        stationsList[1].add(new Station("Chernivtsi", new int[]{8, 0},10));
        stationsList[1].add(new Station("Lviv", new int[]{9, 55}, 0));

        stationsList[2].add(new Station("Kolomia", new int[]{7, 0},10));
        stationsList[2].add(new Station("Ivano Frankivsk", new int[]{8, 1}, 10));
        stationsList[2].add(new Station("Lviv", new int[]{9, 55}, 10));
        stationsList[2].add(new Station("Kovel", new int[]{9, 55}, 0));
    }
    private void initTrains(){
        trainsArray = new ArrayList();
        trainsArray.add(new Train(stationsList[0], 300, new int[]{1,2,3,4,5,6,7}, pauseDates));//Second parametr is an array of days when train starts its new trip
        trainsArray.add(new Train(stationsList[1], 300, new int[]{1,2,3,4,5,6,7}, pauseDates));//that means train go through every station and do it again in n day
        trainsArray.add(new Train(stationsList[2], 300, new int[]{1,2,3,4,5,6,7}, pauseDates));
    }
    private void initPauseDates(){
        pauseDates = new ArrayList();
        pauseDates.add(new GregorianCalendar(2017, 11,31));
    }
    public Ticket getTickets(String from, String to){
        ticketsMenu.findTrains(from, to);
    }

}*/
