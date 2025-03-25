package oblig3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prosjekt")

public class Prosjekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektId;
    
    private String navn;
    private String beskrivelse;

    @OneToMany(mappedBy = "prosjekt")
    private List<prosjektDeltagelse> deltagelser = new ArrayList<>();

	public Prosjekt(int prosjektId, String navn, String beskrivelse, List<prosjektDeltagelse> deltagelser) {
		super();
		this.prosjektId = prosjektId;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.deltagelser = deltagelser;
	}

	public int getProsjektId() {
		return prosjektId;
	}

	public void setProsjektId(int prosjektId) {
		this.prosjektId = prosjektId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public List<prosjektDeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<prosjektDeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}

	@Override
	public String toString() {
		return "Prosjekt [prosjektId=" + prosjektId + ", navn=" + navn + ", beskrivelse=" + beskrivelse + "]";
	}

}