package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AvdelingDAO {

	private EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("fotballPU");
	}

	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
	}

	public List<Ansatt> finnAnsatteIAvdeling(int avdelingId) {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ansatt> query = em
					.createQuery("select a from Ansatt a where a.avdeling.avdelings_id = :avdelingId", Ansatt.class);
			query.setParameter("avdelingId", avdelingId);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public void leggTilAvdeling(String navn, Ansatt sjef) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			TypedQuery<Avdeling> query = em.createQuery("select a from Avdeling a where a.sjef = :sjef",
					Avdeling.class);
			query.setParameter("sjef", sjef);
			List<Avdeling> avdelingerMedSjef = query.getResultList();
			if (!avdelingerMedSjef.isEmpty()) {
				System.out.print("Sjefen er allerede sjef for en avdeling");
				return;
			}
			tx.begin();
			Avdeling nyAvdeling = new Avdeling();
			nyAvdeling.setAvdelingsnavn(navn);
			nyAvdeling.setSjef_id(sjef);
			sjef.setAvdeling(nyAvdeling);
			em.persist(nyAvdeling);
			em.merge(sjef);
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

	public boolean erSjefForEnAvdeling(Ansatt sjef) {
	    EntityManager em = emf.createEntityManager();
	    try {
	        TypedQuery<Avdeling> query = em.createQuery("select a from Avdeling a where a.sjef = :sjef", Avdeling.class);
	        query.setParameter("sjef", sjef);
	        List<Avdeling> avdelinger = query.getResultList();
	        return !avdelinger.isEmpty();
	    } finally {
	        em.close();
	    }
	}

}
