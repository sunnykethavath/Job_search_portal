package com.example.JobSearchPortal.repo;

import com.example.JobSearchPortal.model.JobSearchPortal;
import com.example.JobSearchPortal.model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IJobRepo extends CrudRepository<JobSearchPortal, Long> {
    public List<JobSearchPortal> findByJobType(JobType jobType);

    public List<JobSearchPortal> findByTitleAndLocation(String title, String location);

    public List<JobSearchPortal> findBySalaryGreaterThan(Double salary);

    public List<JobSearchPortal> findByDescriptionOrLocation(String description, String location);

    @Modifying
    @Query(value = "Delete from Jobs where company_name = :companyName " , nativeQuery = true)
    public void deleteByCompanyName(String companyName);


    @Modifying
    @Query(value = "update Jobs set salary = :jobSalary where id = :job_Id" , nativeQuery = true)
    public void updateSalaryBasedOnId(Long job_Id , Double jobSalary);

    public List<JobSearchPortal> findByCompanyName(String companyName);


    @Query(value = "select * from Jobs where job_type = :jobType", nativeQuery = true)
    public List<JobSearchPortal> getJobsByType(String jobType);

    @Query(value = "select * from Jobs where salary > :expSalary", nativeQuery = true)
    public List<JobSearchPortal> getBySalary(Double expSalary);

}
