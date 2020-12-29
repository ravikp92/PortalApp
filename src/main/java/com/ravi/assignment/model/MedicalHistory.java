package com.ravi.assignment.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity

@EntityListeners(AuditingEntityListener.class)
public class MedicalHistory extends Auditable<String> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer historyID;
  
  @NotNull(message = "Please enter height")
  private Double height;
  
  @NotNull(message = "Please enter weight")
  private Double weight;
  
  private String allergies;
  
  @NotNull(message = "Please enter Blood Pressure")
  private Integer bloodPressure;
  
  @NotNull(message = "Please enter Pulse Rate")
  private Integer pulseRate;
  
  private String affectedOrgan;
  
  public Integer getHistoryID() {
    return this.historyID;
  }
  
  public void setHistoryID(Integer historyID) {
    this.historyID = historyID;
  }
  
  public Double getHeight() {
    return this.height;
  }
  
  public void setHeight(Double height) {
    this.height = height;
  }
  
  public Double getWeight() {
    return this.weight;
  }
  
  public void setWeight(Double weight) {
    this.weight = weight;
  }
  
  public String getAllergies() {
    return this.allergies;
  }
  
  public void setAllergies(String allergies) {
    this.allergies = allergies;
  }
  
  public Integer getBloodPressure() {
    return this.bloodPressure;
  }
  
  public void setBloodPressure(Integer bloodPressure) {
    this.bloodPressure = bloodPressure;
  }
  
  public Integer getPulseRate() {
    return this.pulseRate;
  }
  
  public void setPulseRate(Integer pulseRate) {
    this.pulseRate = pulseRate;
  }
  
  public String getAffectedOrgan() {
    return this.affectedOrgan;
  }
  
  public void setAffectedOrgan(String affectedOrgan) {
    this.affectedOrgan = affectedOrgan;
  }
  
  public MedicalHistory(@NotNull(message = "Please enter height") Double height, @NotNull(message = "Please enter weight") Double weight, String allergies, @NotNull(message = "Please enter Blood Pressure") Integer bloodPressure, @NotNull(message = "Please enter Pulse Rate") Integer pulseRate, String affectedOrgan) {
    this.height = height;
    this.weight = weight;
    this.allergies = allergies;
    this.bloodPressure = bloodPressure;
    this.pulseRate = pulseRate;
    this.affectedOrgan = affectedOrgan;
  }
  
  public MedicalHistory() {}
  
  public String toString() {
    return "MedicalHistory [historyID=" + this.historyID + ", height=" + this.height + ", weight=" + this.weight + ", allergies=" + 
      this.allergies + ", bloodPressure=" + this.bloodPressure + ", pulseRate=" + this.pulseRate + ", affectedOrgan=" + 
      this.affectedOrgan + "]";
  }
}
