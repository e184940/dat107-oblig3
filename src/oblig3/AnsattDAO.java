package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("kontorPU");
	}

	/*
	 * try { Ansatt ansatt = em.find(Ansatt.class, 1); System.out.println(ansatt); }
	 * finally { em.close(); emf.close(); }
	 */

	public Ansatt finnAnsattMedId(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a where a.brukernavn = :brukernavn",
					Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			return query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Fant ingen ansatt med brukernavn: " + brukernavn);
			return null;
		} finally {
			em.close();
		}
	}

	public List<Ansatt> finnAlleAnsatte() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a", Ansatt.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public void oppdaterAansattLonn(Ansatt ansatt, double nyLonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ansatt.setMaandeslonn(nyLonn);
			em.merge(ansatt);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public void oppdaterAnsattStilling(Ansatt ansatt, String nyStilling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ansatt.setStilling(nyStilling);
			em.merge(ansatt);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

}
