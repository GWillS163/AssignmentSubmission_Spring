package com.mengjq.assignmentsubmission_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) {
        System.out.println(nickname);

        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());
        System.out.println(photo.getSize());
        System.out.println(photo.getName());
        System.out.println(System.getProperty("user.dir"));;

        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);

        return "upload success";
    }
}
