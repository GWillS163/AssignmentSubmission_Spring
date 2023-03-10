package com.mengjq.assignmentsubmission_spring.controller;
import com.opencsv.CSVWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CsvController {


    @GetMapping("/downloadCsv")
    public void downloadCsv(HttpServletResponse response) throws IOException {
        // 准备数据
        List<String[]> data = prepareData();

        // 创建CSV文件并写入数据
        Path path = Paths.get("data.csv");
        try (Writer writer = new OutputStreamWriter(Files.newOutputStream(path))) {
            CSVWriter csvWriter = new CSVWriter(writer);
            csvWriter.writeAll(data);
        }

        // 设置响应头
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"data.csv\"");

        // 将CSV文件写入输出流
        Files.copy(path, response.getOutputStream());
    }

    private List<String[]> prepareData() {
        // return some data
        List<String[]> list = new  ArrayList<String[]>();
        list.add(new String[]{"1", "John Doe", "25"});
        list.add(new String[]{"2", "Jane Smith", "30"});
        list.add(new String[]{"3", "Bob Johnson", "45"});
        return list;
        
    }
}
