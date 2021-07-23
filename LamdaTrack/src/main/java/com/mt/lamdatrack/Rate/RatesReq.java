package com.mt.lamdatrack.Rate;

public class RatesReq {
    String title, date, rate, change;

    public RatesReq(String title, String date, String rate, String change) {
        this.title = title;
        this.date = date;
        this.rate = rate;
        this.change = change;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
