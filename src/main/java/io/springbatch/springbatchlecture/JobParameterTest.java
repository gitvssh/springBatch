package io.springbatch.springbatchlecture;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Date;

//@Component
//@RequiredArgsConstructor
public class JobParameterTest implements ApplicationRunner {

    private final JobLauncher jobLauncher = null;
    private final Job job = null;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1")
                .addLong("seq", 2L)
                .addDate("date", new Date())
                .addDouble("age", 16.5)
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}
