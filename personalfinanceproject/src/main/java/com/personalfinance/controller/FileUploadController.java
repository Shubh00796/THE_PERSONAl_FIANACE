package com.personalfinance.controller;
import java.io.IOException;
import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.personalfinance.service.FileUploadService;




@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("Received file upload request: " + file.getOriginalFilename());

        if (file.isEmpty()) {
            System.out.println("File is empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        if (file.getSize() > 10 * 1024 * 1024) {
            System.out.println("File is too large: size = " + file.getSize());
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File is too large");
        }

        try {
            String filePath = fileUploadService.uploadFile(file);
            System.out.println("File uploaded successfully: " + filePath);
            return ResponseEntity.ok("File uploaded successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to upload file: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }
    
  
}
