package com.example.JobSearchPortal.services;

import com.example.JobSearchPortal.model.JobSearchPortal;
import com.example.JobSearchPortal.repo.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServices {
    @Autowired
    IJobRepo jobRepo;

    public String addJobs(List<JobSearchPortal> jobs) {
        Iterable<JobSearchPortal> listOfJobs = jobRepo.saveAll(jobs);
        if ( listOfJobs != null ) {
            return "Jobs added successfully";
        }
        else {
            return "Job not added";
        }
    }

    public Iterable<JobSearchPortal> getAllJobs() {
        return jobRepo.findAll();
    }

    public String deleteByJobId(String jobId) {
        long job_id = Long.parseLong(jobId);

        Optional<JobSearchPortal> list = jobRepo.findById(job_id);

        if ( !(list.isEmpty())) {
            jobRepo.deleteById(job_id);
            return "Job with jobId " + jobId + " deleted successfully";
        }
        else {
            return "Job with jobId " + jobId + " cannot be found";
        }
    }

    public String updateJobByJobId(JobSearchPortal job, String jobId) {
        long job_id = Long.parseLong(jobId);

        Optional<JobSearchPortal> list = jobRepo.findById(job_id);
        if ( !(list.isEmpty())) {
            job.setId(job_id);
            jobRepo.save(job);
            return "Job with jobId " + jobId + " updated successfully";
        }
        else {
            return "Job with jobId " + jobId + " cannot be found";
        }
    }
}
