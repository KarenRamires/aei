package com.aei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aei.domain.Routine;

@Repository
public interface RoutineRepository extends CrudRepository<Routine, Long>{

}
