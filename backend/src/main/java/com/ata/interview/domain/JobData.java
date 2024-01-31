package com.ata.interview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobData {
	
//	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonProperty("Timestamp")
	private String timestamp;
	
	@JsonProperty("Employer")
	private String employer;
	
	@JsonProperty("Location")
	private String location;
	
	@JsonProperty("Job Title")
	private String jobTitle;
	
	@JsonProperty("Years at Employer")
	private String yearsAtEmployer;
	
	@JsonProperty("Years of Experience")
	private String yearOfExperience;
	
	@JsonProperty(value = "Salary", access = JsonProperty.Access.WRITE_ONLY)
	private String salaryStr;
	
	@JsonProperty(value = "Salary", access = JsonProperty.Access.READ_ONLY)
	private Long salary;
	
	@JsonProperty("Signing Bonus")
	private String signingBonus;
	
	@JsonProperty("Annual Bonus")
	private String annualBonus;
	
	@JsonProperty("Annual Stock Value/Bonus")
	private String annualStockBonus;
	
	@JsonProperty("Gender")
	private String gender;
	
	@JsonProperty("Additional Comments")
	@Column(length = 2048)
	private String additionalComments;

	@Override
	public String toString() {
		return "Employee [timestamp=" + timestamp + ", employer=" + employer + ", location=" + location + ", jobTitle="
				+ jobTitle + ", yearsAtEmployer=" + yearsAtEmployer + ", yearOfExperience=" + yearOfExperience
				+ ", salaryStr=" + salaryStr + ", salary=" + salary + ", signingBonus=" + signingBonus + ", annualBonus=" + annualBonus
				+ ", annualStockBonus=" + annualStockBonus + ", gender=" + gender + ", male=" + additionalComments + "]";
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getYearsAtEmployer() {
		return yearsAtEmployer;
	}

	public void setYearsAtEmployer(String yearsAtEmployer) {
		this.yearsAtEmployer = yearsAtEmployer;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getSalaryStr() {
		return salaryStr;
	}

	public void setSalaryStr(String salaryStr) {
		this.salaryStr = salaryStr;
	}
	
	public Long getSalary() {
		return salary;
	}
	
	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getSigningBonus() {
		return signingBonus;
	}

	public void setSigningBonus(String signingBonus) {
		this.signingBonus = signingBonus;
	}

	public String getAnnualBonus() {
		return annualBonus;
	}

	public void setAnnualBonus(String annualBonus) {
		this.annualBonus = annualBonus;
	}

	public String getAnnualStockBonus() {
		return annualStockBonus;
	}

	public void setAnnualStockBonus(String annualStockBonus) {
		this.annualStockBonus = annualStockBonus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
	
	
	
}
