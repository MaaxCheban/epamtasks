package com;

import java.util.*;

/**
 * Created by MAX on 27.12.2017.
 */
public class TicketsMenu {
    private ArrayList<Train> trains;
    public TrainSystemSettings trainSystem;
    TicketsMenu(){
        trainSystem = new TrainSystemSettings();
        this.trains = trainSystem.getTrains();
    }
    public ArrayList<Train> findTrains(String startLocation, String endLocation){
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

        return trainsArr;
    }

    public ArrayList<Train> findTrains(GregorianCalendar departureDate){
        if(departureDate.getTimeInMillis() < new GregorianCalendar().getTimeInMillis()){
            return null;
        }
        ArrayList<Train> trainsArr = new ArrayList();

        for(Train t: trains){
            if(t.getFreeSeats() == 0) continue;
            if(!t.isWorkingDate(departureDate)) {
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
        if(departureDate.getTimeInMillis() < new GregorianCalendar().getTimeInMillis()){
            return null;
        }
        trains = trainSystem.getTrains();

        ArrayList<Train> trainsArr = findTrains(startLocation, endLocation);


        ArrayList<Train> resultArr = new ArrayList();
        int i = 0;

        for(Train t: trainsArr){
            if(t.getFreeSeats() == 0) continue;
            if(!t.isWorkingDate(departureDate)) {
                continue;
            }

            for(Station s : t.getStations()){
                if(s.getName() == startLocation){
                    if((s.getDepartureDate().get(Calendar.HOUR) >=  departureDate.get(Calendar.HOUR))){
                        resultArr.add(trainsArr.get(i++));
                    }
                }

            }
        }

        showFoundTrains(resultArr, startLocation, endLocation);

        return resultArr;

    }

    private void showFoundTrains(ArrayList<Train> tr){
        if(tr == null){
            System.out.println("No trains found");
            return;
        }
        for(Train t: tr){
            System.out.println(t.getStations().get(0).getName() + "-" +
                    t.getStations().get(t.getStations().size() - 1).getName() + " " +
                    t.getId() + "-" + "train id");
        }
    }
    private void showFoundTrains(ArrayList<Train> tr, String startLocation, String endLocation){
        if(tr == null){
            System.out.println("No trains found");
            return;
        }
        System.out.println("Found trains");
        for(Train t: tr){
            System.out.println(t.getStations().get(0).getName() + "-" +
                    t.getStations().get(t.getStations().size() - 1).getName() + " " +
                    t.getId() + "-" + "train id");
            System.out.println("Departure date from your station / Arrival date to the destination");
            for(Station s : t.getStations()){
                if(s.getName() == startLocation){
                    System.out.print(
                            s.getDepartureDate().get(Calendar.DATE)
                            + " date " + s.getDepartureDate().get(Calendar.HOUR) + " hours "
                            + " " + s.getDepartureDate().get(Calendar.MINUTE) + " minutes ");
                }
                if(s.getName() == endLocation){
                    System.out.println(s.getArrivalDate().get(Calendar.DATE)
                            + " date " + s.getArrivalDate().get(Calendar.HOUR) + " hours "
                            +" date " + s.getArrivalDate().get(Calendar.MINUTE) + " minutes " );
                }
            }
            System.out.println("------");
        }
    }
}
