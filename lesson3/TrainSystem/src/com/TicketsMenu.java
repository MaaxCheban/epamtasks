package com;

import java.util.*;

/**
 * Created by MAX on 27.12.2017.
 */
public class TicketsMenu {
    private ArrayList<Train> trains;
    TicketsMenu(ArrayList<Train>  trains){
        this.trains = trains;
    }
    public ArrayList<Train> findTrains(String startLocation, String endLocation){
        ArrayList<Train> trainsArr = new ArrayList();
        for(Train t: trains){
            if(t.getFreeSeats() == 0) continue;
            boolean isFrom = false, isTo = false;
            for(Station s : t.getStations()){
                if(s.getName() == startLocation ){
                    isFrom = true;
                }
                if(isFrom && s.getName() == endLocation){
                    isTo = true;
                }
                if(isFrom && isTo){
                    trainsArr.add(t);
                }
            }
        }
        showFoundTrains(trainsArr);
        return trainsArr;
    }

    public ArrayList<Train> findTrains(GregorianCalendar departureDate){
        ArrayList<Train> trainsArr = new ArrayList();

        for(Train t: trains){
            if(t.getFreeSeats() == 0) continue;
            if(!t.isWorkingDate(departureDate)) {
                System.out.println(t.getId() + " working date failed");
                continue;
            }

            for(Station s : t.getStations()){
                if(s.getDepartureDate().get(Calendar.HOUR) >=  departureDate.get(Calendar.HOUR)){
                    trainsArr.add(t);
                }
            }
        }
        showFoundTrains(trainsArr);
        return trainsArr;
    }

    public ArrayList<Train> findTrains(String startLocation, String endLocation, GregorianCalendar departureDate){
        ArrayList<Train> trainsArr = new ArrayList();

        for(Train t: trains){
            if(t.getFreeSeats() == 0) continue;
            boolean isFrom = false, isTo = false;
            for(Station s : t.getStations()){

                //remove bag
                if(isFrom && isTo){
                    continue;
                }
                if(s.getName() == startLocation ){
                    isFrom = true;
                }
                if(isFrom && s.getName() == endLocation){
                    isTo = true;
                }
                if(isFrom && isTo){
                    trainsArr.add(t);
                }

            }
        }

        int i = 0;
        for(Train t: trainsArr){
            if(t.getFreeSeats() == 0) continue;
            if(!t.isWorkingDate(departureDate)) {
                System.out.println(t.getId() + " working date failed");
                continue;
            }

            for(Station s : t.getStations()){
                if(s.getName() == startLocation){
                    if((s.getDepartureDate().get(Calendar.HOUR) <  departureDate.get(Calendar.HOUR))){
                        trainsArr.remove(i++);
                    }
                }

            }
        }

        showFoundTrains(trainsArr);

        return trainsArr;
    }

    private void showFoundTrains(ArrayList<Train> tr){
        for(Train t: tr){
            System.out.println(t.getStations().get(0).getName() + "-" +
                    t.getStations().get(t.getStations().size() - 1).getName() + " " +
                    t.getId() + "-" + "train id");
        }
    }
}
