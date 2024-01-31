package com.ata.interview.persistence.dao;

import org.springframework.data.jpa.domain.Specification;

import com.ata.interview.backend.util.SpecSearchCriteria;
import com.ata.interview.domain.JobData;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class JobDataSpecification implements Specification<JobData> {

	private static final long serialVersionUID = -790040997781645804L;

	private SpecSearchCriteria criteria;

	public JobDataSpecification(SpecSearchCriteria criteria) {
		this.criteria = criteria;
	}

	public SpecSearchCriteria getCriteria() {
		return criteria;
	}

	@Override
	public Predicate toPredicate(final Root<JobData> root, final CriteriaQuery<?> query,
			final CriteriaBuilder builder) {
		
		switch (criteria.getOperation()) {
			case EQUALITY:
				return builder.equal(root.get(criteria.getKey()), criteria.getValue());
			case NEGATION:
				return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
			case GREATER_THAN:
				return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
			case GREATER_THAN_OR_EUQAL_TO:
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
			case LESS_THAN:
				return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
			case LESS_THAN_OR_EQUAL_TO:
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString());
			case LIKE:
				return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
			case STARTS_WITH:
				return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
			case ENDS_WITH:
				return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
			case CONTAINS:
				return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
			default:
				return null;
		}
	}

}
