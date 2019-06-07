package com.bae.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Classroom;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {

	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAllClassrooms() {
		TypedQuery<Classroom> query = em.createQuery("SELECT c FROM Classroom c", Classroom.class);
		Collection<Classroom> classrooms = query.getResultList();
		return json.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	@Override
	public String createClassroom(String classroom) {
		Classroom classroomCreated = this.json.getObjectForJSON(classroom, Classroom.class);
		em.persist(classroomCreated);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteClassroom(Long id) {
		Classroom ClassroomFound = em.find(Classroom.class, id);
		em.remove(ClassroomFound);
		return "{\"message\": \"classroom has been sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String updateClassroom(Long id, String classroom) {
		// Classroom accountCreated = this.json.getObjectForJSON(classroom,
		// Classroom.class);
		// Query q1 = em.createQuery(String.format("UPDATE CLASSROOM a SET a.trainer =
		// '%s' WHERE a.id = %s",
		// accountCreated.getTrainer(), id));
		// q1.executeUpdate();

		Classroom upClass = json.getObjectForJSON(classroom, Classroom.class);
		Classroom oldClass = em.find(Classroom.class, id);
		if (oldClass != null) {
			oldClass.setTrainer(upClass.getTrainer());

			em.persist(oldClass);
		}

		// Classroom ClassroomFound = em.find(Classroom.class, id);
		// em.remove(ClassroomFound);
		// Classroom classroomCreated = this.json.getObjectForJSON(classroom,
		// Classroom.class);
		// em.persist(classroomCreated);
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

}
