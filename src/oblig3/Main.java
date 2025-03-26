package oblig3;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);
	private static final AnsattDAO ansattDAO = new AnsattDAO();
	private static final AvdelingDAO avdelingDAO = new AvdelingDAO();
	private static final ProsjektDAO prosjektDAO = new ProsjektDAO();

	public static void main(String[] args) {
		
		while (true) {
			System.out.println();
			System.out.println("MENY");
			System.out.println("1:  Finn ansatt med ID");
			System.out.println("2:  Finn ansatt med brukernavn");
			System.out.println("3:  List alle ansatte");
			System.out.println("4:  Oppdater ansatt sin stilling");
			System.out.println("5:  Oppdater ansatt sin lønn");
			System.out.println("6:  Legg til ny ansatt");
			System.out.println("7:  Finn avdeling med ID");
			System.out.println("8:  List ansatte i avdeling");
			System.out.println("9:  Endre avdeling for en ansatt");
			System.out.println("10: Legg til ny avdeling");
			System.out.println("11: Legg til nytt prosjekt");
			System.out.println("12: Registrer ansatt på prosjekt");
			System.out.println("13: Avslutt");
			System.out.print("Velg et alternativ: ");
			int valg = scanner.nextInt();
			scanner.nextLine();

			switch (valg) {
			case 1:
				finnAnsattMedId();
				break;
			case 2:
				finnAnsattMedBrukernavn();
				break;
			case 3:
				listAlleAnsatte();
				break;
			case 4:
				oppdaterStilling();
				break;
			case 5:
				oppdaterLonn();
				break;
			case 6: 
				leggTilAnsatt();
				break;
			case 7:
				finnAvdelingMedId();
				break;
			case 8:
				listAnsatteIAvdeling();
				break;
			case 9:
				endreAvdeling();
				break;
			case 10:
				leggTilAvdeling();
				break;
//			case 11:
//				leggTilProsjekt();
//				break;
//			case 12:
//				registrerAnsattIProsjekt();
//				break;
			case 13:
				System.out.println("Avslutter programmet...");
				return;
			default:
				System.out.println("Ugyldig valg, prøv igjen");
			}
		}
	}

	private static void leggTilAvdeling() {
		System.out.println("Navn på ny avdeling: ");
		String inputNyAvdeling = scanner.nextLine();
		
		System.out.println("Brukernavn på sjef for avdeling " + inputNyAvdeling + ": ");
		String inputNySjefForAvdeling = scanner.nextLine();
		
		Ansatt nySjef = ansattDAO.finnAnsattMedBrukernavn(inputNySjefForAvdeling);
		if (nySjef != null) {
			if (!avdelingDAO.erSjefForEnAvdeling(nySjef)) {
				ansattDAO.leggTilAvdeling(inputNyAvdeling, nySjef);
				System.out.println("Ny sjef for avdeling " + inputNyAvdeling + ": " + nySjef.getBrukernavn());
			} else {
				System.out.println("Er allerede sjef for avdeling " + nySjef.getAvdeling().getAvdelingsnavn());
			}
		}
	}

	private static void finnAnsattMedId() {
		System.out.print("Skriv inn ansatt-ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
		System.out.println(ansatt != null ? ansatt : "Fant ingen ansatt med ID " + id);
	}

	private static void finnAnsattMedBrukernavn() {
		System.out.print("Skriv inn brukernavn: ");
		String brukernavn = scanner.nextLine();
		Ansatt ansatt = ansattDAO.finnAnsattMedBrukernavn(brukernavn);
		System.out.println(ansatt != null ? ansatt : "Fant ingen ansatt med brukernavn " + brukernavn);
	}

	private static void listAlleAnsatte() {
		List<Ansatt> ansatte = ansattDAO.finnAlleAnsatte();
		ansatte.forEach(System.out::println);
	}

	private static void oppdaterStilling() {
		System.out.print("Skriv inn ansatt-ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Skriv inn ny stilling: ");
		String stilling = scanner.nextLine();
		Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
		if (ansatt != null) {
			ansattDAO.oppdaterAnsattStilling(ansatt, stilling);
			System.out.println("Stillingen er oppdatert.");
		} else {
			System.out.println("Fant ikke ansatt");
		}
	}

	private static void oppdaterLonn() {
		System.out.print("Skriv inn ansatt-ID: ");
		int id = scanner.nextInt();
		System.out.print("Skriv inn ny lønn: ");
		double lonn = scanner.nextDouble();
		Ansatt ansatt = ansattDAO.finnAnsattMedId(id);
		if (ansatt != null) {
			ansattDAO.oppdaterAansattLonn(ansatt, lonn);
			System.out.println("Lønn oppdatert");
		} else {
			System.out.println("Fant ikke ansatt");
		}
	}

	private static void leggTilAnsatt() {
		System.out.print("Brukernavn: ");
		String brukernavn = scanner.nextLine();
		System.out.print("Fornavn: ");
		String fornavn = scanner.nextLine();
		System.out.print("Etternavn: ");
		String etternavn = scanner.nextLine();
		System.out.print("Ansettelsesdato (YYYY-MM-DD): ");
		LocalDate ansDato = LocalDate.parse(scanner.nextLine());
		System.out.print("Stilling: ");
		String stilling = scanner.nextLine();
		System.out.print("Månedslønn: ");
		double maanedslonn = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Avdelings-ID: ");
		int avdelingsId = scanner.nextInt();
		scanner.nextLine();
		Avdeling avdeling = avdelingDAO.finnAvdelingMedId(avdelingsId);
		if (avdeling != null) {
			Ansatt nyAnsatt = new Ansatt(brukernavn, fornavn, etternavn, ansDato, stilling, maanedslonn, avdeling);
			ansattDAO.leggTilAnsatt(nyAnsatt);
			System.out.println("Ansatt lagt til");
		} else {
			System.out.println("Fant ikke avdeling");
		}
	}

	private static void finnAvdelingMedId() {
		System.out.print("Skriv inn avdelings-ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Avdeling avdeling = avdelingDAO.finnAvdelingMedId(id);
		System.out.println(avdeling != null ? avdeling : "Fant ingen avdeling med ID " + id);
	}

	private static void listAnsatteIAvdeling() {
		System.out.print("Skriv inn avdelings-ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		List<Ansatt> ansatte = avdelingDAO.finnAnsatteIAvdeling(id);
		ansatte.forEach(System.out::println);
	}

	private static void endreAvdeling() {
		System.out.print("Skriv inn ansatt-ID: ");
		int ansattId = scanner.nextInt();
		System.out.print("Skriv inn ny avdelings-ID: ");
		int avdelingId = scanner.nextInt();
		scanner.nextLine();
		Ansatt ansatt = ansattDAO.finnAnsattMedId(ansattId);
		Avdeling nyAvdeling = avdelingDAO.finnAvdelingMedId(avdelingId);
		if (ansatt != null && nyAvdeling != null) {
			ansattDAO.oppdaterAvdeling(ansatt, nyAvdeling);
			System.out.println("Avdeling oppdatert");
		} else {
			System.out.println("Feil: Ansatt eller avdeling ikke funnet");
		}
	}
	
}
