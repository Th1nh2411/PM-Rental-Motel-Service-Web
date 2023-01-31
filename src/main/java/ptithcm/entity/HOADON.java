package ptithcm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HOADON")
public class HOADON {
	@Id @GeneratedValue
	private String MAHOADON;
	
	@ManyToOne
    @JoinColumn(name="MAHOPDONG")
    private HOPDONG hopdong;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date NGAYLAPHD;
	private String HTTT;
	private Integer TIENDICHVU;
	private Integer TIENPHONG;
	private Integer TONGTIEN;
	private Boolean TRANGTHAI;
	public String getMAHOADON() {
		return MAHOADON;
	}
	public void setMAHOADON(String mAHOADON) {
		MAHOADON = mAHOADON;
	}
	public HOPDONG getHopdong() {
		return hopdong;
	}
	public void setHopdong(HOPDONG hopdong) {
		this.hopdong = hopdong;
	}
	public Date getNGAYLAPHD() {
		return NGAYLAPHD;
	}
	public void setNGAYLAPHD(Date nGAYLAPHD) {
		NGAYLAPHD = nGAYLAPHD;
	}
	public String getHTTT() {
		return HTTT;
	}
	public void setHTTT(String hTTT) {
		HTTT = hTTT;
	}

	public Integer getTONGTIEN() {
		return TONGTIEN;
	}
	public void setTONGTIEN(Integer tONGTIEN) {
		TONGTIEN = tONGTIEN;
	}
	public Boolean getTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(Boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public Integer getTIENDICHVU() {
		return TIENDICHVU;
	}
	public void setTIENDICHVU(Integer tIENDICHVU) {
		TIENDICHVU = tIENDICHVU;
	}
	public Integer getTIENPHONG() {
		return TIENPHONG;
	}
	public void setTIENPHONG(Integer tIENPHONG) {
		TIENPHONG = tIENPHONG;
	}
}
