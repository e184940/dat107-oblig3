package oblig3;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		AnsattDAO ansattDAO = new AnsattDAO();
		
		AvdelingDAO avdelingDAO = new AvdelingDAO();
		
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
        
        Avdeling av = avdelingDAO.finnAvdelingMedId(1);
        System.out.println(av);
        System.out.println("Avdeling: " + av.getAvdelingsnavn());
        
        Ansatt sjef = ansattDAO.finnAnsattMedId(av.getSjef_id());
        
        List<Ansatt> ansatte = avdelingDAO.finnAnsatteIAvdeling(1);
        for (Ansatt a : ansatte) {
            if (a.equals(sjef)) {
                System.out.println(a.getFornavn() + " " + a.getEtternavn() + " (Sjef)");
            } else {
                System.out.println(a.getFornavn() + " " + a.getEtternavn());
            }
        }
        
//      Ansatt nyAnsatt = new Ansatt("SR4", "Sergio", "Ramos", LocalDate.parse("2020-10-31"), "Maniac", 199.01); 
//      ansattDAO.leggTilAnsatt(nyAnsatt);
//		for(Ansatt a : ansattDAO.finnAlleAnsatte()) {
//			System.out.println(a);
//		}
        
        System.out.println("Original avdeling: " + aBrukernavnF.getAvdeling().getAvdelingsnavn());
        ansattDAO.oppdaterAvdeling(aBrukernavnF, avdelingDAO.finnAvdelingMedId(1));
        System.out.println("Ny avdeling: " + aBrukernavnF.getAvdeling().getAvdelingsnavn());
		
	}

}
