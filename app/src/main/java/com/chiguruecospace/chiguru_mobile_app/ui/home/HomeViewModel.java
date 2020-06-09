package com.chiguruecospace.chiguru_mobile_app.ui.home;

import android.widget.Toast;

import com.google.firebase.Timestamp;

public class HomeViewModel{

    private String Date;
    private String Description;
    private String Imagepath;
    private String Title;

    public void setDate(String date) {
        this.Date = date;
    }

    public String getDate() {
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

    public HomeViewModel(){
    }

    public HomeViewModel(String title, String desc, String date, String imagepath) {
        this.Title = title;
        this.Description = desc;
        this.Date = date;
        this.Imagepath = imagepath;
    }

}