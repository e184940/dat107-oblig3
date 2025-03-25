package oblig3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "prosjektDeltakelse")
public class prosjektDeltagelse {
	
	private String rolle;
    private int timer;
    
	
	 @Id
	    @ManyToOne
	    @JoinColumn(name = "ansatt_id")
	    private Ansatt ansatt;

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "prosjekt_id")
	    private Prosjekt prosjekt;

	    
		public prosjektDeltagelse(Ansatt ansatt, Prosjekt prosjekt, String rolle, int timer) {
			super();
			this.ansatt = ansatt;
			this.prosjekt = prosjekt;
			this.rolle = rolle;
			this.timer = timer;
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
		public int getTimer() {
			return timer;
		}
		public void setTimer(int timer) {
			this.timer = timer;
		}
		
	    @Override
		public String toString() {
			return "prosjektDeltagelse [ansatt=" + ansatt + ", prosjekt=" + prosjekt + ", rolle=" + rolle + ", timer="
					+ timer + "]";
		}

}
