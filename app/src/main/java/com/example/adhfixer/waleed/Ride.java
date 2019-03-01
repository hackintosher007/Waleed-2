package com.example.adhfixer.waleed;

public class Ride {
    private String From;
    private String To;
    private String Time;
    private String Driver;
    private int Price;

    public Ride(String from, String to, String time, int price, String Driver) {

        From = from;
        To = to;
        Time = time;
        Price = price;
        this.Driver = Driver;
    }

    public String getDriver() {
        return Driver;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getPrice() {
        return Price;
    }

}
