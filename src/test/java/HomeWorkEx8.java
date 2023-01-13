import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeWorkEx8 {
    @Test
    public void longRedirect() {

        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        //создаем задачу
        String token = response.get("token");
        int seconds = response.get("seconds");
        System.out.println("token : " + token + "\n" + "seconds : " + seconds);



    }
}
