package com.example.JobSearchPortal.services;

import com.example.JobSearchPortal.model.JobSearchPortal;
import com.example.JobSearchPortal.model.JobType;
import com.example.JobSearchPortal.repo.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceByCustomQuery {
    @Autowired
    IJobRepo jobRepo;

    @Transactional
    public String deleteByCompanyName(String companyName) {
        List<JobSearchPortal> list = jobRepo.findByCompanyName(companyName);
        if ( list != null ) {
            jobRepo.deleteByCompanyName(companyName);
            return "Jobs with company name " + companyName + " deleted successfully";
        }
        else {
            return "Jobs with company name " + companyName + " Cannot be found";
        }
    }

    @Transactional
    public String updateSalaryBasedOnId(String jobId , String jobSalary ){
        Long job_Id = Long.parseLong(jobId);

        Double job_Salary = Double.parseDouble(jobSalary);

        Optional<JobSearchPortal> list = jobRepo.findById(job_Id);

        if(!(list.isEmpty())){
            jobRepo.updateSalaryBasedOnId(job_Id , job_Salary);
            return "Job with job_Id "+jobId + " updated successfully";
        }else{
            return "Job with job_Id "+jobId + " not found";
        }
    }




    public List<JobSearchPortal> getJobByType(JobType jobType) {
        String job_type = jobType.toString();
        return jobRepo.getJobsByType(job_type);
    }

    public List<JobSearchPortal> getJobsBySalary(String salary) {
        Double JobSalary = Double.parseDouble(salary);
        return jobRepo.getBySalary(JobSalary);
    }
}
