package com.personalfinance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadFormController {

    @GetMapping("/")
    public String listUploadedFiles() {
        return "upload";
    }
}
