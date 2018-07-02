package com.aei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aei.domain.Activity;


@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

}
