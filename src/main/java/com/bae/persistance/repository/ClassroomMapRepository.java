package com.bae.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import com.bae.util.JSONUtil;

public class ClassroomMapRepository implements ClassroomRepository {

	private Map<Long, String> classroomMap = new HashMap<>();
	private JSONUtil util = new JSONUtil();

	@Override
	public String getAllClassrooms() {
		return util.getJSONForObject(getClassroomMap());
	}

	public Map<Long, String> getClassroomMap() {
		return classroomMap;
	}

}
