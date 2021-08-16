package com.example.CellPhoneUsage.services;

import com.example.CellPhoneUsage.models.CellPhone;
import com.example.CellPhoneUsage.models.CellPhoneUsageByMonth;

import java.util.List;

public interface IUtilService {
    List<CellPhone> getCellPhones();
    List<CellPhoneUsageByMonth> getCellPhoneUsageByMonth();
}
