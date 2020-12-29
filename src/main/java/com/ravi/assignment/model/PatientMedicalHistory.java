package com.ravi.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="PatientMedicalHistory")
@EntityListeners(AuditingEntityListener.class)
public class PatientMedicalHistory {
	@Id
	@GeneratedValue
	@Column(name="patMedId")
	long patMedId;
	
	@Column(name="SSN")
	String SSN;
	@Column(name="height")
	double height;
	@Column(name="weight")
	double weight;
	@Column(name="allergies")
	String allergies;
	@Column(name="bloodPressure")
	String bloodPressure;
	@Column(name="pulseRate")
	String pulseRate;
	@Column(name="affectedOrgan")
	String affectedOrgan;
	@ManyToOne
    @JoinColumn(name="patientId", nullable=false)
	PatientDemographic patientDetails;
	
	public PatientMedicalHistory() {
		
	}
	public PatientMedicalHistory(String sSN, double height, double weight, String allergies, String bloodPressure,
			String pulseRate, String affectedOrgan) {
		super();
		SSN = sSN;
		this.height = height;
		this.weight = weight;
		this.allergies = allergies;
		this.bloodPressure = bloodPressure;
		this.pulseRate = pulseRate;
		this.affectedOrgan = affectedOrgan;
	}
	public long getPatMedId() {
		return patMedId;
	}
	public void setPatMedId(long patMedId) {
		this.patMedId = patMedId;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getPulseRate() {
		return pulseRate;
	}
	public void setPulseRate(String pulseRate) {
		this.pulseRate = pulseRate;
	}
	public String getAffectedOrgan() {
		return affectedOrgan;
	}
	public void setAffectedOrgan(String affectedOrgan) {
		this.affectedOrgan = affectedOrgan;
	}
	public PatientDemographic getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(PatientDemographic patientDetails) {
		this.patientDetails = patientDetails;
	}
	@Override
	public String toString() {
		return "PatientMedicalHistory [patMedId=" + patMedId + ", SSN=" + SSN + ", height=" + height + ", weight="
				+ weight + ", allergies=" + allergies + ", bloodPressure=" + bloodPressure + ", pulseRate=" + pulseRate
				+ ", affectedOrgan=" + affectedOrgan + ", patientDetails=" + patientDetails + "]";
	}
	
	
}
