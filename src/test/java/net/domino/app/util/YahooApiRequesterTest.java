package net.domino.app.util;

import net.domino.app.exception.YahooApiRequestException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class YahooApiRequesterTest {

    private final YahooUrlGenerator yahooUrlGenerator = new YahooUrlGenerator();

    @Test
    void 야후_API_호출_정상응답_테스트() {
        String url = yahooUrlGenerator.generate("005930");

        YahooApiRequester yahooApiRequester = new YahooApiRequester();
        ResponseEntity<String> response = yahooApiRequester.request(url);

        HttpStatus responseStatusCode = response.getStatusCode();
        Assertions.assertThat(responseStatusCode).isEqualTo(HttpStatus.OK);
    }

    @Test
    void 야후_API_호출시_잘못된_경로로_호출하면_예외처리() {
        String wrongUrl = yahooUrlGenerator.generate("WRONG_REQUEST");

        YahooApiRequester yahooApiRequester = new YahooApiRequester();

        Assertions.assertThatThrownBy(() -> yahooApiRequester.request(wrongUrl))
            .isInstanceOf(YahooApiRequestException.class)
            .hasMessageContaining(wrongUrl);
    }
}
