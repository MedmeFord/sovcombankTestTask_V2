package sovcombank.example.testcase.api;

import com.codeborne.selenide.SelenideElement;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseTest {



    @Test
    public void testShortenUrl_UrlWithSpaces_ReturnsError() {
        String longUrl = "http://example.com with spaces";
        given()
                .contentType(ContentType.URLENC)
                .formParam("url", longUrl)
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("error", not(isEmptyOrNullString()));
    }


}
