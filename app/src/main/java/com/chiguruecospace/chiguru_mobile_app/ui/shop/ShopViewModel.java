package com.chiguruecospace.chiguru_mobile_app.ui.shop;

public class ShopViewModel{

    private String Description;
    private String Name;
    private String Imagepath;
    private int Price;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return Name;
    }

    public ShopViewModel(){}

    public ShopViewModel(String name, String desc) {
        this.Name = name;
        this.Description = desc;
    }
}