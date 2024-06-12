package com.example.technomakers.springbatch.exercice;

import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.UUID;

@Configuration
@ImportResource("classpath:job.xml")
public class BatchConfig {

    private final JobLauncher jobLauncher;
    private final Job studentJob;
    private final Job carJob;
    private final JobExplorer jobExplorer;
    private final JobRepository jobRepository;

    public BatchConfig(JobLauncher jobLauncher, Job studentJob, Job carJob, JobExplorer jobExplorer, JobRepository jobRepository) {
        this.jobLauncher = jobLauncher;
        this.studentJob = studentJob;
        this.carJob = carJob;
        this.jobExplorer = jobExplorer;
        this.jobRepository = jobRepository;
    }

    public void runJob() throws Exception {
        String jobName = studentJob.getName();
        boolean isJobRunning = jobExplorer.findRunningJobExecutions(jobName).size() > 0;

        if (isJobRunning) {
            for (JobExecution jobExecution : jobExplorer.findRunningJobExecutions(jobName)) {
                jobExecution.setStatus(BatchStatus.STOPPING);
                jobRepository.update(jobExecution);
            }
        }

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("jobId", UUID.randomUUID().toString())
                .toJobParameters();
        jobLauncher.run(studentJob, jobParameters);
    }

}
