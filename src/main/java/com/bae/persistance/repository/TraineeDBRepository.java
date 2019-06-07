package com.bae.persistance.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Trainee;
import com.bae.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {

	@Inject
	private JSONUtil json;

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Override
	public String getAllTrainees() {
		TypedQuery<Trainee> query = em.createQuery("SELECT t FROM Trainee t", Trainee.class);
		Collection<Trainee> trainees = query.getResultList();
		return json.getJSONForObject(trainees);
	}

}
