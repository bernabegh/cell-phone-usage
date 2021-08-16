package com.example.CellPhoneUsage.models;

import java.util.ArrayList;
import java.util.List;

public class Detail {

    private Long employeeId;
    private String employeeName;
    private String model;
    private String purchaseDate;
    private List<Integer> minutesByMonth = new ArrayList<>();
    private List<Double> dataByMonth = new ArrayList<>();

    public Detail() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<Integer> getMinutesByMonth() {
        return minutesByMonth;
    }

    public void setMinutesByMonth(List<Integer> minutesByMonth) {
        this.minutesByMonth = minutesByMonth;
    }

    public List<Double> getDataByMonth() {
        return dataByMonth;
    }

    public void setDataByMonth(List<Double> dataByMonth) {
        this.dataByMonth = dataByMonth;
    }
}
