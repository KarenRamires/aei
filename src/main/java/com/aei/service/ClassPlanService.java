package com.aei.service;

import org.springframework.stereotype.Service;

import com.aei.domain.ClassPlan;
import com.aei.domain.Routine;
import com.aei.repository.ClassPlanRepository;
import com.aei.repository.RoutineRepository;

@Service
public class ClassPlanService {

	private final ClassPlanRepository classPlanRepository;
	private final RoutineRepository routineRepository;

	public ClassPlanService(ClassPlanRepository classPlanRepository, RoutineRepository routineRepository) {
		this.classPlanRepository = classPlanRepository;
		this.routineRepository = routineRepository;
	}

	// TODO RNG018 - CdU005
	public Iterable<ClassPlan> listAll() {
		return classPlanRepository.findAll();
	}

	// TODO RNG019 - CdU005
	public ClassPlan save(ClassPlan classPlan) {

		if (classPlan.getId() == null)
			classPlanRepository.save(classPlan);
		return classPlanRepository.save(classPlan);
	}

	// TODO RNG020 - CdU005
	public ClassPlan find(Long id) {
		return classPlanRepository.findById(id).get();
	}

	// TODO RNG021 - CdU005
	public boolean delete(Long id) {
		try {
			classPlanRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// TODO RNG023 - CdU005
	public Iterable<Routine> routineList() {
		return routineRepository.findAll();
	}
}
