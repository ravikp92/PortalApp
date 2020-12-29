package com.ravi.assignment.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="PatientDemographic")
@EntityListeners(AuditingEntityListener.class)
public class PatientDemographic {

	@Id
	@GeneratedValue
    @Column(name="patientId")
	long patientId;

	@Column(name="firstName")
	String firstName;
	
	@Column(name="lastName")
	String lastName;
	@Column(name="address")
	String address;
	@Column(name="email")
	String email;
	@Column(name="mobNumber")
	Integer mobNumber;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="telePhone")
	Integer telePhone;
	@Column(name="gender")
	String gender;
	@Column(name="dob")
	LocalDate dob;
	@Column(name="SSN")
	String SSN;
	
	@OneToMany(mappedBy="patientDetails")
	private Set<PatientMedicalHistory> patientMedHistory;
	
	public PatientDemographic() {
		
	}
	
	public PatientDemographic(String firstName, String lastName, String address, String email, Integer mobNumber,
			String city, String state, Integer telePhone, String gender, LocalDate dob, String sSN,
			Set<PatientMedicalHistory> patientMedHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.mobNumber = mobNumber;
		this.city = city;
		this.state = state;
		this.telePhone = telePhone;
		this.gender = gender;
		this.dob = dob;
		SSN = sSN;
		this.patientMedHistory = patientMedHistory;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(Integer mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(Integer telePhone) {
		this.telePhone = telePhone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public Set<PatientMedicalHistory> getPatientMedHistory() {
		return patientMedHistory;
	}

	public void setPatientMedHistory(Set<PatientMedicalHistory> patientMedHistory) {
		this.patientMedHistory = patientMedHistory;
	}

	@Override
	public String toString() {
		return "PatientDemographic [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", email=" + email + ", mobNumber=" + mobNumber + ", city=" + city
				+ ", state=" + state + ", telePhone=" + telePhone + ", gender=" + gender + ", dob=" + dob + ", SSN="
				+ SSN + ", patientMedHistory=" + patientMedHistory + "]";
	}
	
	
	
	
}
