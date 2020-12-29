package com.ravi.assignment.controller;


import com.ravi.assignment.exception.PatientNotFoundException;
import com.ravi.assignment.model.MedicalHistory;
import com.ravi.assignment.model.Patient;
import com.ravi.assignment.repository.PatientRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping({"/api"})
public class PatientJPAController {
  @Autowired
  private PatientRepository patientRepository;
  
  @GetMapping({"/jpa/patients"})
  public List<Patient> retrieveAllPatient() {
    return this.patientRepository.findAll();
  }
  
  @GetMapping({"/jpa/patients/{id}"})
  public Patient retrievePatient(@PathVariable Integer id) {
    Optional<Patient> patient = this.patientRepository.findById(id);
    if (!patient.isPresent())
      throw new PatientNotFoundException("Patient not found for ID - " + id); 
    return patient.get();
  }
  
  @PostMapping({"/jpa/patients"})
  public ResponseEntity<Object> createUser(@Valid @RequestBody Patient patient) {
    Patient savedPatient = (Patient)this.patientRepository.save(patient);
    URI location = null;
    location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(new Object[] { savedPatient.getPatientID() }).toUri();
    return ResponseEntity.created(location).build();
  }
  
  @DeleteMapping({"/jpa/patients/{id}"})
  public void deleteUser(@PathVariable Integer id) {
    this.patientRepository.deleteById(id);
  }
  
  @PutMapping({"/jpa/patients/"})
  public ResponseEntity<Object> updateUser(@Valid @RequestBody Patient patient) {
    Optional<Patient> optionalpatient = this.patientRepository.findById(patient.getPatientID());
    if (!optionalpatient.isPresent())
      throw new PatientNotFoundException("id - " + patient.getPatientID()); 
    Patient updatePatient = optionalpatient.get();
    updatePatient.setFirstName(patient.getFirstName());
    updatePatient.setLastName(patient.getLastName());
    updatePatient.setAddress(patient.getAddress());
    updatePatient.setEmail(patient.getEmail());
    updatePatient.setPhoneNumber(patient.getPhoneNumber());
    updatePatient.setCity(patient.getCity());
    updatePatient.setState(patient.getState());
    updatePatient.setGender(patient.getGender());
    updatePatient.setDob(patient.getDob());
    updatePatient.setSsn(patient.getSsn());
    this.patientRepository.save(updatePatient);
    return new ResponseEntity<Object>(HttpStatus.CREATED);
  }
  
  @GetMapping({"/jpa/patients/{id}/medicalhistory"})
  public List<MedicalHistory> retrieveMedicalHistory(@PathVariable Integer id) {
    Optional<Patient> patientOptional = this.patientRepository.findById(id);
    if (!patientOptional.isPresent())
      throw new PatientNotFoundException("id - " + id); 
    return ((Patient)patientOptional.get()).getMedicalHistories();
  }
  
  @PostMapping({"/jpa/patients/{id}/medicalhistory"})
  public ResponseEntity<Object> addMedicalHistory(@PathVariable Integer id, @Valid @RequestBody MedicalHistory medicalHistory) {
    Optional<Patient> patientOptional = this.patientRepository.findById(id);
    if (!patientOptional.isPresent())
      throw new PatientNotFoundException("Patient ID - " + id + " not found"); 
    Patient patient = patientOptional.get();
    patient.getMedicalHistories().add(medicalHistory);
    this.patientRepository.save(patient);
    return new ResponseEntity<Object>(HttpStatus.CREATED);
  }
}
