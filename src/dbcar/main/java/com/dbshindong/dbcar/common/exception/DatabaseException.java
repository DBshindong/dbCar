package dbcar.main.java.com.dbshindong.dbcar.common.exception;

public class DatabaseException extends RuntimeException {
	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(String message, Exception e) {
		super(message, e);
	}
}
