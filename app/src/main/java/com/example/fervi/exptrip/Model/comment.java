package com.example.fervi.exptrip.Model;

/**
 * Created by Fernando Pereira Borges
 * Assignment2 - Mobile Development 2
 * Date: November 03, 2017
 * Purpose: Database implementation - user Database
 */

public class comment {
    private int commmentid;
    private String comment;
    private int planid;

    public void comment(int commentid)
    {this.commmentid = commentid;}

    public int getCommmentid()
    {return commmentid;}
    public void setCommmentid(int commmentid)
    {this.commmentid = commmentid;}

    public String getComment()
    {return comment;}
    public void setComment(String comment)
    {this.comment = comment;}

    public int getPlanid()
    {return planid;}
    public void setPlanid(int planid)
    {this.planid = planid;}

}
