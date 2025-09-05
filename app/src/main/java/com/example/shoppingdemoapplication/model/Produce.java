package com.example.shoppingdemoapplication.model;

import java.io.Serializable;

public class Produce implements Serializable {
    private String title;
    private String content;
    private double price;
    private int imageUrl;

    private String detail;
    public Produce(){

    }

    public Produce(String title,String content,double price,int imageurl,String detail){
        this.title=title;
        this.content=content;
        this.price=price;
        this.imageUrl=imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
