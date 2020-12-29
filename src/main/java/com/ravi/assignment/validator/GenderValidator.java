package com.ravi.assignment.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {
  public void initialize(Gender paramA) {}
  
  public boolean isValid(String gender, ConstraintValidatorContext ctx) {
    if (gender == null)
      return false; 
    if (gender.equals("MALE") || gender.equals("male") || gender.equals("Male") || gender.equals("FEMALE") || gender.equals("Female") || gender.equals("female") || gender.equals("OTHER") || gender.equals("Other") || gender.equals("other"))
      return true; 
    return false;
  }
}
