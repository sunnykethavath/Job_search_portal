package com.example.JobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jobs")
public class JobSearchPortal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotEmpty
    @Length(min = 4, max = 255, message = "Title length should be between 1 and 255")
    private String description;

    @NotEmpty
    private String location;

    @Min(value = 21000)
    @NotNull
    private Double salary;

    private String companyEmail;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "employer_name")
    private String employerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_type")
    private JobType jobType;

    @Column(name = "applied_date")
    private LocalDate applied_date;
}
