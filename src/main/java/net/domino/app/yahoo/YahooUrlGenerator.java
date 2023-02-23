package net.domino.app.yahoo;

import org.springframework.stereotype.Component;

@Component
public class YahooUrlGenerator {

    public String generate(final String stockCode) {
        return String.
            format("https://query1.finance.yahoo.com/v8/finance/chart/%s.KS?interval=1d&range=5d", stockCode);
    }

}
