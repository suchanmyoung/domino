package net.domino.app.exception;

public class YahooApiRequestException extends RuntimeException{

    public YahooApiRequestException(final String wrongUrl) {
        super(wrongUrl);
    }

}
