package com.ata.interview.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ata.interview.backend.util.SearchOperation;
import com.ata.interview.constants.Constants;
import com.ata.interview.persistence.dao.JobDataRepository;
import com.ata.interview.persistence.dao.JobDataSpecificationBuilder;
import com.ata.interview.persistence.model.JobData;

/**
 * 
 * @author dinhnn
 *
 */
@RestController
public class JobDataController {
	
	@Autowired
	private JobDataRepository repo;
	
	private static final String OPERATION_SET_EXPR = Arrays.stream(SearchOperation.SIMPLE_OPERATION_SET).collect(Collectors.joining("|"));
	
	private static final Pattern PATTERN = Pattern.compile("(\\w+)(" + OPERATION_SET_EXPR + ")([^\\w\\s]+)?(\\w+)([^\\w\\s]+)?");
	
	/**
	 * GET method for get job_data with support for
	 *  - Filter by multiple conditions
	 *  - Select sparse fields / attributes
	 *  - Sorting (ascending, descending)
	 * @param searchOpt
	 * @param fieldsOpt
	 * @param sortOpt
	 * @return list of result job data
	 */
	@GetMapping("/job_data")
	@ResponseBody
	public List<Map<String, Object>> search(
			@RequestParam(value = "search") Optional<String> searchOpt,
			@RequestParam(value = "fields") Optional<String> fieldsOpt,
			@RequestParam(value = "sort") Optional<String> sortOpt) {
		
		String search = "";
		if (searchOpt.isPresent()) {
			search = searchOpt.get();
		}
		
		String[] fieldArr = JobData.FIELDS;
		if (fieldsOpt.isPresent()) {
			fieldArr = fieldsOpt.get().split(Constants.FIELD_SEPARATOR);
		}
		
		String sort = "";
		if (sortOpt.isPresent()) {
			sort = sortOpt.get();
		}
		
		JobDataSpecificationBuilder builder = new JobDataSpecificationBuilder();
		if (!search.isEmpty()) {
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
		
		List<JobData> searchResults = new ArrayList<>();
		
		List<Order> orders = getSortingOrders(sort);
		if (orders.isEmpty()) {
			searchResults = repo.findAll(spec);
		} else {
			searchResults = repo.findAll(spec, Sort.by(orders));
		}
		
		List<Map<String, Object>> result = generateFieldsResultFrom(searchResults, fieldArr);
		
		return result;
	}
	
	/**
	 * This method use to generate results sparse fields / attributes based on search, sort job data list
	 * @param jobDatas
	 * @param fieldArr
	 * @return list of entry with sparse fields / attributes
	 */
	private List<Map<String, Object>> generateFieldsResultFrom(List<JobData> jobDatas, String[] fieldArr) {
		
		List<Map<String, Object>> result = new ArrayList<>();
		
		for (JobData jd : jobDatas) {
			
			Map<String, Object> m = new HashMap<>();

			for (int i = 0; i < fieldArr.length; i++) {

				Map.Entry<String, Object> entry = jd.getEntryMapFiltered(fieldArr[i]);
				m.put(entry.getKey(), entry.getValue());

			}
			
			result.add(m);

		}

		return result;
	}
	
	/**
	 * Get sort order list based on string parse from url
	 * @param sortStr
	 * @return list of sort order
	 */
	private List<Order> getSortingOrders(String sortStr) {
		
		List<Order> rsList = new ArrayList<>();
		
		if (sortStr == null || sortStr.isBlank()) {
			return rsList;
		}
		
		// Example: salary,asc|annual_bonus,desc 
		// => split to array with 2 items: ["salary,asc", "annual bonus,desc"]		
		String[] sotrStrSplitted = sortStr.split(Constants.SORT_ITEM_SEPARATOR);
		
		for (String sortStrItem: sotrStrSplitted) {
			
			// salary,asc => split to [salary, asc]
			String[] sortStrItemSplitted = sortStrItem.split(Constants.SORT_ITEM_WITH_DIRECTION_SEPARATOR);
			
			String sortField = sortStrItemSplitted[0];
			String sortDirectionStr = sortStrItemSplitted[1];
			
			rsList.add(new Order(getSortDirection(sortDirectionStr), sortField));
			
		}
		
		return rsList;
		
	}
	
	/**
	 * Get sort direction enumeration based on string
	 * @param direction
	 * @return enum Sort.Direction
	 */
	private Sort.Direction getSortDirection(String direction) {
		if ("asc".equalsIgnoreCase(direction)) {
			return Sort.Direction.ASC;
		} else if ("desc".equalsIgnoreCase(direction)) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}
}
