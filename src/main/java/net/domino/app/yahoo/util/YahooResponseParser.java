package net.domino.app.yahoo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.domino.app.stock.domain.StockPrice;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class YahooResponseParser {

    private final ObjectMapper objectMapper;

    public List<StockPrice> getStockPrice(final String json) {
        JsonNode jsonNode = readJsonTree(json);

        JsonNode timestamp = jsonNode.findPath("timestamp");
        JsonNode open = jsonNode.findPath("open");
        JsonNode high = jsonNode.findPath("high");
        JsonNode low = jsonNode.findPath("low");
        JsonNode close = jsonNode.findPath("close");
        JsonNode volume = jsonNode.findPath("volume");

        return IntStream.range(0, timestamp.size())
            .mapToObj(index -> StockPrice.builder()
                .open(getIndexValueAsInt(open, index))
                .high(getIndexValueAsInt(high, index))
                .low(getIndexValueAsInt(low, index))
                .close(getIndexValueAsInt(close, index))
                .volume(getIndexValueAsInt(volume, index))
                .koreaTime(toKoreaTime(timestamp.get(index).asText()))
                .build()
            )
            .collect(Collectors.toList());
    }

    private JsonNode readJsonTree(final String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Errors!", jsonProcessingException);
        }

        return null;
    }

    private int getIndexValueAsInt(JsonNode node, int index) {
        return node.get(index).asInt();
    }

    private LocalDateTime toKoreaTime(String timeStamp) {
        return LocalDateTime.ofInstant(
            Instant.ofEpochSecond(Long.parseLong(timeStamp)),
            TimeZone.getTimeZone("Asia/Seoul").toZoneId());
    }

}
