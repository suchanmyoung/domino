package net.domino.app.yahoo.util;

import net.domino.app.yahoo.exception.YahooApiRequestException;
import net.domino.app.yahoo.util.YahooApiRequester;
import net.domino.app.yahoo.util.YahooUrlGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class YahooApiRequesterTest {

    private final YahooUrlGenerator yahooUrlGenerator = new YahooUrlGenerator();
    private final YahooApiRequester yahooApiRequester = new YahooApiRequester(new RestTemplate());
    @Test
    void 야후_API_호출_정상응답_테스트() {
        String url = yahooUrlGenerator.generate("005930");

        ResponseEntity<String> response = yahooApiRequester.request(url);

        HttpStatus responseStatusCode = response.getStatusCode();
        Assertions.assertThat(responseStatusCode).isEqualTo(HttpStatus.OK);
    }

    @Test
    void 야후_API_호출시_잘못된_경로로_호출하면_예외처리() {
        String wrongUrl = yahooUrlGenerator.generate("WRONG_REQUEST");

        Assertions.assertThatThrownBy(() -> yahooApiRequester.request(wrongUrl))
            .isInstanceOf(YahooApiRequestException.class)
            .hasMessageContaining(wrongUrl);
    }

}
