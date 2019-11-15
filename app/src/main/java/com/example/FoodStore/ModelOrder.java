package com.example.FoodStore;

public class ModelOrder {
    private String item_name, item_price, item_quantity, item_shop, item_url, item_owner;
    private String uname, uaddress, uphone;

    public ModelOrder()
    {
    }

    public ModelOrder(String item_name, String item_price, String item_quantity, String item_shop, String item_url, String item_owner, String uname, String uaddress, String uphone) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
        this.item_shop = item_shop;
        this.item_url = item_url;
        this.item_owner = item_owner;
        this.uname = uname;
        this.uaddress = uaddress;
        this.uphone = uphone;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(String item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getItem_shop() {
        return item_shop;
    }

    public void setItem_shop(String item_shop) {
        this.item_shop = item_shop;
    }

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public String getItem_owner() {
        return item_owner;
    }

    public void setItem_owner(String item_owner) {
        this.item_owner = item_owner;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }
}