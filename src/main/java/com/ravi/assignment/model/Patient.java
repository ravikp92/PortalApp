package com.ravi.assignment.model;

import com.ravi.assignment.validator.Gender;
import com.ravi.assignment.validator.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer patientID;
  
  @Size(min = 5, message = "First Name should be atleast 5 characters")
  private String firstName;
  
  @Size(min = 5, message = "Last Name should be atleast 5 characters")
  private String lastName;
  
  @Size(min = 5, message = "Address should be atleast 5 characters")
  private String address;
  
  @Email(message = "Please provide a valid email address")
  private String email;
  
  @Phone(message = "Please provide a vaild Phone Number")
  private String phoneNumber;
  
  @Size(min = 3, message = "City should be atleast 3 characters")
  private String city;
  
  @Size(min = 3, message = "State should be atleast 3 characters")
  private String state;
  
  @Gender(message = "Please provide a vaild Gender: MALE | FEMALE | OTHER")
  private String gender;
  
  @NotNull(message = "Please enter an DOB")
  @Past(message = "DOB Can not be of future date")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dob;
  
  @NotNull(message = "Please enter an SSN")
  @Pattern(regexp = "^[0-9][0-9]{2}-[0-9]{2}-[0-9]{4}$", message = "SSN must use numbers in this format: XXX-YY-ZZZZ")
  private String ssn;
  
  @OneToMany(cascade = {CascadeType.ALL})
  @JoinColumn(name = "p_fk", referencedColumnName = "patientID")
  private List<MedicalHistory> medicalHistories = new ArrayList<>();
  
  public Integer getPatientID() {
    return this.patientID;
  }
  
  public void setPatientID(Integer patientID) {
    this.patientID = patientID;
  }
  
  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return this.lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getAddress() {
    return this.address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPhoneNumber() {
    return this.phoneNumber;
  }
  
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public String getCity() {
    return this.city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getState() {
    return this.state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public String getGender() {
    return this.gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  
  public Date getDob() {
    return this.dob;
  }
  
  public void setDob(Date dob) {
    this.dob = dob;
  }
  
  public String getSsn() {
    return this.ssn;
  }
  
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }
  
  public List<MedicalHistory> getMedicalHistories() {
    return this.medicalHistories;
  }
  
  public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
    this.medicalHistories = medicalHistories;
  }
  
  public Patient() {}
  
  public Patient(@Size(min = 5, message = "First Name should be atleast 5 characters") String firstName, @Size(min = 5, message = "Last Name should be atleast 5 characters") String lastName, @Size(min = 5, message = "Address should be atleast 5 characters") String address, @Email(message = "Please provide a valid email address") String email, String phoneNumber, @Size(min = 3, message = "City should be atleast 3 characters") String city, @Size(min = 3, message = "State should be atleast 3 characters") String state, String gender, @NotNull(message = "Please enter an DOB") @Past(message = "DOB Can not be of future date") @DateTimeFormat(pattern = "dd/MM/yyyy") Date dob, @NotNull(message = "Please enter an SSN") @Pattern(regexp = "^[0-9][0-9]{2}-[0-9]{2}-[0-9]{4}$", message = "SSN must use numbers in this format: XXX-YY-ZZZZ") String ssn) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.city = city;
    this.state = state;
    this.gender = gender;
    this.dob = dob;
    this.ssn = ssn;
  }
  
  public String toString() {
    return "Patient [patientID=" + this.patientID + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", address=" + 
      this.address + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", city=" + this.city + ", state=" + this.state + 
      ", gender=" + this.gender + ", dob=" + this.dob + ", ssn=" + this.ssn + "]";
  }
}
