package oblig3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Prosjekt {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjekt_id;
    
    private String prosjektnavn;
    private String beskrivelse;

    @OneToMany(mappedBy = "prosjekt")
    private List<ProsjektDeltagelse> deltagelser;
    
    public Prosjekt() {
    	
    }

	public Prosjekt(String prosjektnavn, String beskrivelse, List<ProsjektDeltagelse> deltagelser) {
		super();
		this.prosjektnavn = prosjektnavn;
		this.beskrivelse = beskrivelse;
		this.deltagelser = deltagelser;
	}

	public int getProsjekt_id() {
		return prosjekt_id;
	}

	public void setProsjektId(int prosjekt_id) {
		this.prosjekt_id = prosjekt_id;
	}

	public String getProsjektnavn() {
		return prosjektnavn;
	}

	public void setNavn(String prosjektnavn) {
		this.prosjektnavn = prosjektnavn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public List<ProsjektDeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<ProsjektDeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}

	@Override
	public String toString() {
		return "Prosjekt [prosjekt_id=" + prosjekt_id + ", prosjektnavn=" + prosjektnavn + ", beskrivelse=" + beskrivelse + "]";
	}

}