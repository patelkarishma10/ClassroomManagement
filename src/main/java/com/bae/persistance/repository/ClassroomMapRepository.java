package com.bae.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.bae.persistence.domain.Classroom;
import com.bae.util.Constants;
import com.bae.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository {

	private Map<Long, Classroom> classroomMap = new HashMap<>();
	private JSONUtil util = new JSONUtil();

	@Override
	public String getAllClassrooms() {
		return util.getJSONForObject(getClassroomMap());
	}

	@Override
	public String createClassroom(String classroom) {
		Classroom class1 = this.util.getObjectForJSON(classroom, Classroom.class);
		System.out.println(class1);
		classroomMap.put(class1.getId(), class1);
		return Constants.createSuccess;
	}

	@Override
	public String deleteClassroom(Long id) {
		classroomMap.remove(id);
		return Constants.deleteSuccess;
	}

	public Map<Long, Classroom> getClassroomMap() {
		return classroomMap;
	}

}
