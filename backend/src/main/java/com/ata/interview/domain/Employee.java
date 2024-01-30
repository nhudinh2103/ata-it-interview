package com.ata.interview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
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
	
	@JsonProperty("Years At Employer")
	private String yearsAtEmployer;
	
	@JsonProperty("Years of Exeperience")
	private String yearOfExperience;
	
	@JsonProperty("Salary")
	private String salary;
	
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
				+ ", salary=" + salary + ", signingBonus=" + signingBonus + ", annualBonus=" + annualBonus
				+ ", annualStockBonus=" + annualStockBonus + ", gender=" + gender + ", male=" + additionalComments + "]";
	}
	
	
	
}
