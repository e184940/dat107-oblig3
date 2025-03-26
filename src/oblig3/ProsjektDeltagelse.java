package oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class ProsjektDeltagelse {

	@Id
	@ManyToOne
	@JoinColumn(name = "ansatt_id")
	private Ansatt ansatt;

	@Id
	@ManyToOne
	@JoinColumn(name = "prosjekt_id")
	private Prosjekt prosjekt;
	
	private String rolle;
	private double arbeidstimer;

	public ProsjektDeltagelse(Ansatt ansatt, Prosjekt prosjekt, String rolle, double arbeidstimer) {
		super();
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		this.rolle = rolle;
		this.arbeidstimer = arbeidstimer;
	}
	
	public ProsjektDeltagelse() {
		
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjekt) {
		this.prosjekt = prosjekt;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public double getArbeidstimer() {
		return arbeidstimer;
	}

	public void setArbdeidtimer(double arbeidstimer) {
		this.arbeidstimer = arbeidstimer;
	}

	@Override
	public String toString() {
		return "prosjektDeltagelse [ansatt=" + ansatt + ", prosjekt=" + prosjekt + ", rolle=" + rolle + ", arbeidstimer="
				+ arbeidstimer + "]";
	}

}
