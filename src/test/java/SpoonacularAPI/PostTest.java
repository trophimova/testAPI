package SpoonacularAPI;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostTest extends AbstractTest{

    @Test
    void classifyCuisinePizzaTest() {
        given().spec(requestSpecification)
                .queryParam("title", "Pizza")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("title", "Sushi")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("title", "Lasagna")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("title", "caesar salad")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("title", "Chinese Bbq Pork Ribs")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
