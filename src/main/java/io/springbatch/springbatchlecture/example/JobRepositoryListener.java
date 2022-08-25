package io.springbatch.springbatchlecture.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;

//@Component
//@RequiredArgsConstructor
@Slf4j
public class JobRepositoryListener implements JobExecutionListener {

    private final JobRepository jobRepository = null;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1").toJobParameters();

        JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
        if (lastJobExecution != null) {
            for (StepExecution execution : lastJobExecution.getStepExecutions()) {
                BatchStatus status = execution.getStatus();
                ExitStatus exitStatus = execution.getExitStatus();
                log.info("status :{}, exitStatus :{}", status, exitStatus);
                String stepName = execution.getStepName();
                log.info("stepName :{}", stepName);
            }
        }
    }
}
