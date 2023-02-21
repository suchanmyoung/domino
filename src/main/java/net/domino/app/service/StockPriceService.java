package net.domino.app.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.domino.app.dto.StockPriceResponse;
import net.domino.app.util.YahooApiRequester;
import net.domino.app.util.YahooResponseParser;
import net.domino.app.util.YahooUrlGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockPriceService {

    private final YahooUrlGenerator yahooUrlGenerator;
    private final YahooApiRequester yahooApiRequester;
    private final YahooResponseParser yahooResponseParser;

    public List<StockPriceResponse> getFiveDaysStockPrice(final String stockCode) {
        String url = yahooUrlGenerator.generate(stockCode);
        ResponseEntity<String> response = yahooApiRequester.request(url);
        return yahooResponseParser.getStockPrice(response.getBody());
    }

}
