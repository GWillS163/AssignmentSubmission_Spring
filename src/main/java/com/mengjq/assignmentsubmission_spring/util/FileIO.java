package com.mengjq.assignmentsubmission_spring.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class FileIO {

    public static void saveFile(MultipartFile fileData, String saveName ) throws IOException {

//        System.out.println(fileData.getOriginalFilename());
        System.out.println(fileData.getContentType());
        System.out.println(fileData.getSize());
        System.out.println(fileData.getName());

        String path = System.getProperty("user.dir") + "/upload/";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String savePath = path + saveName;
        System.out.println("saving file to " + savePath);
        File file = new File(savePath);
        fileData.transferTo(file);
    }

//    填充输出流
    public static InputStreamResource readFile(File file) throws IOException {
        System.out.println("reading file from :" + file.getAbsolutePath());
        InputStream inputStream = new FileInputStream(file);
        return new InputStreamResource(inputStream);
    }


    public static void deleteFile(String filePath)  {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
    
public static String calculateHash(MultipartFile file) throws IOException {
    MessageDigest digest;
    try {
        digest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        System.out.println("No such algorithm, Hash failed");
        return null;
    } 

    InputStream inputStream = file.getInputStream();
    byte[] buffer = new byte[1024];
    int read = 0;
    while ((read = inputStream.read(buffer)) != -1) {
        digest.update(buffer, 0, read);
    }
    byte[] hash = digest.digest();
    StringBuilder hexString = new StringBuilder();
    for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if (hex.length() == 1) hexString.append('0');
        hexString.append(hex);
    }
    return hexString.toString();
}


}
