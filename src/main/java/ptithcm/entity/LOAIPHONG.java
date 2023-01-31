package ptithcm.entity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOAIPHONG")
public class LOAIPHONG {
	@Id @GeneratedValue
	private String MALOAIPHONG;
	private String TENLOAIPHONG;
	private Integer DONGIA;
	private Integer SONGUOITOIDA;
	
	@OneToMany(mappedBy="loaiphong", fetch=FetchType.EAGER)
	private Collection<PHONG> phongs;

	public String getMALOAIPHONG() {
		return MALOAIPHONG;
	}

	public void setMALOAIPHONG(String mALOAIPHONG) {
		MALOAIPHONG = mALOAIPHONG;
	}

	public String getTENLOAIPHONG() {
		return TENLOAIPHONG;
	}

	public void setTENLOAIPHONG(String tENLOAIPHONG) {
		TENLOAIPHONG = tENLOAIPHONG;
	}

	public Integer getDONGIA() {
		return DONGIA;
	}

	public void setDONGIA(Integer dONGIA) {
		DONGIA = dONGIA;
	}

	public Integer getSONGUOITOIDA() {
		return SONGUOITOIDA;
	}

	public void setSONGUOITOIDA(Integer sONGUOITOIDA) {
		SONGUOITOIDA = sONGUOITOIDA;
	}

	public Collection<PHONG> getPhongs() {
		return phongs;
	}

	public void setPhongs(Collection<PHONG> phongs) {
		this.phongs = phongs;
	}
}
