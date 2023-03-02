package com.mengjq.assignmentsubmission_spring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Objects;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);

        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());
        System.out.println(photo.getSize());
        System.out.println(photo.getName());
        System.out.println(System.getProperty("user.dir"));;

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);

        return "upload success";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String savePath = path + photo.getOriginalFilename();
        System.out.println("saving file to " + savePath);
        File file = new File(savePath);
        photo.transferTo(file);
    }
}
