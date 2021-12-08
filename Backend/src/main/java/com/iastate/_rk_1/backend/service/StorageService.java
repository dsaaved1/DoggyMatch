package com.iastate._rk_1.backend.service;

import jdk.internal.loader.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @author peyton
 */
@Service
public class StorageService {

    /*
    public void store(MultipartFile file) {
        try {
            String fileLocation = new File("src/main/resources/static").getAbsolutePath() + "/" + file.getOriginalFilename();
            FileOutputStream output = new FileOutputStream(fileLocation);
            output.write(file.getBytes());
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     */


}
