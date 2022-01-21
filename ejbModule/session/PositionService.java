package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.IDaoPositionLocal;
import dao.IDaoPositionRemote;
import entities.Position;

@Stateless
public class PositionService implements IDaoPositionLocal, IDaoPositionRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	public PositionService() {
		super();
		
	}

	@Override
	public boolean create(Position u) {
		entityManager.persist(u);
		return true;
	}

	@Override
	public boolean delete(Position u) {
		entityManager.remove(entityManager.contains(u)?u: entityManager.merge(u));
		return true;
	}

	@Override
	public boolean update(Position u) {
		entityManager.persist(entityManager.contains(u)?u: entityManager.merge(u));
		return true;
	}

	@Override
	public Position getById(int id) {
		return entityManager.find(Position.class, id);
	}

	@Override
	public List<Position> getAll() {
		Query query= entityManager.createQuery("from Smartphone");
		return query.getResultList();
	}

	@Override
	public List<Position> getByImei(String imei) {
		//Query query= entityManager.createQuery("select s from Smartphone where s.imei="+imei);
		Query query= entityManager.createQuery("from Smartphone");
		return query.getResultList();
	}

}
