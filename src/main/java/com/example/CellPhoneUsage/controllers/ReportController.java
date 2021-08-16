package com.example.CellPhoneUsage.controllers;

import com.example.CellPhoneUsage.models.CellPhone;
import com.example.CellPhoneUsage.models.CellPhoneUsageByMonth;
import com.example.CellPhoneUsage.models.Detail;
import com.example.CellPhoneUsage.services.IReportOperationsService;
import com.example.CellPhoneUsage.services.IUtilService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ReportController {
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Autowired
    private IReportOperationsService reportOperationsService;

    @Autowired
    private IUtilService utilService;

    @GetMapping(value="/usage")
    public @ResponseBody
    ResponseEntity<String> main() throws Exception {

        Map<String, Object> reportData = new HashMap<>();

        // get the data from CSV files
        List<CellPhone> cellPhones = utilService.getCellPhones();
        List<CellPhoneUsageByMonth> cellPhoneUsageByMonthList = utilService.getCellPhoneUsageByMonth();
        List<Detail> detailList =reportOperationsService.getDetail(cellPhones,cellPhoneUsageByMonthList);

        reportData.put("runDate",reportOperationsService.getReportRunDate());
        reportData.put("numberOfPhones",cellPhones.size());
        reportData.put("totalMinutes",reportOperationsService.getTotalMinutes(cellPhoneUsageByMonthList));
        reportData.put("totalData",reportOperationsService.getTotalData(cellPhoneUsageByMonthList));
        reportData.put("averageMinutes",reportOperationsService.getAverageMinutes(cellPhoneUsageByMonthList));
        reportData.put("averageData",reportOperationsService.getAverageData(cellPhoneUsageByMonthList));
        reportData.put("details",detailList);

        Writer out = new StringWriter();
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("report.ftl");
        template.process(reportData,out);

        return  ResponseEntity.ok(out.toString());
    }

}
