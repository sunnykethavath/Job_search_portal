package com.example.JobSearchPortal.controller;


import com.example.JobSearchPortal.model.JobSearchPortal;
import com.example.JobSearchPortal.model.JobType;
import com.example.JobSearchPortal.services.JobServiceByCustomFinders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/custom")
public class JobControllerByCustomFinders {
    @Autowired
    JobServiceByCustomFinders jobService;

    @GetMapping(value = "/jobs/jobType")
    public List<JobSearchPortal> getByJobType(@RequestParam JobType jobType) {
        return jobService.getByJobType(jobType);
    }
    @GetMapping(value = "/jobs/title/location")
    public List<JobSearchPortal> getByTitleAndLocation(@RequestParam String title,@RequestParam String location ) {
        return jobService.getByTitleAndLocation(title, location);
    }

    @GetMapping(value = "/jobs/salary")
    public List<JobSearchPortal> getBySalary(@RequestParam String salary) {
        return jobService.getBySalary(salary);
    }

    @GetMapping(value = "/jobs/description/location")
    public List<JobSearchPortal> getByDescOrLocation(@RequestParam String description, @RequestParam String location) {
        return jobService.getByDescOrLocation(description,location);
    }
}
