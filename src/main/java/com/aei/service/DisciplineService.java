package com.aei.service;

import org.springframework.stereotype.Service;

import com.aei.domain.Discipline;
import com.aei.repository.DisciplineRepository;

@Service
public class DisciplineService {

	private final DisciplineRepository disciplineRepository;

	public DisciplineService(DisciplineRepository disciplineRepository) {
		this.disciplineRepository = disciplineRepository;
	}

	// TODO RNG001 - CdU001
	public Iterable<Discipline> listAll() {
		return disciplineRepository.findAll();
	}

	// TODO RNG002 - CdU001
	public Discipline save(Discipline discipline) {
		Discipline fetchedDiscipline = this.getOne(discipline);
		fetchedDiscipline.setName(discipline.getName());
		fetchedDiscipline.setDescription(discipline.getDescription());
		
		//if (discipline.getId() == null)
		//	disciplineRepository.save(discipline);
		//return disciplineRepository.save(discipline);

		return disciplineRepository.save(fetchedDiscipline);
	}

	public Discipline getOne(Discipline discipline) {
		return disciplineRepository.findById(discipline.getId()).get();
	}
	
	// TODO RNG003 - CdU001
	public Discipline find(Long id) {
		return disciplineRepository.findById(id).get();
	}

	// TODO RNG004 - CdU001
	public void delete(Long id) {
		disciplineRepository.deleteById(id);
	}

}
