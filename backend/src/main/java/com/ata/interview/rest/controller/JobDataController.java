package com.ata.interview.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ata.interview.backend.util.SearchOperation;
import com.ata.interview.domain.JobData;
import com.ata.interview.domain.JobDataRepository;
import com.ata.interview.persistence.dao.JobDataSpecificationBuilder;

@RestController
public class JobDataController {
	
	@Autowired
	private JobDataRepository repo;
	
	private static final String OPERATION_SET_EXPR = Arrays.stream(SearchOperation.SIMPLE_OPERATION_SET).collect(Collectors.joining("|"));
	
	private static final Pattern PATTERN = Pattern.compile("(\\w+)(" + OPERATION_SET_EXPR + ")([^\\w\\s]+)?(\\w+)([^\\w\\s]+)?");

	@GetMapping("/job_data")
	@ResponseBody
	public List<JobData> search(@RequestParam(value="search") String search) {
		
		JobDataSpecificationBuilder builder = new JobDataSpecificationBuilder();
		
		if (search != null) {
			Matcher matcher = PATTERN.matcher(search);
			while (matcher.find()) {
				
				String matchedStr = matcher.group();
				if (matchedStr.contains(">=")) {
					builder = builder.with(matcher.group(1), ">=", matcher.group(4), matcher.group(3), matcher.group(5));
				} else if (matchedStr.contains("<=")) {
					builder = builder.with(matcher.group(1), "<=", matcher.group(4), matcher.group(3), matcher.group(5));
				} else {
					builder = builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
				}
			}
		}
		
		Specification<JobData> spec = builder.build();
		return repo.findAll(spec);
	}
	
}
