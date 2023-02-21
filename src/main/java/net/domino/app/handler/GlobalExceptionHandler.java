package net.domino.app.handler;

import net.domino.app.error.ErrorResponse;
import net.domino.app.exception.YahooApiRequestException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ErrorResponse handleYahooApiRequestException(YahooApiRequestException exception) {
        return ErrorResponse.builder()
            .status(404)
            .message("야후 API 호출에 실패하였습니다.")
            .wrongUrl(exception.getMessage())
            .build();
    }
}
