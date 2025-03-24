package oblig3;

    import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.Persistence;

	public class AvedlingDAO {
	    
	    private EntityManagerFactory emf;

	    public AvedlingDAO(EntityManagerFactory emf) {
	        this.emf = emf;
	    }

	    public Avdeling finnAvdelingMedId(int id) {
	        EntityManager em = emf.createEntityManager();
	        try {
	            return em.find(Avdeling.class, id);
	        } finally {
	            em.close();
	        }
	    }
	}
}
