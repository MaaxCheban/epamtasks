package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MAX on 29.12.2017.
 */
public class TrainSystemSettings {
    private ArrayList<Train> trainsArray;

    TrainSystemSettings() throws FileNotFoundException {
        trainsArray = new ArrayList();
        initTrains();

    }
    public void initTrains() throws FileNotFoundException {
        System.out.println("Print name of the file");
        String fileName;
        Scanner scan = new Scanner(System.in);
        fileName = "TrainsDataBase.txt";//scan.nextLine();
        File database = new File(fileName);

        if(database.exists()) {
            Scanner dataBaseScan = new Scanner(database);
            ArrayList<Station> stations = new ArrayList();
            while(dataBaseScan.hasNextLine()) {
                String line = dataBaseScan.nextLine();

                if(line.equals("Train")){
                    continue;
                }
                if(line.equals("Train end")){
                    if(!stations.isEmpty()){
                        Train t = new Train(stations, 300, new int[]{1,2,3,4,5,6,7});
                        trainsArray.add(t);
                        stations =  new ArrayList();

                    }
                    continue;
                }
                String dataArr[];
                int hours, minutes, waitingTime, workDays[];
                dataArr = line.split(",");
                String name = dataArr[0].split(":")[1];
                hours = Integer.parseInt(dataArr[1].split(":")[1]);
                minutes =  Integer.parseInt(dataArr[2].split(":")[1]);
                waitingTime =  Integer.parseInt(dataArr[3].split(":")[1]);
                Station s = new Station(name, new int[]{hours,minutes}, waitingTime);
                stations.add(s);
            }
        }else{
            System.out.println("no file found");
        }
    }
    public void addTrain(Train t){
        trainsArray.add(t);

    }
    public void removeTrain(int index){
        trainsArray.remove(index);
    }
    public ArrayList<Train> getTrains(){
        return trainsArray;
    }
    public void setTrains(ArrayList<Train> trainsArray){
        this.trainsArray = trainsArray;
    }
}
