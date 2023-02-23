package net.domino.app.stock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import net.domino.app.stock.domain.StockPrice;
import net.domino.app.stock.service.StockPriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "주식 종목 조회 API")
@RequiredArgsConstructor
@RestController
public class StockPriceController {

    private final StockPriceService stockPriceService;

    @ApiOperation(value = "주식 종목에 대한 5일 간의 시세 데이터를 조회합니다.")
    @GetMapping("/stock/{stockCode}")
    public List<StockPrice> getFiveDaysStockPrice(@PathVariable final String stockCode) {
        return stockPriceService.getFiveDaysStockPrice(stockCode);
    }

}
