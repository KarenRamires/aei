package com.aei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aei.domain.Content;

@Repository
public interface ContentRepository extends CrudRepository<Content, Long> {

}
