package net.domino.app.yahoo.exception;

public class YahooApiRequestException extends RuntimeException{

    public YahooApiRequestException(final String wrongUrl) {
        super(wrongUrl);
    }

}
