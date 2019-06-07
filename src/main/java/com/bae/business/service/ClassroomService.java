package com.bae.business.service;

public interface ClassroomService {

	// C
	String createClassroom(String classroom);

	// R

	String getAllClassrooms();

	// U
	String updateClassroom(Long id, String classroom);
	// D

	String deleteClassroom(Long id);

}
