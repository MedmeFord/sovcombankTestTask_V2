package sovcombank.example.testcase.api.cleanuri.apitest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class NegativeTest {
    // #TODO проверить на пустой запрос }
    // #TODO проверить на querry выражения
    // #TODO проверить проверить со сломанной ссылкой }

    @Test
    public void checkBreakURLRequestTest() {
        String error = given()
                .contentType(ContentType.URLENC)
                .formParam("url", "https:/google.com" )
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log().all()
                .extract()
                .path("error");

        assertNotNull(error);
        assertEquals(error, "API Error: URL is invalid (check #1)");
    }

    @Test
    public void checkEmptyRequestTest() {
        String error = given()
                .contentType(ContentType.URLENC)
                .formParam("url", "" )
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log().all()
                .extract()
                .path("error");

        assertNotNull(error);
        assertEquals(error, "API Error: After sanitization URL is empty");
    }

    /* в документаций API в блоке 'Примечания' сказано что в url не должны содержаться зарезервировнные знаки:
      - к примеру '?'
      и не имеется документаций какой код ошибки должен прийти.
     Воспринял это как баг и проверяю на 400 ошибку
    */
    @Test
    public void checkQuerryExpressionTest() {
        String error = given()
                .contentType(ContentType.URLENC)
                .formParam("url", "https://www.mvideo.ru/shops/store-list?from=header" )
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log().all()
                .extract()
                .path("error");

        assertNotNull(error);
    }

    // вернул ошибку 400 считаю это багом
    @Test
    public void checkSpaceInUrlTest() {
        String error = given()
                .contentType(ContentType.URLENC)
                .formParam("url", "https://www.mvideo.ru    /+shops/store-list?from=header" )
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .log().all()
                .extract()
                .path("error");

        assertNotNull(error);
    }


}
