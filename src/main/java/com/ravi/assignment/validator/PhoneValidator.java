package com.ravi.assignment.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
  public void initialize(Phone paramA) {}
  
  public boolean isValid(String phoneNo, ConstraintValidatorContext ctx) {
    if (phoneNo == null)
      return false; 
    if (phoneNo.matches("\\d{10}"))
      return true; 
    if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
      return true; 
    if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
      return true; 
    if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
      return true; 
    return false;
  }
}
