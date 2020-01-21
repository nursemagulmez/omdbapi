package ApiTest;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher.*;
import java.util.List;
import static org.hamcrest.Matchers.*;

public class helper {
    public String bySearch(String movieName, String apiKey, String movieTitle) {
        String imdbID = "";
        RestAssured.baseURI = "http://www.omdbapi.com/";
        RequestSpecification request = RestAssured
                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));

        Response response = request
                .param("apiKey",apiKey)
                .param("s",movieName)
                .when()
                .get()
                .then()
                .body("Search.Title",notNullValue())
                .body("Search.Year",notNullValue())
                .body("Search.Released",notNullValue())
                .statusCode(200)
                .extract().response();

        List<movie> movies = response.jsonPath().getList("Search", movie.class);
        for (movie movie : movies){
            if(movie.Title.equals(movieTitle)){
                imdbID = movie.imdbID;
            }
        }
        return imdbID;
    }

    public String byIDorTitle(String movieID, String apiKey) {
        RestAssured.baseURI = "http://www.omdbapi.com/";
        RequestSpecification request = RestAssured
                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));

        Response response = request
                .param("apiKey",apiKey)
                .param("i",movieID)
                .when()
                .get()
                .then()
                .body("Title",notNullValue())
                .body("Year",notNullValue())
                .body("Released",notNullValue())
                .statusCode(200)
                .extract().response();

        ResponseBody responseBody = response.getBody();

        return responseBody.asString();
    }

}
