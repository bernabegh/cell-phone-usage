package com.example.CellPhoneUsage.services;

import com.example.CellPhoneUsage.models.CellPhone;
import com.example.CellPhoneUsage.models.CellPhoneUsageByMonth;
import com.example.CellPhoneUsage.models.Detail;

import java.util.List;

public interface IReportOperationsService {

    // Header information
    String getReportRunDate();
    int getTotalMinutes(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList);
    double getTotalData(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList);
    double getAverageMinutes(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList);
    double getAverageData(List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList);

    //
    List<Detail> getDetail(List<CellPhone> cellPhones, List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList);
}
