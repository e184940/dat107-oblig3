package oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelings_id;
	
	private String avdelingsnavn;
	private int sjef_id;
	
	public Avdeling() {
		super();
	}
	
	public Avdeling(int avdelings_id, String avdelingsnavn, int sjef_id) {
		super();
		this.avdelings_id = avdelings_id;
		this.avdelingsnavn = avdelingsnavn;
		this.sjef_id = sjef_id;
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

	public int getSjef_id() {
		return sjef_id;
	}

	public void setSjef_id(int sjef_id) {
		this.sjef_id = sjef_id;
	}

	@Override
	public String toString() {
		return "Avdeling [avdelings_id=" + avdelings_id + ", avdelingsnavn=" + avdelingsnavn + ", sjef_id=" + sjef_id
				+ "]";
	}	
}
