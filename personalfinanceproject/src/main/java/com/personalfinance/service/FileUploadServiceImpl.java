package com.personalfinance.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null) {
            throw new IOException("File name is null");
        }

        System.out.println("Uploading file: " + originalFileName);

        // Create the upload directory if it doesn't exist
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            boolean dirsCreated = directory.mkdirs();
            if (!dirsCreated) {
                System.out.println("Failed to create upload directory at " + directory.getAbsolutePath());
                throw new IOException("Failed to create upload directory");
            }
        }

        System.out.println("Uploading file part 2: " + originalFileName);

        // Sanitize file name to remove special characters
        String sanitizedFileName = originalFileName.replaceAll("[^a-zA-Z0-9.-]", "_");
        File serverFile = new File(directory, sanitizedFileName);

        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            System.out.println("Error transferring file: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw the exception to be handled in the controller
        }

        System.out.println("Uploading file part 3: " + sanitizedFileName);

        return serverFile.getAbsolutePath();
    }

    	
}
