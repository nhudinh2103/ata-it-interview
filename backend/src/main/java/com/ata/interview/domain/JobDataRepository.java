package com.ata.interview.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JobDataRepository extends CrudRepository<JobData, Long>, JpaSpecificationExecutor<JobData>, PagingAndSortingRepository<JobData, Long> {

}