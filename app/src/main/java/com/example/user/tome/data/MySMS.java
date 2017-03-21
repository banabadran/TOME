package com.example.user.tome.data;

import java.util.Date;
import java.util.PriorityQueue;

/**
 * Created by user on 11/27/2016.
 */
public class MySMS {

   private String name;
    private String text;
    private int Number;
    private Date date;
    private boolean isIncome;//
    private String id;




   public MySMS(){}
    public String getName() {
        return name;
    }

    public void setName(String phone) {
        this.name = phone;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {return Number;}

    public void setNumber(String number) {
        this.Number = Number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(String income) {
        isIncome = isIncome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "MySMS{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", Number=" + Number +
                ", date=" + date +
                ", isIncome=" + isIncome +
                ", id='" + id + '\'' +
                '}';
    }
}

