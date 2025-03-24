package oblig3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		AnsattDAO ansattDAO = new AnsattDAO();
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("kontorPU");
//        EntityManager em = emf.createEntityManager();
//        
//        try {
//        	Ansatt ansatt = em.find(Ansatt.class, 1L);
//        	System.out.println(ansatt);
//        } finally {
//        	em.close();
//        	emf.close();
//        }
		
		Ansatt aID = ansattDAO.finnAnsattMedId(1);
		System.out.println(aID);
		
		Ansatt aBrukernavn = ansattDAO.finnAnsattMedBrukernavn("LM10");
		System.out.println(aBrukernavn);
		
		Ansatt aBrukernavnF = ansattDAO.finnAnsattMedBrukernavn("SR4");
		System.out.println(aBrukernavnF);
		
		for(Ansatt a : ansattDAO.finnAlleAnsatte()) {
			System.out.println(a);
		}
		
		Ansatt ansatt = ansattDAO.finnAnsattMedId(1);
        ansattDAO.oppdaterAansattLonn(ansatt, 300.00);
        
        System.out.println(aID);
        
        Ansatt nyAnsatt = new Ansatt("SR4", "Sergio", "Ramos", LocalDate.parse("2020-10-31"), "Maniac", 199.01); 
        ansattDAO.leggTilAnsatt(nyAnsatt);
		for(Ansatt a : ansattDAO.finnAlleAnsatte()) {
			System.out.println(a);
		}
		
	}

}
