package com;
import java.util.Date;
/**
 * Created by MAX on 27.12.2017.
 */
public class Ticket {
    private String from, to;
    private Date fromDate, toDate;
    private int trainId;
    Ticket(){

    }

    public String getStartLocation(){
        return from;
    }
    public String getEndLocation(){
        return to;
    }
}
