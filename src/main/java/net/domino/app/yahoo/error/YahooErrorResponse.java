package net.domino.app.yahoo.error;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class YahooErrorResponse {

    private int status;
    private String wrongUrl;
    private String message;

}
