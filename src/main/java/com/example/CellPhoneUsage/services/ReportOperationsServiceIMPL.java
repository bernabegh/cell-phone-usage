package com.example.CellPhoneUsage.services;

import com.example.CellPhoneUsage.models.CellPhone;
import com.example.CellPhoneUsage.models.CellPhoneUsageByMonth;
import com.example.CellPhoneUsage.models.Detail;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value="reportOperationsService")
public class ReportOperationsServiceIMPL implements IReportOperationsService {

    @Override
    public String getReportRunDate() {
        return Calendar.getInstance().getTime().toString();
    }

    @Override
    public int getTotalMinutes(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList) {
        int totalMinutes= 0;
        for(CellPhoneUsageByMonth cellPhoneUsageByMonth:cellPhoneUsageByMonthList){
            totalMinutes+= cellPhoneUsageByMonth.getTotalMinutes();
        }
        return totalMinutes;
    }

    @Override
    public double getTotalData(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList) {
        int totalData= 0;
        for(CellPhoneUsageByMonth cellPhoneUsageByMonth:cellPhoneUsageByMonthList){
            totalData+= cellPhoneUsageByMonth.getTotalData();
        }
        return totalData;
    }

    @Override
    public double getAverageMinutes(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList) {
        return getTotalMinutes(cellPhoneUsageByMonthList) / cellPhoneUsageByMonthList.size();
    }

    @Override
    public double getAverageData(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList) {
        return getTotalData(cellPhoneUsageByMonthList) / cellPhoneUsageByMonthList.size();
    }

    @Override
    public List<Detail> getDetail(List<CellPhone> cellPhones, List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList) {
        List<Detail> details = new ArrayList<>();

        cellPhones.forEach( cellPhone -> {
            Detail d = new Detail();
            d.setEmployeeId(cellPhone.getEmployeeId());
            d.setEmployeeName(getEmployeeNameById(cellPhone.getEmployeeId(),cellPhones));
            d.setModel(getModelById(cellPhone.getEmployeeId(),cellPhones));
            d.setPurchaseDate(cellPhone.getPurchaseDate());
            d.setMinutesByMonth(getDetailByMonth(cellPhone.getEmployeeId(),cellPhoneUsageByMonthList));
            d.setDataByMonth(getDetailDataByMonth(cellPhone.getEmployeeId(),cellPhoneUsageByMonthList));
            details.add(d);
        });
        return details;
    }


    private String getEmployeeNameById(long id, List<CellPhone> cellPhones){
        for( CellPhone cellPhone:cellPhones ){
            if(cellPhone.getEmployeeId() == id){
                return cellPhone.getEmployeeName();
            }
        }
        return "";
    }

    private String getModelById(long id, List<CellPhone> cellPhones){
        for( CellPhone cellPhone:cellPhones ){
            if(cellPhone.getEmployeeId() == id){
                return cellPhone.getModel();
            }
        }
        return "";
    }

    private List<Integer> getDetailByMonth (long employeeId, List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList){
        List<Integer> details = new ArrayList<>();

        for(int month = 1; month <=12; month++){
            details.add(getMinutesByEmployeeIdAndMonth(employeeId,month,cellPhoneUsageByMonthList));
        }
        return details;
    }

    private List<Double> getDetailDataByMonth (long employeeId, List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList){
        List<Double> details = new ArrayList<>();

        for(int month = 1; month <=12; month++){
            details.add(getDataByEmployeeIdAndMonth(employeeId,month,cellPhoneUsageByMonthList));
        }
        return details;
    }

    private int getMinutesByEmployeeIdAndMonth(long employeeId, int month, List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList){
        int minutes = 0;
        for(CellPhoneUsageByMonth cellPhoneUsageByMonth:cellPhoneUsageByMonthList){
            if( cellPhoneUsageByMonth.getEmplyeeId()==employeeId && getMonth(cellPhoneUsageByMonth.getDate())==month ){
                minutes+= cellPhoneUsageByMonth.getTotalMinutes();
            }
        }
        return minutes;
    }

    private double getDataByEmployeeIdAndMonth(long employeeId, int month, List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList){
        int data = 0;
        for(CellPhoneUsageByMonth cellPhoneUsageByMonth:cellPhoneUsageByMonthList){
            if( cellPhoneUsageByMonth.getEmplyeeId()==employeeId && getMonth(cellPhoneUsageByMonth.getDate())==month ){
                data+= cellPhoneUsageByMonth.getTotalData();
            }
        }
        return data;
    }
    private int getMonth(String date){
        String[] dateSplitted = date.split("/");
        return Integer.parseInt(dateSplitted[0]);
    }
}
