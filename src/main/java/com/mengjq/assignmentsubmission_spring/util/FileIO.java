package com.mengjq.assignmentsubmission_spring.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileIO {

    public static void saveFile(MultipartFile fileData ) throws IOException {

        System.out.println(fileData.getOriginalFilename());
        System.out.println(fileData.getContentType());
        System.out.println(fileData.getSize());
        System.out.println(fileData.getName());

        String path = System.getProperty("user.dir") + "/upload/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String savePath = path + fileData.getOriginalFilename();
        System.out.println("saving file to " + savePath);
        File file = new File(savePath);
        fileData.transferTo(file);
    }

//    填充输出流
    public static InputStreamResource readFile(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        return new InputStreamResource(inputStream);
    }
    
    
}
