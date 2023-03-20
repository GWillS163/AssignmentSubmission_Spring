package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.util.FileIO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Objects;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);

//        System.out.println(System.getProperty("user.dir"));;
        String path = System.getProperty("user.dir") + "/upload/";
//        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println("path: " + path);


        FileIO.saveFile(photo, photo.getOriginalFilename());

        return "upload success";
    }

    @GetMapping("/download")
    public void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String path = request.getServletContext().getRealPath("/upload/");
        String fileName = "cube.jpg";
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        System.out.println("downloading file " + fileName);
        System.out.println("outputStream: " + outputStream);

        String path = System.getProperty("user.dir") + "/upload/";
        File file = new File(path + fileName);
        FileIO.readFile(file);


    }

}
