package com;

import java.io.FileNotFoundException;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        TrainsMenu menu = new TrainsMenu();

        menu.findTrains("Ivano Frankivsk","Lviv",new GregorianCalendar(2018,1,15,8,0));


    }
}
