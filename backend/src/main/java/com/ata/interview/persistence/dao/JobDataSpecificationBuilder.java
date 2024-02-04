package com.ata.interview.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ata.interview.backend.util.SearchOperation;
import com.ata.interview.backend.util.SpecSearchCriteria;
import com.ata.interview.persistence.model.JobData;

/**
 * 
 * @author dinhnn
 *
 */
public class JobDataSpecificationBuilder {

	private List<SpecSearchCriteria> params;

	public JobDataSpecificationBuilder() {
		params = new ArrayList<>();
	}

	public JobDataSpecificationBuilder with(final String key, final String operation, final Object value,
			final String prefix, final String suffix) {
		return with(null, key, operation, value, prefix, suffix);
	}
	
	/**
	 * 
	 * @param orPredicate
	 * @param key
	 * @param operation
	 * @param value
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public JobDataSpecificationBuilder with(final String orPredicate, final String key, final String operation,
			Object value, final String prefix, final String suffix) {
		SearchOperation op = SearchOperation.getSimpleOperation(operation);
		if (op != null) {
			if (op == SearchOperation.EQUALITY) {
				final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
				final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

				if (startWithAsterisk && endWithAsterisk) {
					op = SearchOperation.CONTAINS;
				} else if (startWithAsterisk) {
					op = SearchOperation.STARTS_WITH;
				} else if (endWithAsterisk) {
					op = SearchOperation.ENDS_WITH;
				}
			}
			
			params.add(new SpecSearchCriteria(orPredicate, key, op, value));
		}

		return this;
	}
	
	public Specification<JobData> build() {
		if (params.size() == 0)
			return null;

		Specification<JobData> result = new JobDataSpecification(params.get(0));

		for (int i = 1; i < params.size(); i++) {
			result = params.get(i).isOrPredicate()
					? Specification.where(result).or(new JobDataSpecification(params.get(i)))
					: Specification.where(result).and(new JobDataSpecification(params.get(i)));
		}

		return result;
	}
	
	public JobDataSpecificationBuilder with (JobDataSpecification spec) {
		params.add(spec.getCriteria());
		return this;
	}
	
	public JobDataSpecificationBuilder with (SpecSearchCriteria criteria) {
		params.add(criteria);
		return this;
	}

}
