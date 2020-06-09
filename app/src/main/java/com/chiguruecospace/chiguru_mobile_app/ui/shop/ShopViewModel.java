package com.chiguruecospace.chiguru_mobile_app.ui.shop;

public class ShopViewModel{

    private String Description;
    private String Imagepath;
    private String Name;
    private String Price;

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
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

    public ShopViewModel(){this.Price = "";}

    public ShopViewModel(String name, String desc, String imagepath, String price) {
        this.Name = name;
        this.Description = desc;
        this.Imagepath = imagepath;
        this.Price = price;
    }
}