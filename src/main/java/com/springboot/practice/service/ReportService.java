package com.springboot.practice.service;

import com.springboot.practice.entity.User;
import com.springboot.practice.repository.UserRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    public UserRepository userRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path = "C:\\Github\\Jasper-Report-Learning\\src\\main\\resources\\reports\\users";

        List<User> users = userRepository.findAll();

        File file = ResourceUtils.getFile("classpath:users.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);

        Map<String,Object> parameters = new HashMap<>();

        parameters.put("Created By: ","Black Spider");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\users.pdf");
        }

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\users.html");
        }
        return "Report Generated Successfully. Find It Here : " + path;
    }
}
