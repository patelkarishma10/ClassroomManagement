package com.bae.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {

	private Map<Long, Trainee> traineeMap = new HashMap<>();
	private JSONUtil util = new JSONUtil();

	public Map<Long, Trainee> getTraineeMap() {
		return traineeMap;
	}

	@Override
	public String getAllTrainees() {
		return util.getJSONForObject(getTraineeMap());
	}

}
