package net.domino.app.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockPriceResponse {

    private int open;
    private int high;
    private int low;
    private int close;
    private int volume;
    private LocalDateTime koreanTime;

}
