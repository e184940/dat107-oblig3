package oblig3;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(schema = "oblig3")
public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansatt_id;

	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansDato;
	private String stilling;
	private double maanedslonn;
	
	@ManyToOne
	@JoinColumn(name = "avdelings_id")
	private Avdeling avdeling;

	public Ansatt() {
	}

	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansDato, String stilling,
			double maanedslonn, Avdeling avdeling) {
		super();
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansDato = ansDato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.avdeling = avdeling;
		
	}
	
	@OneToMany(mappedBy = "ansatt")
	private List<Prosjektdeltagelse> prosjektdeltagelser = new ArrayList<>();

	public int getAnsattId() {
		return ansatt_id;
	}

	public void setAnsattId(int ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsDato() {
		return ansDato;
	}

	public void setAnsDato(LocalDate ansDato) {
		this.ansDato = ansDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public double getMaanedlonn() {
		return maanedslonn;
	}

	public void setMaandeslonn(double maanedslonn) {
		this.maanedslonn = maanedslonn;
	}


	public Avdeling getAvdeling() {
		return avdeling;
	}
		
	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}
	
	@Override
	public String toString() {
	    return "Ansatt [" +
	            "brukernavn=" + brukernavn +
	            ", fornavn=" + fornavn  +
	            ", etternavn=" + etternavn +
	            ", stilling=" + stilling +
	            ", månedslønn=" + maanedslonn +
	            ", avdeling=" + (avdeling != null ? avdeling.getAvdelingsnavn() : "Ingen") +
	            "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ansatt ansatt = (Ansatt) o;
        return ansatt_id == ansatt.ansatt_id;
    }

}
