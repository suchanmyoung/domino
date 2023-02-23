package net.domino.app.util;

import lombok.RequiredArgsConstructor;
import net.domino.app.exception.YahooApiRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class YahooApiRequester {

    private final RestTemplate restTemplate;

    public ResponseEntity<String> request(final String url) {
        try {
            return restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException exception) {
            throw new YahooApiRequestException(url);
        }
    }

}
