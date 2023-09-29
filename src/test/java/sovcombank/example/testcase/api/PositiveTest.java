package sovcombank.example.testcase.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTest {

    private final static String URL = "https://cleaner.dadata.ru/api/v1/clean/phone";
    private final static String API_KEY = "469eff5e648ecd9dcd6750163d168a01bd816714";
    private final static String SECRET_KEY = "ebf8af4291b56bf90eeb42c74fd7b94565cbfa02";
    private final static String PHONE_NUMBER = "+7 965 660-64-94";

    @Test
    public void test() {


        Response response = given()
                .contentType( "application/json")
                .accept("application/json")
                .header("Authorization", "Token " + API_KEY)
                .header("X-Secret", SECRET_KEY)
                .body("[\"" + PHONE_NUMBER + "\"]")
                .post(URL)
                .then()
                .statusCode(200)
                .extract().response();

        String actualSource = response.jsonPath().getString("[0].source");

        assertEquals(PHONE_NUMBER, actualSource);
    }

}
