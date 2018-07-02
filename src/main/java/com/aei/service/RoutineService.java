package com.aei.service;

import org.springframework.stereotype.Service;

import com.aei.domain.Activity;
import com.aei.domain.Routine;
import com.aei.repository.ActivityRepository;
import com.aei.repository.RoutineRepository;

@Service
public class RoutineService {

	private final RoutineRepository routineRepository;
	private final ActivityRepository activityRepository;

	public RoutineService(RoutineRepository routineRepository, ActivityRepository activityRepository) {
		this.routineRepository = routineRepository;
		this.activityRepository = activityRepository;
	}

	// TODO RNG005 - CdU002
	public Iterable<Routine> listAll() {
		return routineRepository.findAll();
	}

	// TODO RNG006 - CdU002
	public Routine save(Routine routine) {

		if (routine.getId() == null)
			routineRepository.save(routine);
		return routineRepository.save(routine);
	}

	// TODO RNG007 - CdU002
	public Routine find(Long id) {
		return routineRepository.findById(id).get();
	}

	// TODO RNG008 - CdU002
	public boolean delete(Long id) {
		try {
			routineRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Iterable<Activity>  activityList() {
		return activityRepository.findAll();
	}
}
