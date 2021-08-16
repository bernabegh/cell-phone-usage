package com.example.CellPhoneUsage.models;

import com.opencsv.bean.CsvBindByName;

public class CellPhone {

    @CsvBindByName
    private long employeeId;

    @CsvBindByName
    private String employeeName;

    @CsvBindByName
    private String purchaseDate;

    @CsvBindByName
    private String model;

    public CellPhone(long employeeId, String employeeName, String purchaseDate, String model) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.purchaseDate = purchaseDate;
        this.model = model;
    }

    public CellPhone() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
