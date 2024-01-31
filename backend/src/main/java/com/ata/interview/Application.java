package com.ata.interview;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ata.interview.backend.util.FileUtil;
import com.ata.interview.backend.util.JsonUtil;
import com.ata.interview.domain.JobData;
import com.ata.interview.domain.JobDataRepository;


@SpringBootApplication
public class Application implements CommandLineRunner  {
	
	
	Logger logger = LoggerFactory.getLogger(Application.class);
	
	private final JobDataRepository empRepo;
	
	public Application(JobDataRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	private static final String SALARY_SURVEY_FILE_NAME_JSON = "salary_survey-3.json";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initData();
	}
	
	private void initData() throws IOException {
		
		String fileContents = "";
		
		try {
			fileContents = FileUtil.readResource(SALARY_SURVEY_FILE_NAME_JSON);
			JobData[] jobDatas = JsonUtil.getObjectMapper().readValue(fileContents, JobData[].class);
			for (JobData jd: jobDatas) {
				normalizeData(jd);
				empRepo.save(jd);
			}
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void normalizeData(JobData jd) {
		
		String salaryStr = jd.getSalaryStr();
		if (salaryStr != null) {
			// salary can contains currency, as well as per hour
			// We ignore it for simplicity filter with number later			
			salaryStr = salaryStr.replaceAll("[^0-9]", "");
			
			// remove white space un
			salaryStr = salaryStr.replaceAll("\\s+", "");
			jd.setSalaryStr(salaryStr);
		}
		
		Long salary = null;
		try {
			salary = Long.parseLong(salaryStr);
		} catch (Exception ex) {}
		jd.setSalary(salary);
		
	}

}
