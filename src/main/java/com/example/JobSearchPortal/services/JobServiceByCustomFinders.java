package com.example.JobSearchPortal.services;

import com.example.JobSearchPortal.model.JobSearchPortal;
import com.example.JobSearchPortal.model.JobType;
import com.example.JobSearchPortal.repo.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceByCustomFinders {
    @Autowired
    IJobRepo jobRepo;

    public List<JobSearchPortal> getByJobType(JobType jobType) {
        return jobRepo.findByJobType(jobType);
    }

    public List<JobSearchPortal> getByTitleAndLocation(String title, String location) {
        return jobRepo.findByTitleAndLocation(title,location);
    }

    public List<JobSearchPortal> getBySalary(String salary) {
        double newSalary = Double.parseDouble(salary);
        return jobRepo.findBySalaryGreaterThan(newSalary);
    }

    public List<JobSearchPortal> getByDescOrLocation(String description, String location) {
        return jobRepo.findByDescriptionOrLocation(description, location);
    }
}
