package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistance.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {

	@Inject
	private ClassroomRepository repo;

	@Override
	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}

	@Override
	public String createClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	@Override
	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);
	}

}
