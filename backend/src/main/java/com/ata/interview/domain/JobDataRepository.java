package com.ata.interview.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface JobDataRepository extends CrudRepository<JobData, Long>, JpaSpecificationExecutor<JobData> {

}
