package com.aei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aei.domain.Discipline;

@Repository
public interface DisciplineRepository extends CrudRepository<Discipline, Long>{

}
