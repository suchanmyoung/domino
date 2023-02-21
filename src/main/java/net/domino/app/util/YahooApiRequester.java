package net.domino.app.util;

import net.domino.app.exception.YahooApiRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class YahooApiRequester {

    public ResponseEntity<String> request(final String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException exception) {
            throw new YahooApiRequestException(url);
        }
    }
}
