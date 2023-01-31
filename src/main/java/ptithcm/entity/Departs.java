package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departs")
public class Departs {
     @Id 
     private String Id;
     private String Name;
     @OneToMany(mappedBy="depart", fetch=FetchType.EAGER)
	 private Collection<Staffs> staffs;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Collection<Staffs> getStaffs() {
		return staffs;
	}
	public void setStaffs(Collection<Staffs> staffs) {
		this.staffs = staffs;
	}
     

}