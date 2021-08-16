package com.example.CellPhoneUsage.services;

import com.example.CellPhoneUsage.models.CellPhone;
import com.example.CellPhoneUsage.models.CellPhoneUsageByMonth;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service(value="utilService")
public class UtilServiceIMPL implements IUtilService{

    @Override
    public List<CellPhone> getCellPhones() {
        List<CellPhone> cellPhoneList = new ArrayList<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/WCF-Insurance/java-developer-cell-phone-usage/master/CellPhone.csv");
            InputStream inputStream = url.openStream();
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            CsvToBean<CellPhone> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CellPhone.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            cellPhoneList = csvToBean.parse();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cellPhoneList;
    }

    @Override
    public List<CellPhoneUsageByMonth> getCellPhoneUsageByMonth() {
        List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList = new ArrayList<>();
        try {
            URL url = new URL("https://raw.githubusercontent.com/WCF-Insurance/java-developer-cell-phone-usage/master/CellPhoneUsageByMonth.csv");
            InputStream inputStream = url.openStream();
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            CsvToBean<CellPhoneUsageByMonth> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CellPhoneUsageByMonth.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            cellPhoneUsageByMonthList = csvToBean.parse();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cellPhoneUsageByMonthList;
    }
}
