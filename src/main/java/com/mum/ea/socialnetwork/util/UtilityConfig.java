package com.mum.ea.socialnetwork.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UtilityConfig {

    public static String savingPic(MultipartFile file) {
        String filePath = "";
        String realPath = System.getProperty("user.dir");
        try {
            filePath = UUID.randomUUID()+ file.getOriginalFilename();
            realPath= realPath+"/pics/"+filePath;
//            Path path = Paths.get(realPath);
//            InputStream in = file.getInputStream();
//            Files.copy(in,path);
            file.transferTo(new File(realPath));
            return filePath;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
