import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TypeAndParameters {

    @Test
    public void testRestAssured() {
        Map<String, Object> body = new HashMap<>();
        body.put("param1","value1");
        body.put("param2","value2");
        Response response = RestAssured
                .given()
//                .queryParam("param1","value1")
//                .queryParam("param2","value2")
//                .body("param1=value1&param2=value2")
//                .body("{\"param1\":\"value1\",\"param2\":\"value2\"}")
                .body(body)
                .post("https://playground.learnqa.ru/api/check_type")
                .andReturn();

        response.print();
    }
}
