package com.ata.interview.domain;

import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobData {
	
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
	private String yearsOfExperience;
	
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

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
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

	@Override
	public int hashCode() {
		return Objects.hash(additionalComments, annualBonus, annualStockBonus, employer, gender, id, jobTitle, location,
				salary, salaryStr, signingBonus, timestamp, yearsOfExperience, yearsAtEmployer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobData other = (JobData) obj;
		return Objects.equals(additionalComments, other.additionalComments)
				&& Objects.equals(annualBonus, other.annualBonus)
				&& Objects.equals(annualStockBonus, other.annualStockBonus) && Objects.equals(employer, other.employer)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(jobTitle, other.jobTitle) && Objects.equals(location, other.location)
				&& Objects.equals(salary, other.salary) && Objects.equals(salaryStr, other.salaryStr)
				&& Objects.equals(signingBonus, other.signingBonus) && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(yearsOfExperience, other.yearsOfExperience)
				&& Objects.equals(yearsAtEmployer, other.yearsAtEmployer);
	}
	
	@Override
	public String toString() {
		return "Employee [timestamp=" + timestamp + ", employer=" + employer + ", location=" + location + ", jobTitle="
				+ jobTitle + ", yearsAtEmployer=" + yearsAtEmployer + ", yearOfExperience=" + yearsOfExperience
				+ ", salaryStr=" + salaryStr + ", salary=" + salary + ", signingBonus=" + signingBonus + ", annualBonus=" + annualBonus
				+ ", annualStockBonus=" + annualStockBonus + ", gender=" + gender + ", male=" + additionalComments + "]";
	}
	
	public static final String[] FIELDS  = new String[] { "timestamp", "employer", "location", "jobTitle", "yearsAtEmployer",
			"yearsOfExperience", "salary", "signingBonus", "annualBonus", "annualStockBonus", "gender",
			"additionalComments" };
	
	public  Map.Entry<String, Object> getEntryMapFiltered(String field) {
		
		Map.Entry<String, Object> entry = null;
		
		if ("timestamp".equalsIgnoreCase(field)) {
			entry = Map.entry("timestamp", timestamp);
		} else if ("employer".equalsIgnoreCase(field)) {
			entry = Map.entry("employer", employer);
		} else if ("location".equalsIgnoreCase(field)) {
			entry = Map.entry("location", location);
		} else if ("jobTitle".equalsIgnoreCase(field)) {
			entry = Map.entry("jobTitle", jobTitle);
		} else if ("yearsAtEmployer".equalsIgnoreCase(field)) {
			entry = Map.entry("yearsAtEmployer", yearsAtEmployer);
		} else if ("yearsOfExperience".equalsIgnoreCase(field)) {
			entry = Map.entry("yearsOfExperience", yearsOfExperience);
		} else if ("salary".equalsIgnoreCase(field)) {
			entry = Map.entry("salary", salary);
		} else if ("signingBonus".equalsIgnoreCase(field)) {
			entry = Map.entry("signingBonus", signingBonus);
		} else if ("annualBonus".equalsIgnoreCase(field)) {
			entry = Map.entry("annualBonus", annualBonus);
		} else if ("annualStockBonus".equalsIgnoreCase(field)) {
			entry = Map.entry("annualStockBonus", annualStockBonus);
		} else if ("gender".equalsIgnoreCase(field)) {
			entry = Map.entry("gender", gender);
		} else if ("additionalComments".equalsIgnoreCase(field)) {
			entry = Map.entry("additionalComments", additionalComments);
		}
		
		return entry;
		
	}
	
	
}
