package dbcar.main.java.com.dbshindong.dbcar.common.exception;

public class RepositoryException extends RuntimeException {
	public RepositoryException(String message, Exception e) {
		super(message, e);
	}

	public RepositoryException(String message) {
		super(message);
	}
}
