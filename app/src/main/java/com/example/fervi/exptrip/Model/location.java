package com.example.fervi.exptrip.Model;

import java.util.Date;

/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */

public class location {
    private int locationid;
    private String location_name;
    private String start_date;
    private String end_date;

    public void location(int locationid){
        this.locationid = locationid;
    }

    public int getLocationid()
    {return locationid;}
    public void setLocationid(int locationid)
    {this.locationid = locationid;}

    public String getLocation_name()
    {return location_name;}
    public void setLocation_name(String location_name)
    {this.location_name = location_name;}

    public String getStart_date()
    {return start_date;}
    public void setStart_date(String start_date)
    {this.start_date = start_date;}

    public String getEnd_date()
    {return end_date;}
    public void setEnd_date(String end_date)
    {this.end_date = end_date;}
}
