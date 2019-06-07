package com.bae.mapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistance.repository.ClassroomMapRepository;
import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

public class ClassroomTest {
	private JSONUtil util;
	private ClassroomMapRepository cmr;
	private Classroom class1;

	@Before
	public void setup() {
		util = new JSONUtil();
		cmr = new ClassroomMapRepository();
		class1 = new Classroom((long) 1, "Matt Hunt");
	}

	@Test
	public void getAllClassroomsWithEmptyMap() {
		assertEquals("{}", cmr.getAllClassrooms());

	}

	@Test
	public void getAllClassroomsWithAnObjectInMap() {
		cmr.getClassroomMap().put((long) 1, "Matt Hunt");
		assertEquals("{\"1\":\"Matt Hunt\"}", cmr.getAllClassrooms());

	}
}
