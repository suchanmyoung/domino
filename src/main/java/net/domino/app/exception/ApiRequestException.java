package net.domino.app.exception;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException() {
        super("야후 API 호출이 실패했습니다.");
    }
}
