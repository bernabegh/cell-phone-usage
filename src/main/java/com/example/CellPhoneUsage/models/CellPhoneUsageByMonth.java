package com.example.CellPhoneUsage.models;

import com.opencsv.bean.CsvBindByName;

public class CellPhoneUsageByMonth {

    @CsvBindByName
    private long emplyeeId;

    @CsvBindByName
    private String date;

    @CsvBindByName
    private int totalMinutes;

    @CsvBindByName
    private double totalData;

    public CellPhoneUsageByMonth(long emplyeeId, String date, int totalMinutes, double totalData) {
        this.emplyeeId = emplyeeId;
        this.date = date;
        this.totalMinutes = totalMinutes;
        this.totalData = totalData;
    }

    public CellPhoneUsageByMonth() {
    }

    public long getEmplyeeId() {
        return emplyeeId;
    }

    public void setEmplyeeId(long emplyeeId) {
        this.emplyeeId = emplyeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public double getTotalData() {
        return totalData;
    }

    public void setTotalData(double totalData) {
        this.totalData = totalData;
    }
}
