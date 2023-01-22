import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitExample {
    @Test
    public void testRestAssuredOk(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/map")
                .andReturn();
//        assertTrue(response.statusCode()==201,"Unexpected status code");
        assertEquals(200,response.statusCode(),"Unexpected status code");
    }
    @Test
    public void testRestAssuredFail(){
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/map2")
                .andReturn();
//        assertTrue(response.statusCode()==201,"Unexpected status code");
        assertEquals(200,response.statusCode(),"Unexpected status code");
    }
}
