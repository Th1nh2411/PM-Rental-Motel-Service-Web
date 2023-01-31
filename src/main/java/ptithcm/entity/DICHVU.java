package ptithcm.entity;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="DICHVU")
public class DICHVU {
	@Id @GeneratedValue
	private String MADV;
	private String TENDV;
	
	private Double DONGIA;
	
	@OneToMany(mappedBy="dichvu", fetch=FetchType.EAGER)
	private Collection<SUDUNGDV> sudungdvs;

	public String getMADV() {
		return MADV;
	}

	public void setMADV(String mADV) {
		MADV = mADV;
	}

	public String getTENDV() {
		return TENDV;
	}

	public void setTENDV(String tENDV) {
		TENDV = tENDV;
	}

	public Double getDONGIA() {
		return DONGIA;
	}

	public void setDONGIA(Double dONGIA) {
		DONGIA = dONGIA;
	}

	public Collection<SUDUNGDV> getSudungdvs() {
		return sudungdvs;
	}

	public void setSudungdvs(Collection<SUDUNGDV> sudungdvs) {
		this.sudungdvs = sudungdvs;
	}
	
}
