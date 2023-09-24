package com.example.JobSearchPortal.controller;

import com.example.JobSearchPortal.model.JobSearchPortal;
import com.example.JobSearchPortal.model.JobType;
import com.example.JobSearchPortal.services.JobServiceByCustomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobControllerByCustomQuery {
    @Autowired
    JobServiceByCustomQuery jobService;

    @DeleteMapping(value = "/job/{companyName}")
    public String deleteByCompanyName(@PathVariable String companyName) {
        return jobService.deleteByCompanyName(companyName);
    }

    @PutMapping(value = "jobs/{id}/{salary}")
    public String updateSalaryById(@PathVariable String id , @PathVariable String salary){
        return jobService.updateSalaryBasedOnId(id, salary);
    }

    @GetMapping(value = "/type/{jobType}")
    public List<JobSearchPortal> getJobByType(@PathVariable JobType jobType) {
        return jobService.getJobByType(jobType);
    }

    @GetMapping(value = "jobs/bySalary/{salary}")
    public List<JobSearchPortal> getJobsGreaterThan(@PathVariable String salary) {
        return jobService.getJobsBySalary(salary);
    }

}
