
package ptithcm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

class SDDVPK implements Serializable {
    private Date NGAYBATDAUSDDV;
    private DICHVU dichvu;
    private PHONG phong;
	public SDDVPK(Date nGAYBATDAUSDDV, DICHVU dichvu, PHONG phong) {
		super();
		NGAYBATDAUSDDV = nGAYBATDAUSDDV;
		this.dichvu = dichvu;
		this.phong = phong;
	}
	public SDDVPK() {
		super();
	}
}

@Entity
@IdClass(SDDVPK.class)
@Table(name = "SUDUNGDV")
public class SUDUNGDV {

	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date NGAYBATDAUSDDV;
	
	@Id
	@ManyToOne
	@JoinColumn(name="MADV")
	private DICHVU dichvu;
	
	@Id
	@ManyToOne
	@JoinColumn(name="MAPHONG")
	private PHONG phong;
	private Integer SOLUONG;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date NGAYKETTHUCSDDV;

	public Date getNGAYBATDAUSDDV() {
		return NGAYBATDAUSDDV;
	}

	public void setNGAYBATDAUSDDV(Date nGAYBATDAUSDDV) {
		NGAYBATDAUSDDV = nGAYBATDAUSDDV;
	}

	public Integer getSOLUONG() {
		return SOLUONG;
	}

	public void setSOLUONG(Integer sOLUONG) {
		SOLUONG = sOLUONG;
	}

	public Date getNGAYKETTHUCSDDV() {
		return NGAYKETTHUCSDDV;
	}

	public void setNGAYKETTHUCSDDV(Date nGAYKETTHUCSDDV) {
		NGAYKETTHUCSDDV = nGAYKETTHUCSDDV;
	}

	public DICHVU getDichvu() {
		return dichvu;
	}

	public void setDichvu(DICHVU dichvu) {
		this.dichvu = dichvu;
	}

	public PHONG getPhong() {
		return phong;
	}

	public void setPhong(PHONG phong) {
		this.phong = phong;
	}
	
	
}
