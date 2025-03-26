package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ProsjektDAO {

	private EntityManagerFactory emf;

	public ProsjektDAO() {
		emf = Persistence.createEntityManagerFactory("fotballPU");
	}

	public void lagreProsjekt(Prosjekt prosjekt) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(prosjekt);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public Prosjekt finnProsjekt(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Prosjekt.class, id);
		} finally {
			em.close();
		}
	}

	public List<Prosjekt> hentAlleProsjekter() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Prosjekt> query = em.createQuery("select pr from Prosjekt pr", Prosjekt.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
	
	public void registrerAnsattIProsjekt(ProsjektDeltagelse deltagelse) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(deltagelse);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}
}
