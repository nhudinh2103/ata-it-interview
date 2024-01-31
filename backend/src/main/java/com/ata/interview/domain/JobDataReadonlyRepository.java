package com.ata.interview.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JobDataReadonlyRepository extends ReadonlyRepository<JobData, Long>, JpaSpecificationExecutor<JobData> {

}
