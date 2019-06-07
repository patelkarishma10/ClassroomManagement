package com.bae.mapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bae.persistance.repository.TraineeMapRepository;
import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

public class TraineeTest {

	private JSONUtil util;
	private TraineeMapRepository tmr;
	private Trainee trainee1;

	@Before
	public void setup() {
		util = new JSONUtil();
		tmr = new TraineeMapRepository();
		trainee1 = new Trainee((long) 1, "Joe Bloggs");
	}

	@Test
	public void getAllClassroomsWithEmptyMap() {
		assertEquals("{}", tmr.getAllTrainees());

	}

	@Test
	public void getAllClassroomsWithAnObjectInMap() {
		tmr.getTraineeMap().put((long) 1, trainee1);
		// System.out.println(util.getJSONForObject(tmr.getTraineeMap()));
		assertEquals("{\"1\":{\"id\":1,\"traineeName\":\"Joe Bloggs\"}}", tmr.getAllTrainees());

	}
}
