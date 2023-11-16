package co.com.uniquindio.model.exception;

public class JPAException extends RuntimeException {

    public JPAException(String detail) {
        super(detail);
    }
}