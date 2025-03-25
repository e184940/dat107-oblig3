package oblig3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelings_id;
	
	private String avdelingsnavn;
	
    @OneToOne
    @JoinColumn(name = "sjef_id")
    private Ansatt sjef;
    
    @OneToMany(mappedBy = "avdeling")
    private List<Ansatt> ansatte = new ArrayList<>();
    
	
	public Avdeling() {
		super();
	}
	
	public Avdeling(int avdelings_id, String avdelingsnavn, Ansatt sjef) {
		super();
		this.avdelings_id = avdelings_id;
		this.avdelingsnavn = avdelingsnavn;
		this.sjef = sjef;
	}

	public int getAvdelings_id() {
		return avdelings_id;
	}

	public void setAvdelings_id(int avdelings_id) {
		this.avdelings_id = avdelings_id;
	}

	public String getAvdelingsnavn() {
		return avdelingsnavn;
	}

	public void setAvdelingsnavn(String avdelingsnavn) {
		this.avdelingsnavn = avdelingsnavn;
	}

	public Ansatt getSjef_id() {
		return sjef;
	}

	public void setSjef_id(Ansatt sjef) {
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return "Avdeling [avdelings_id=" + avdelings_id + ", avdelingsnavn=" + avdelingsnavn + ", sjef_id=" + sjef
				+ "]";
	}

	public List<Ansatt> getAnsatte() {
		return ansatte;
	}

	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}	
	
	
}
