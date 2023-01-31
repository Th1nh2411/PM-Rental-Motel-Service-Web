package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HOPDONG")
public class HOPDONG {
	@Id @GeneratedValue
	private String MAHOPDONG;
	
	@ManyToOne
    @JoinColumn(name="MAKHACH")
    private KHACH khach;
	
	@ManyToOne
    @JoinColumn(name="MAPHONG")
    private PHONG phong;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date NGAYTHUE;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date NGAYTRA;
	
	private Integer TIENCOC;
	private boolean TRANGTHAI;
	private String GHICHU;
	
	@OneToMany(mappedBy="hopdong",fetch = FetchType.EAGER)
	private Collection<HOADON> hoadons;

	public String getMAHOPDONG() {
		return MAHOPDONG;
	}

	public void setMAHOPDONG(String mAHOPDONG) {
		MAHOPDONG = mAHOPDONG;
	}

	public KHACH getKhach() {
		return khach;
	}

	public void setKhach(KHACH khach) {
		this.khach = khach;
	}

	public PHONG getPhong() {
		return phong;
	}

	public void setPhong(PHONG phong) {
		this.phong = phong;
	}

	public Date getNGAYTHUE() {
		return NGAYTHUE;
	}

	public void setNGAYTHUE(Date nGAYTHUE) {
		NGAYTHUE = nGAYTHUE;
	}

	public Date getNGAYTRA() {
		return NGAYTRA;
	}

	public void setNGAYTRA(Date nGAYTRA) {
		NGAYTRA = nGAYTRA;
	}

	public Integer getTIENCOC() {
		return TIENCOC;
	}

	public void setTIENCOC(Integer tIENCOC) {
		TIENCOC = tIENCOC;
	}

	public boolean isTRANGTHAI() {
		return TRANGTHAI;
	}

	public void setTRANGTHAI(boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}

	public String getGHICHU() {
		return GHICHU;
	}

	public void setGHICHU(String gHICHU) {
		GHICHU = gHICHU;
	}

	public Collection<HOADON> getHoadons() {
		return hoadons;
	}

	public void setHoadons(Collection<HOADON> hoadons) {
		this.hoadons = hoadons;
	}
}
