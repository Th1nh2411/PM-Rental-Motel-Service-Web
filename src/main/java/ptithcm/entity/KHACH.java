package ptithcm.entity;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="KHACH")
public class KHACH {
	@Id @GeneratedValue
	private String MAKHACH;
	private String HOVATEN;
	private String EMAIL;
	private String SOCMND;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date NGAYSINH;
	private String GIOITINH;
	private String DIACHI;
	private String SDT;
	private String NGHENGHIEP;
	
	@OneToMany(mappedBy="khach", fetch=FetchType.EAGER)
	private Collection<HOPDONG> hopdongs;

	public String getMAKHACH() {
		return MAKHACH;
	}

	public void setMAKHACH(String mAKHACH) {
		MAKHACH = mAKHACH;
	}

	public String getHOVATEN() {
		return HOVATEN;
	}

	public void setHOVATEN(String hOVATEN) {
		HOVATEN = hOVATEN;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getSOCMND() {
		return SOCMND;
	}

	public void setSOCMND(String sOCMND) {
		SOCMND = sOCMND;
	}

	public Date getNGAYSINH() {
		return NGAYSINH;
	}

	public void setNGAYSINH(Date nGAYSINH) {
		NGAYSINH = nGAYSINH;
	}

	public String getGIOITINH() {
		return GIOITINH;
	}

	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}

	public String getDIACHI() {
		return DIACHI;
	}

	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getNGHENGHIEP() {
		return NGHENGHIEP;
	}

	public void setNGHENGHIEP(String nGHENGHIEP) {
		NGHENGHIEP = nGHENGHIEP;
	}

	public Collection<HOPDONG> getHopdongs() {
		return hopdongs;
	}

	public void setHopdongs(Collection<HOPDONG> hopdongs) {
		this.hopdongs = hopdongs;
	}
}
