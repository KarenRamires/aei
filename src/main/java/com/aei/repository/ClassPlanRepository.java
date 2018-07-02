package com.aei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aei.domain.ClassPlan;


@Repository
public interface ClassPlanRepository extends CrudRepository<ClassPlan, Long> {

}
 