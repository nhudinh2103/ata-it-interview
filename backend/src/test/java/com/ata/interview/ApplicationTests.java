package com.ata.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import com.ata.interview.backend.util.SearchOperation;
import com.ata.interview.backend.util.SpecSearchCriteria;
import com.ata.interview.domain.JobData;
import com.ata.interview.domain.JobDataRepository;
import com.ata.interview.persistence.dao.JobDataSpecification;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private JobDataRepository repo;
	
	private JobData jobData1;
	
	private JobData jobData2;
	
	@BeforeEach
	public void init() {
		
		jobData1 = new JobData();
		jobData1.setTimestamp("3/23/2016 6:07:06");
		jobData1.setEmployer("과장");
		jobData1.setLocation("넥센");
		jobData1.setJobTitle("꼰대");
		jobData1.setYearsAtEmployer("18");
		jobData1.setYearsOfExperience("18");
		jobData1.setSalaryStr("9999999999");
		jobData1.setSalary(9999999999l);
		jobData1.setSigningBonus("8999999");
		jobData1.setAnnualBonus("99999");
		jobData1.setAnnualStockBonus("99999");
		jobData1.setGender("Female");
		jobData1.setAdditionalComments("");
		
		jobData2 = new JobData();
		jobData2.setTimestamp("3/21/2016 13:41:50");
		jobData2.setEmployer("Reddit");
		jobData2.setLocation("");
		jobData2.setJobTitle("Troll");
		jobData2.setYearsAtEmployer("5");
		jobData2.setYearsOfExperience("45");
		jobData2.setSalaryStr("10000000000000300");
		jobData2.setSalary(10000000000000300l);
		jobData2.setSigningBonus("");
		jobData2.setAnnualBonus("");
		jobData2.setAnnualStockBonus("[another large number]");
		jobData2.setGender("Male");
		jobData2.setAdditionalComments("[incoherent snarky digression]");
		
	}

	@Test
	void givenSalaryAndGenderCriteria_whenSearch_thenReturnOneJobData1() {
		
		JobDataSpecification spec1 = new JobDataSpecification(
				new SpecSearchCriteria("salary", SearchOperation.GREATER_THAN_OR_EUQAL_TO, 9999999999l));
		
		JobDataSpecification spec2 = new JobDataSpecification(
				new SpecSearchCriteria("gender", SearchOperation.EQUALITY, "Female"));
		
		List<JobData> results = repo.findAll(Specification.where(spec1).and(spec2));
		
		assertEquals(results.size(), 1);
		assertEquals(jobData1.getTimestamp(), results.get(0).getTimestamp());
		assertEquals(jobData1.getEmployer(), results.get(0).getEmployer());
		assertEquals(jobData1.getLocation(), results.get(0).getLocation());
		assertEquals(jobData1.getJobTitle(), results.get(0).getJobTitle());
		assertEquals(jobData1.getYearsOfExperience(), results.get(0).getYearsOfExperience());
		assertEquals(jobData1.getYearsAtEmployer(), results.get(0).getYearsAtEmployer());
		assertEquals(jobData1.getSalaryStr(), results.get(0).getSalaryStr());
		assertEquals(jobData1.getSalary(), results.get(0).getSalary());
		assertEquals(jobData1.getSigningBonus(), results.get(0).getSigningBonus());
		assertEquals(jobData1.getAnnualBonus(), results.get(0).getAnnualBonus());
		assertEquals(jobData1.getAnnualStockBonus(), results.get(0).getAnnualStockBonus());
		assertEquals(jobData1.getGender(), results.get(0).getGender());
		assertEquals(jobData1.getAdditionalComments(), results.get(0).getAdditionalComments());
		
//		assertThat(jobData1, is(in(results)));;
		
	}
	
	@Test
	void givenSalaryAndGenderCriteria_whenSearch_thenReturnOneJobData2() {
		
		JobDataSpecification spec1 = new JobDataSpecification(
				new SpecSearchCriteria("salary", SearchOperation.GREATER_THAN_OR_EUQAL_TO, 10000000000000000l));
		
		JobDataSpecification spec2 = new JobDataSpecification(
				new SpecSearchCriteria("gender", SearchOperation.EQUALITY, "Male"));
		
		List<JobData> results = repo.findAll(Specification.where(spec1).and(spec2));
		
		assertEquals(results.size(), 1);
		assertEquals(jobData2.getTimestamp(), results.get(0).getTimestamp());
		assertEquals(jobData2.getEmployer(), results.get(0).getEmployer());
		assertEquals(jobData2.getLocation(), results.get(0).getLocation());
		assertEquals(jobData2.getJobTitle(), results.get(0).getJobTitle());
		assertEquals(jobData2.getYearsOfExperience(), results.get(0).getYearsOfExperience());
		assertEquals(jobData2.getYearsAtEmployer(), results.get(0).getYearsAtEmployer());
		assertEquals(jobData2.getSalaryStr(), results.get(0).getSalaryStr());
		assertEquals(jobData2.getSalary(), results.get(0).getSalary());
		assertEquals(jobData2.getSigningBonus(), results.get(0).getSigningBonus());
		assertEquals(jobData2.getAnnualBonus(), results.get(0).getAnnualBonus());
		assertEquals(jobData2.getAnnualStockBonus(), results.get(0).getAnnualStockBonus());
		assertEquals(jobData2.getGender(), results.get(0).getGender());
		assertEquals(jobData2.getAdditionalComments(), results.get(0).getAdditionalComments());
		
//		assertThat(jobData1, is(in(results)));;
		
	}

}
