package dbcar.main.java.com.dbshindong.dbcar.domain.company.exception;

import dbcar.main.java.com.dbshindong.dbcar.common.exception.ConstraintViolationException;

public class InvalidCampingCarException extends ConstraintViolationException {

	public InvalidCampingCarException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public InvalidCampingCarException(String message, Exception e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}

}
