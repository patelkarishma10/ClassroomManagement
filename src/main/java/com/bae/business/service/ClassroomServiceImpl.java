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

}