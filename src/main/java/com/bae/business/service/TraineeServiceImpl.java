package com.bae.business.service;

import javax.inject.Inject;

import com.bae.persistance.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;

	@Override
	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

}
