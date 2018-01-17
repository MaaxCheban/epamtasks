package com;

import java.util.*;

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
    public void setFreeSeats(int freeSeats){
        if(freeSeats < 0){
            System.out.println("Error: negative seats number");
        }
        this.freeSeats = freeSeats;
    }
    public int[] getWorkDays(){
        return this.workDays;
    }
    public void setWorkDays( int workDays[]){
        if(workDays.length > 7){
            System.out.println("Error: working days more than 7");
            return;
        }
        for(int day: workDays){
            if(day < 0 || day > 7){
                System.out.println("Error: week day index is wrong " + day);
                return;
            }
        }
        this.workDays = workDays;
    }
    public ArrayList<GregorianCalendar>  getPauseDates(){
        return pauseDates;
    }
    public void setPauseDates(GregorianCalendar pday){
        pauseDates.add(pday);
    }
    public boolean isWorkingDate(GregorianCalendar checkingDate){

        if(!pauseDates.isEmpty()){
            for(GregorianCalendar pdate : pauseDates){
                if(pdate.get(Calendar.DATE) == checkingDate.get(Calendar.DATE)){
                    return false;
                }
            }
        }

        int dayOfTheWeek = checkingDate.get(Calendar.DAY_OF_WEEK);
        if(workDays != null){
            for(int wDay: workDays){
                if(dayOfTheWeek == wDay){
                    return true;
                }
            }
        }
        return false;
    }
}
