package com.ata.interview;

import java.io.IOException;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ata.interview.backend.util.FileUtil;
import com.ata.interview.backend.util.JsonUtil;
import com.ata.interview.persistence.model.JobData;

@Component
public class DummyData {
	
	/**
	 * Init dummy data 
	 * @param repo
	 * @param fileName
	 * @throws IOException
	 */
	public void init(CrudRepository<JobData, Long> repo, String fileName) throws IOException {
		
		String fileContents = "";
		
		try {
			fileContents = FileUtil.readResource(fileName);
			JobData[] jobDatas = JsonUtil.getObjectMapper().readValue(fileContents, JobData[].class);
			for (JobData jd: jobDatas) {
				normalizeData(jd);
				repo.save(jd);
			}
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param jd
	 */
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
