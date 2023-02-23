package net.domino.app.stock.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockPrice {

    private int open;
    private int high;
    private int low;
    private int close;
    private int volume;
    private LocalDateTime koreanTime;

}
