package ptithcm.entity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PHONG")
public class PHONG {
	@Id @GeneratedValue
	private String MAPHONG;
	
	@ManyToOne
	@JoinColumn(name="MALOAIPHONG")
	private LOAIPHONG loaiphong;
	
	@OneToMany(mappedBy="phong", fetch=FetchType.EAGER)
	private Collection<SUDUNGDV> sudungdvs;
	
	@OneToMany(mappedBy="phong", fetch=FetchType.EAGER)
	private Collection<HOPDONG> hopdongs;
	
	private Boolean TRANGTHAI;
	private Integer SONGUOIHIENTAI;
	public String getMAPHONG() {
		return MAPHONG;
	}
	public void setMAPHONG(String mAPHONG) {
		MAPHONG = mAPHONG;
	}
	public LOAIPHONG getLoaiphong() {
		return loaiphong;
	}
	public void setLoaiphong(LOAIPHONG loaiphong) {
		this.loaiphong = loaiphong;
	}
	public Collection<SUDUNGDV> getSudungdvs() {
		return sudungdvs;
	}
	public void setSudungdvs(Collection<SUDUNGDV> sudungdvs) {
		this.sudungdvs = sudungdvs;
	}
	public Collection<HOPDONG> getHopdongs() {
		return hopdongs;
	}
	public void setHopdongs(Collection<HOPDONG> hopdongs) {
		this.hopdongs = hopdongs;
	}
	public Boolean getTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(Boolean tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public Integer getSONGUOIHIENTAI() {
		return SONGUOIHIENTAI;
	}
	public void setSONGUOIHIENTAI(Integer sONGUOIHIENTAI) {
		SONGUOIHIENTAI = sONGUOIHIENTAI;
	}
}
