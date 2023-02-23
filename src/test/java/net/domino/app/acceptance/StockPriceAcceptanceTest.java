package net.domino.app.acceptance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class StockPriceAcceptanceTest extends AcceptanceTest {

    @ParameterizedTest
    @ValueSource(strings = {"005930", "035720", "035420"})
    void 종목_데이터_조회_API_정상응답_테스트(String stockCode) {
        String path = "/stock/" + stockCode;

        when()
                .get(path)
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @ParameterizedTest
    @ValueSource(strings = {"032860", "058530", "014200"})
    void 존재하지_않는_종목코드를_조회하면_예외처리(String stockCode) {
        //given
        String path = "/stock/" + stockCode;
        String exceptionMessage = "야후 API 호출에 실패하였습니다.";
        String wrongUrl = String.format("https://query1.finance.yahoo.com/v8/finance/chart/%s.KS?interval=1d&range=5d", stockCode);

        when()
                .get(path)
                .then()
                .statusCode(404)
                .body("message", equalTo(exceptionMessage))
                .body("wrongUrl", equalTo(wrongUrl))
                .log()
                .all();
    }
}
