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
	private Classroom class2;

	@Before
	public void setup() {
		util = new JSONUtil();
		cmr = new ClassroomMapRepository();
		class1 = new Classroom((long) 1, "Matt Hunt");
		class2 = new Classroom((long) 2, "Chester Gardner");
	}

	@Test
	public void getAllClassroomsWithEmptyMap() {
		assertEquals("{}", cmr.getAllClassrooms());

	}

	@Test
	public void getAllClassroomsWithAnObjectInMap() {
		cmr.getClassroomMap().put((long) 1, class1);

		// System.out.println(cmr.getClassroomMap());
		assertEquals("{\"1\":{\"id\":1,\"trainer\":\"Matt Hunt\"}}", cmr.getAllClassrooms());

	}

	@Test
	public void createClassroomTest() {

		String testClass = util.getJSONForObject(class1);
		cmr.createClassroom(testClass);
		assertEquals(cmr.createClassroom(testClass), "successful creation");
		assertEquals(cmr.getClassroomMap().size(), 1);
	}

	@Test
	public void deleteClassroomTest() {
		String testClass1 = util.getJSONForObject(class1);
		cmr.createClassroom(testClass1);
		String testClass2 = util.getJSONForObject(class2);
		cmr.createClassroom(testClass2);
		System.out.println(cmr.getClassroomMap());
		cmr.deleteClassroom((long) 2);
		assertEquals(cmr.getClassroomMap().size(), 1);
		System.out.println(cmr.getClassroomMap());
	}
}
