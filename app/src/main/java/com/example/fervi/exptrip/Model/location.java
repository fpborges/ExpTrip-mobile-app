package com.example.fervi.exptrip.Model;

import java.util.Date;

/**
 * Created by Fervi on 2017-10-22.
 */

public class location {
    private int locationid;
    private String location_name;
    private Date start_date;
    private Date end_date;

    public void location(int locationid){
        this.locationid = locationid;
    }
    public int getLocationid(){
        return locationid;
    }
    public void setLocationid(){
        this.locationid = locationid;
    }
    public String getLocation_name(){
        return location_name;
    }
    public void setLocationid(String location_name)
    {this.location_name = location_name;}

    public Date getStart_date()
    {return start_date;}
    public void setStart_date(Date start_date)
    {this.start_date = start_date;}

    public Date getEnd_date()
    {return end_date;}
    public void setEnd_date(Date end_date)
    {this.end_date = end_date;}

}
