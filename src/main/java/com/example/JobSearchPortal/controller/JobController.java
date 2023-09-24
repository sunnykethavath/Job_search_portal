package com.example.JobSearchPortal.controller;

import com.example.JobSearchPortal.services.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    @Autowired
    JobServices jobServices;
}
