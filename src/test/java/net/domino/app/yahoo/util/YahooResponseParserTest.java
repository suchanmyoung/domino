package net.domino.app.yahoo.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.domino.app.stock.domain.StockPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

class YahooResponseParserTest {

    private YahooResponseParser yahooResponseParser;
    private YahooApiRequester yahooApiRequester;

    @BeforeEach
    void setup() {
        yahooResponseParser = new YahooResponseParser(new ObjectMapper());
        yahooApiRequester = new YahooApiRequester(new RestTemplate());
    }

    @Test
    void 야후_API_응답결과로_종목의_5일치_시세데이터_객체생성() {
        //given
        String requestUrl = "https://query1.finance.yahoo.com/v8/finance/chart/005930.KS?interval=1d&range=5d";
        ResponseEntity<String> response = yahooApiRequester.request(requestUrl);

        //when
        List<StockPrice> stockPrice = yahooResponseParser.getStockPrice(response.getBody());

        //then
        Assertions.assertThat(stockPrice.size()).isEqualTo(5);
    }
}
