import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeWorkEx7 {
    @Test
    public void longRedirect() {
        String url = "https://playground.learnqa.ru/api/long_redirect";
        int redirectsCount = 0;
        while (true) {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .get(url)
                    .andReturn();

            int statusCode = response.getStatusCode();
            String locationHeader = response.getHeader("Location");
            if (statusCode == 200) {
                break;
            }
            redirectsCount++;
            System.out.println("Status code = " + statusCode
                    + "\n" + "Url = " + locationHeader
                    + "\n" + "Redirects count = " + redirectsCount);

        }
    }
}
