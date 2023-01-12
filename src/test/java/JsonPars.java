import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonPars {
    @Test
    public void testHelloWorld() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Ivan Nikolaenko");

        JsonPath response = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();

        String answer = response.get("answer");
        if (answer == null) {
            System.out.println("parameter not found");
        } else {
            System.out.println(answer);
        }
    }
}