package com.personalfinance.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;



public interface FileUploadService {
    String uploadFile(MultipartFile file) throws IOException;

}
