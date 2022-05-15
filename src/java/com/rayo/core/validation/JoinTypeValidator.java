package com.rayo.core.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class JoinTypeValidator implements ConstraintValidator<ValidJoinType, String> {

	@Override
	public void initialize(ValidJoinType constraint) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.equals("")) return true;
		
		try {
			//JoinType.valueOf(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
