package com.example.user.tome.data;

import android.widget.RatingBar;

import java.util.Date;

/**
 * Created by user on 11/29/2016.
 */
public class MyDiary {
    private String text;
    private String title;
    private Date date;
    private int importance;//1-5
    private String Id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "MyDiary{" +
                "text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", importance=" + importance +
                ", Id='" + Id + '\'' +
                '}';
    }


}
