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
@Table(name="Staffs")
public class Staffs {
     @Id
     private String Id;
     private String Name;
     private Boolean Gender;
     @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern="MM/dd/yyyy")
     private Date Birthday;
     private String Email;
     private String Phone;
     private Float Salary;
     private String Notes;
     @ManyToOne
	 @JoinColumn(name="DepartId")
     private Departs depart;

     @OneToMany(mappedBy="staff", fetch=FetchType.EAGER)
	 private Collection<Records> records;

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

	public Boolean getGender() {
		return Gender;
	}

	public void setGender(Boolean gender) {
		Gender = gender;
	}

	public Date getBirthday() {
		return Birthday;
	}

	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Float getSalary() {
		return Salary;
	}

	public void setSalary(Float salary) {
		Salary = salary;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	public Departs getDepart() {
		return depart;
	}

	public void setDepart(Departs depart) {
		this.depart = depart;
	}

	public Collection<Records> getRecords() {
		return records;
	}

	public void setRecords(Collection<Records> records) {
		this.records = records;
	}
     
     
	
	
};