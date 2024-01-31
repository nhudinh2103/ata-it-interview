package com.ata.interview.domain;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadonlyRepository<T, ID> extends Repository<T, ID> {
	
	List<T> findAll();

}
