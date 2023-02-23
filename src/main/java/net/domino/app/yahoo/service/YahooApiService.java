package net.domino.app.yahoo.service;

import lombok.RequiredArgsConstructor;
import net.domino.app.stock.domain.StockPrice;
import net.domino.app.yahoo.util.YahooApiRequester;
import net.domino.app.yahoo.util.YahooResponseParser;
import net.domino.app.yahoo.util.YahooUrlGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class YahooApiService {

    private final YahooUrlGenerator yahooUrlGenerator;
    private final YahooApiRequester yahooApiRequester;
    private final YahooResponseParser yahooResponseParser;

    public List<StockPrice> fetchFiveDaysStockPrice(final String stockCode) {
        String url = yahooUrlGenerator.generate(stockCode);
        ResponseEntity<String> response = yahooApiRequester.request(url);
        return yahooResponseParser.getStockPrice(response.getBody());
    }
}
