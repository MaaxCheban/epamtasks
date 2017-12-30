package com;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by MAX on 27.12.2017.
 */
public class Train {
    private int freeSeats, id;
    private ArrayList<GregorianCalendar> pauseDates;
    private ArrayList<Station> stations;
    private int workDays[];
    Train(ArrayList<Station> stations, int freeSeats, int workDays[]){
        this.stations = stations;
        this.freeSeats = freeSeats;
        this.workDays = workDays;
        pauseDates = new ArrayList();
        id = (int)(Math.random() * 100000) + 1;
        initStationsWithId();
    }
    Train(ArrayList<Station> stations, int freeSeats, int workDays[], ArrayList<GregorianCalendar> pauseDates){
        this.stations = stations;
        this.freeSeats = freeSeats;
        this.workDays = workDays;
        this.pauseDates = pauseDates;
        id = (int)(Math.random() * 100000) + 1;
        initStationsWithId();
    }

    private void initStationsWithId(){
        for(Station st: stations){
            st.setId(id);
        }
    }
    public int getId(){
        return id;
    }
    public ArrayList<Station> getStations(){
        return stations;
    }
    public void setStations(ArrayList<Station> stations){
        this.stations = stations;
    }
    public int getFreeSeats(){
        return freeSeats;
    }
    public int[] getWorkDays(){
        return this.workDays;
    }
    public void setWorkDays( int workDays[]){
        this.workDays = workDays;
    }
    public ArrayList<GregorianCalendar>  getPauseDates(){
        return pauseDates;
    }
    public void setPauseDays(GregorianCalendar pday){
        pauseDates.add(pday);
    }
    public boolean isWorkingDate(GregorianCalendar checkingDate){

        if(pauseDates != null){
            for(GregorianCalendar pdate : pauseDates){
                if(pdate.get(Calendar.DATE) == checkingDate.get(Calendar.DATE)){
                    return false;
                }
            }
        }

        int dayOfTheWeek = checkingDate.get(Calendar.DAY_OF_WEEK);
        for(int wDay: workDays){
            if(dayOfTheWeek == wDay){
                return true;
            }
        }
        return false;
    }
}
