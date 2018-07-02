package com.aei.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.aei.domain.Activity;
import com.aei.domain.Content;
import com.aei.repository.ActivityRepository;
import com.aei.repository.ContentRepository;

@Service
public class ActivityService {

	private final ActivityRepository activityRepository;
	private final ContentRepository contentRepository;
	

	public ActivityService(ActivityRepository activityRepository, ContentRepository contentRepository) {
		this.activityRepository = activityRepository;
		this.contentRepository = contentRepository;
	}

	// TODO RNG013 - CdU004 **Solicitado pelo professor para ser implementado
	public Iterable<Activity> listAll() {
		return activityRepository.findAll();
	}

	// TODO RNG014 - CdU004 **Solicitado pelo professor para ser implementado
	public Activity save(Activity activity) {

		if (activity.getId() == null)
			activityRepository.save(activity);
		return activityRepository.save(activity);
	}

	// TODO RNG015 - CdU004 **Solicitado pelo professor para ser implementado
	public Activity find(Long id) {
		return activityRepository.findById(id).get();
	}

	// TODO RNG016 - CdU004 **Solicitado pelo professor para ser implementado
	public boolean delete(Long id) {
		try {
			activityRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// TODO RNG022 - CdU004 **Solicitado pelo professor para ser implementado
	public Iterable<Content> contentList() {
		return contentRepository.findAll();
	}
}
