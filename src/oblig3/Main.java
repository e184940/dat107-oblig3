package oblig3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("kontorPU");
        EntityManager em = emf.createEntityManager();
        
        try {
        	Ansatt ansatt = em.find(Ansatt.class, 1L);
        	System.out.println(ansatt);
        } finally {
        	em.close();
        	emf.close();
        }
		
	}

}
