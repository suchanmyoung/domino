package net.domino.app.yahoo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class YahooUrlGeneratorTest {

    @Test
    void 야후_API_호출URL_생성_정상동작_테스트() {
        YahooUrlGenerator yahooUrlGenerator = new YahooUrlGenerator();

        String generatedUrl = yahooUrlGenerator.generate("005930");
        String rightUrl = "https://query1.finance.yahoo.com/v8/finance/chart/005930.KS?interval=1d&range=5d";

        Assertions.assertThat(generatedUrl).isEqualTo(rightUrl);
    }

}
