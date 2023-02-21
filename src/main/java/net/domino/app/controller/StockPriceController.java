package net.domino.app.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.domino.app.dto.StockPriceResponse;
import net.domino.app.service.StockPriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StockPriceController {

    private final StockPriceService stockPriceService;

    @GetMapping("/stock/{stockCode}")
    public List<StockPriceResponse> getFiveDaysStockPrice(@PathVariable final String stockCode) {
        return stockPriceService.getFiveDaysStockPrice(stockCode);
    }

}
