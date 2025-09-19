package com.doxart.easypops;

import java.util.Date;

public class DateResult {
    private int day, month, year;
    private String formatted;
    private Date date;

    public DateResult(int day, int month, int year, String formatted, Date date) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.formatted = formatted;
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateResult) {
        this.date = dateResult;
    }
}
