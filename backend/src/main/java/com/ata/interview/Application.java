package com.ata.interview;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ata.interview.backend.util.FileUtil;
import com.ata.interview.backend.util.JsonUtil;
import com.ata.interview.domain.Employee;
import com.ata.interview.domain.EmployeeRepository;


@SpringBootApplication
public class Application implements CommandLineRunner  {
	
	
	Logger logger = LoggerFactory.getLogger(Application.class);
	
	private EmployeeRepository empRepo;
	
	public Application(EmployeeRepository empRepo) {
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
			Employee[] employees = JsonUtil.getObjectMapper().readValue(fileContents, Employee[].class);
			for (Employee emp: employees) {
				empRepo.save(emp);
			}
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}

}
