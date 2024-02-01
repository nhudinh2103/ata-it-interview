package com.ata.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ata.interview.constants.Constants;
import com.ata.interview.domain.JobDataRepository;


@SpringBootApplication
public class Application implements CommandLineRunner  {
	
	
	Logger logger = LoggerFactory.getLogger(Application.class);
	
	private final JobDataRepository repo;
	
	public Application(JobDataRepository repo) {
		this.repo = repo;
	}
	
	@Autowired
	private DummyData dummyData;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dummyData.init(repo, Constants.SALARY_SURVEY_FILE_NAME_JSON);
	}

}
