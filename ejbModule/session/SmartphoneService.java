package session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.IDaoSmartphoneLocal;
import dao.IDaoSmartphoneRemote;
import entities.Smartphone;

@Stateless
public class SmartphoneService implements IDaoSmartphoneLocal, IDaoSmartphoneRemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	public SmartphoneService() {
		super();
		
	}

	@Override
	public boolean create(Smartphone u) {
		entityManager.persist(u);
		return true;
	}

	@Override
	public boolean delete(Smartphone u) {
		entityManager.remove(entityManager.contains(u)?u: entityManager.merge(u));
		return true;
	}

	@Override
	public boolean update(Smartphone u) {
		entityManager.persist(entityManager.contains(u)?u: entityManager.merge(u));
		return true;
	}

	@Override
	public Smartphone getById(int id) {
		return entityManager.find(Smartphone.class, id);
	}

	@Override
	public List<Smartphone> getAll() {
		Query query= entityManager.createQuery("from Smartphone");
		return query.getResultList();
	}

	@Override
	public List<Smartphone> getByImei(String imei) {
		//Query query= entityManager.createQuery("select s from Smartphone where s.imei="+imei);
		Query query= entityManager.createQuery("from Smartphone");
		return query.getResultList();
	}

}
