package com.aei.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aei.domain.Content;
import com.aei.domain.Discipline;
import com.aei.repository.ContentRepository;
import com.aei.repository.DisciplineRepository;

@Service
public class ContentService {

	private final ContentRepository contentRepository;
	private final DisciplineRepository disciplineRepository;

	public ContentService(ContentRepository contentRepository, DisciplineRepository disciplineRepository) {
		this.contentRepository = contentRepository;
		this.disciplineRepository = disciplineRepository;
	}

	// TODO RNG009 - CdU003 - D3
	public Iterable<Content> listAll() {
		return contentRepository.findAll();
	}

	// TODO RNG010 - CdU003 - D3
	public Content save(Content content) {		
		if(content.getId() == null)
			contentRepository.save(content);
		return contentRepository.save(content);
	}

	// TODO RNG011 - CdU003 - D3
	public Content find(Long id) {
		return contentRepository.findById(id).get();
	}

	// TODO RNG012 - CdU003 - D3
	public boolean delete(Long id) {
        try {
            contentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
	}
	

	// TODO RNG021 - CdU003 - D3
	public Iterable<Discipline> disciplineList(){
		return disciplineRepository.findAll();
	}
}
