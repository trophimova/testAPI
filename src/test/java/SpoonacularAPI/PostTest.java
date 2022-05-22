package SpoonacularAPI;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostTest {

    private final String apiKey = "6ed2c561862f4fd39f4131cc0efca006";

    @Test
    void classifyCuisinePizzaTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Pizza")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Pizza")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .body()
                .jsonPath();
        double confidence = 0.95;
        float conf = (float)confidence;
        assertThat(response.get("confidence"), equalTo(conf));
        assertThat(response.get("cuisine"), equalTo("Mediterranean"));
    }

    @Test
    void classifyCuisineSushiTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Sushi")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Sushi")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .body()
                .jsonPath();
        double confidence = 0.85;
        float conf = (float)confidence;
        assertThat(response.get("confidence"), equalTo(conf));
        assertThat(response.get("cuisine"), equalTo("Japanese"));
    }

    @Test
    void classifyCuisineLasagnaTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Lasagna")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Lasagna")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .body()
                .jsonPath();
        double confidence = 0.95;
        float conf = (float)confidence;
        assertThat(response.get("confidence"), equalTo(conf));
        assertThat(response.get("cuisine"), equalTo("Mediterranean"));
    }

    @Test
    void classifyCuisineCaesarSaladTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "caesar salad")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "caesar salad")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .body()
                .jsonPath();
        double confidence = 0.95;
        float conf = (float)confidence;
        assertThat(response.get("confidence"), equalTo(conf));
        assertThat(response.get("cuisine"), equalTo("American"));
    }

    @Test
    void classifyCuisineChineseBbqPorkRibsTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Chinese Bbq Pork Ribs")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("title", "Chinese Bbq Pork Ribs")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .body()
                .jsonPath();
        double confidence = 0.85;
        float conf = (float)confidence;
        assertThat(response.get("confidence"), equalTo(conf));
        assertThat(response.get("cuisine"), equalTo("Chinese"));
    }
}
