package com.example.demo.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorage {

    private final Path fileStorageLocation;

    public FileStorage(){
        // this.fileStorageLocation = Paths.get("src\\main\\resources\\images")
        this.fileStorageLocation = Paths.get("../../CC2 Assignment/images/")
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        }
        catch(Exception ex){
            System.out.println("Could not create the directory where the uploaded files will be stored");
        }
    }


    public String storeFile(String id, MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(id + "." + FilenameUtils.getExtension(file.getOriginalFilename()));

        try{
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.write(targetLocation, file.getBytes());
            System.out.println("Image was uploaded");
            return fileName;
        }

        catch (IOException ioException){
            System.out.println("Could not store" + fileName + ". Please Try again!" );
            throw ioException;
        }
    }
}
