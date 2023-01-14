import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class HomeWorkEx8 {
    @Test
    public void longRedirect() throws InterruptedException {

        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        //создаем задачу
        String token = response.get("token");
        int seconds = response.get("seconds");
        System.out.println("token : " + token + "\n" + "seconds : " + seconds);
        //Закидываем сюда токен в квери парамс
        HashMap<String, String> params = new HashMap<>();
        params.put("token", token);

        JsonPath responseOne = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        //получаем текущий результат
        String status = responseOne.get("status");
        System.out.println("status : " + status);
        //ждем ,передаем в параметры слип из ответа
        Thread.sleep(seconds * 1000);

        JsonPath responseTwo = RestAssured
                .given()
                .queryParams(params)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        //результат
        String result = responseTwo.get("result");
        String statusAfter = responseTwo.get("status");
        System.out.println("result = " + result + "\n" + "status = " + statusAfter);
    }
}
