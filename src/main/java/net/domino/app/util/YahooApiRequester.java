package net.domino.app.util;

import net.domino.app.exception.ApiRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YahooApiRequester {

    public ResponseEntity<String> request(final String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ApiRequestException();
        }

        return response;
    }
}
