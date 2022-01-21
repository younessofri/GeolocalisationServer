package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.IDaoUserLocal;
import dao.IDaoUserRemote;
import entities.User;

@Stateless
public class UserService implements IDaoUserLocal, IDaoUserRemote {
	
	@PersistenceContext
	private EntityManager entityManager;


	public UserService() {
		super();
	}

	@Override
	public boolean create(User u) {
		// TODO Auto-generated method stub
		entityManager.persist(u);
		return true;
	}

	@Override
	public boolean delete(User u) {
		// TODO Auto-generated method stub
		//em.remove(u);
		entityManager.remove(entityManager.contains(u)?u: entityManager.merge(u));
		return true;
	}
	
	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		entityManager.persist(entityManager.contains(u)?u: entityManager.merge(u));
		return true;
	}

	@Override
	public User getById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getAll() {
		Query query= entityManager.createQuery("from User");
		return query.getResultList();
	}

	@Override
	public List<User> getByImei(String imei) {
		// TODO Auto-generated method stub
		return null;
	}

}
