package com.chiguruecospace.chiguru_mobile_app.ui.home;

import com.google.firebase.Timestamp;

public class HomeViewModel{

    private String Description;
    private String Title;
    private String Imagepath;
    private Timestamp Date;

    public void setTimestamp(Timestamp timestamp) {
        this.Date = timestamp;
    }

    public Timestamp getTimestamp() {
        return Date;
    }

    public String getImagepath() {
        return Imagepath;
    }

    public void setImagepath(String imagepath) {
        Imagepath = imagepath;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public String getTitle() {
        return Title;
    }

    public HomeViewModel(){}

    public HomeViewModel(String title, String desc) {
        this.Title = title;
        this.Description = desc;
    }

}