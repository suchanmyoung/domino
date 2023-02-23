package net.domino.app.stock.service;

import lombok.RequiredArgsConstructor;
import net.domino.app.stock.domain.StockPrice;
import net.domino.app.yahoo.service.YahooApiService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StockPriceService {

    private final YahooApiService yahooApiService;

    public List<StockPrice> getFiveDaysStockPrice(final String stockCode) {
        return yahooApiService.fetchFiveDaysStockPrice(stockCode);
    }

}
