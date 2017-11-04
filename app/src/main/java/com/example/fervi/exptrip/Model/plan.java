package com.example.fervi.exptrip.Model;


/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */

public class plan {
    private int planid;
    private String plan_name;
    private Number budget;
    private String description;
    private int userid;
    private int locationid;

    public plan(int planid){
        this.planid = planid;
    }

    public int getPlanid()
    {return planid;}
    public void setPlanid(int planid)
    {this.planid = planid;}

    public String getPlan_name()
    {return plan_name;}
    public void setPlan_name(String plan_name)
    {this.plan_name = plan_name;}

    public Number getBudget()
    {return budget;}
    public void setBudget(Number budget)
    {this.budget = budget;}

    public String getDescription()
    {return description;}
    public void setDescription(String description)
    {this.description = description;}

    public int getUserid()
    {return userid;}
    public void setUserid(int userid)
    {this.userid = userid;}

    public int getLocationid()
    {return locationid;}
    public void setLocationid(int locationid)
    {this.locationid = locationid;}

}
