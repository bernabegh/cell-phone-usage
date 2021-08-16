package com.example.CellPhoneUsage.services;

import com.example.CellPhoneUsage.models.CellPhoneUsageByMonth;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

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
}
