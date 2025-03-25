package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;

public class prosjektDAO {
	private EntityManager em;
	
	public prosjektDAO(EntityManager em) {
		this.em = em;
	}
	
	public void lagreProsjekt(Prosjekt prosjekt){
		em.getTransaction();
		em.persist(prosjekt);
		em.getTransaction().commit();
	}
	
	 public Prosjekt finnProsjekt(int id) {
	        return em.find(Prosjekt.class, id);
	    }

	    public List<Prosjekt> hentAlleProsjekter() {
	        return em.createQuery("SELECT p FROM Prosjekt p", Prosjekt.class).getResultList();
	    }
}
