package net.domino.app.error;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private int status;
    private String wrongUrl;
    private String message;

}
