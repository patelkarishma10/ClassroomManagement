package com.bae.persistance.repository;

public interface ClassroomRepository {

	// C
	String createClassroom(String classroom);

	// R
	String getAllClassrooms();

	// U
	String updateClassroom(Long id, String classroom);

	// D
	String deleteClassroom(Long id);
}
