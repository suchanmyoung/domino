package net.domino.app.handler;

import net.domino.app.yahoo.error.YahooErrorResponse;
import net.domino.app.yahoo.exception.YahooApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public YahooErrorResponse handleYahooApiRequestException(YahooApiRequestException exception) {
        return YahooErrorResponse.builder()
            .status(404)
            .message("야후 API 호출에 실패하였습니다.")
            .wrongUrl(exception.getMessage())
            .build();
    }

}
