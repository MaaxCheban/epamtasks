package com;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by MAX on 27.12.2017.
 */
class Station{
    private String name;
    private GregorianCalendar arrivalDate, departureDate;
    private int waitingTime;//in minutes
    private int trainIdBinding;
    Station(String name, int arrivalDate[], int waitingTime){
        this.name = name;
        this.waitingTime = waitingTime;
        this.arrivalDate = new GregorianCalendar(0, 0, 0, arrivalDate[0], arrivalDate[1]);
        this.departureDate = new GregorianCalendar(0, 0, 0, arrivalDate[0], arrivalDate[1] + waitingTime);
        trainIdBinding = 0;
    }
    public String getName(){
        return name;
    }
    public GregorianCalendar getArrivalDate(){
        return arrivalDate;
    }
    public void setArrivalDate(GregorianCalendar arrivalDate){
        this.arrivalDate = arrivalDate;
    }
    public GregorianCalendar getDepartureDate(){
        return departureDate;
    }
    public void setDepartureDate(GregorianCalendar departureDate){
        this.departureDate = departureDate;
    }
    public int getWaitingTime(){
        return waitingTime;
    }
    public void SetWaitingTime(int waitingTime){
        this.waitingTime = waitingTime;
    }
    public void setId(int id){
       trainIdBinding = id;
    }
    public String getId(){
        return name;
    }
}