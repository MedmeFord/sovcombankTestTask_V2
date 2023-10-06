package sovcombank.example.testcase.api.cleanuri.apitest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import sovcombank.example.testcase.api.cleanuri.CleanuriBaseTest;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class PositiveTest extends CleanuriBaseTest {
    @Test
    public void testShortenValidReturnShortUrl() {
        String longUrl = "http://example.com";

        String resultUrl = given()
                .contentType(ContentType.JSON)
                .formParam("url", longUrl)
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .path("result_url");

        assertNotNull(resultUrl);
        assertEquals(resultUrl, "https://cleanuri.com/qPWmO8");
    }

    @Test
    public void testShortenUrlFromFile() {
        ArrayList<String> urls = readUrlFromFile();

        for (String url: urls) {
            String resultUrl = given()
                    .contentType(ContentType.URLENC)
                    .formParam("url", url)
                    .when()
                    .post("https://cleanuri.com/api/v1/shorten")
                    .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .log().all()
                    .extract()
                    .path("result_url");

            assertNotNull(resultUrl);
            assertTrue(resultUrl.length() > 0);
        }
    }
}
