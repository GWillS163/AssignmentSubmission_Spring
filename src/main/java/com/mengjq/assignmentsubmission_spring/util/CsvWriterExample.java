package com.mengjq.assignmentsubmission_spring.util;

import lombok.var;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvWriterExample {
    public static void main(String[] args) throws IOException {
        // 准备数据
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"1", "John Doe", "25"});
        data.add(new String[]{"2", "Jane Smith", "30"});
        data.add(new String[]{"3", "Bob Johnson", "45"});

        // 创建CSV文件并写入数据
        Path path = Paths.get("data.csv");
        try (var writer = Files.newBufferedWriter(path)) {
            for (String[] rowData : data) {
                writer.write(String.join(",", rowData));
                writer.newLine();
            }
        }
    }
}
