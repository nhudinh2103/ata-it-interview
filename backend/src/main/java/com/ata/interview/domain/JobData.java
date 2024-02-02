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
	
	public static final String[] FIELDS  = new String[] { "timestamp", "employer", "location", "job_title", "years_at_employer",
			"years_of_experience", "salary", "signing_bonus", "annual_bonus", "annual_stock_bonus", "gender",
			"additional_comments" };
	
	public  Map.Entry<String, Object> getEntryMapFiltered(String field) {
		
		Map.Entry<String, Object> entry = null;
		
		if ("timestamp".equalsIgnoreCase(field)) {
			entry = Map.entry("Timestamp", timestamp);
		} else if ("Employer".equalsIgnoreCase(field)) {
			entry = Map.entry("Employer", employer);
		} else if ("Location".equalsIgnoreCase(field)) {
			entry = Map.entry("Location", location);
		} else if ("job_title".equalsIgnoreCase(field)) {
			entry = Map.entry("Job Title", jobTitle);
		} else if ("years_at_employer".equalsIgnoreCase(field)) {
			entry = Map.entry("Year at Employer", yearsAtEmployer);
		} else if ("years_of_experience".equalsIgnoreCase(field)) {
			entry = Map.entry("Year of Experience", yearsOfExperience);
		} else if ("salary".equalsIgnoreCase(field)) {
			entry = Map.entry("Salary", salary);
		} else if ("signing_bonus".equalsIgnoreCase(field)) {
			entry = Map.entry("Signing Bonus", signingBonus);
		} else if ("annual_bonus".equalsIgnoreCase(field)) {
			entry = Map.entry("Annual Bonus", annualBonus);
		} else if ("annual_stock_Bonus".equalsIgnoreCase(field)) {
			entry = Map.entry("Annual Stock Value/Bonus", annualStockBonus);
		} else if ("gender".equalsIgnoreCase(field)) {
			entry = Map.entry("Gender", gender);
		} else if ("additional_comments".equalsIgnoreCase(field)) {
			entry = Map.entry("Additional Comments", additionalComments);
		}
		
		return entry;
		
	}
	
	
}
