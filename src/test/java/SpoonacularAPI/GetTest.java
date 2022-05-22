package SpoonacularAPI;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetTest {

    private final String apiKey = "6ed2c561862f4fd39f4131cc0efca006";


    @Test
    void getRecipeOfPizzaWithBodyChecksAfterRequestPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pizza")
                .queryParam("excludeCuisine", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pizza")
                .queryParam("excludeCuisine", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(4));

    }

    @Test
    void getRecipeOfPastaWithBodyChecksAfterRequestPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pasta")
                .queryParam("diet", "Pescetarian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "pasta")
                .queryParam("diet", "Pescetarian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(29));

    }

    @Test
    void getRecipeOfLasagnaWithBodyChecksAfterRequestPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "lasagna")
                .queryParam("maxCalories", "350")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "lasagna")
                .queryParam("maxCalories", "350")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(4));

    }

    @Test
    void getRecipeOfCaesarSaladWithBodyChecksAfterRequestPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "caesar salad")
                .queryParam("diet", "Gluten Free")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "caesar salad")
                .queryParam("diet", "Gluten Free")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(1));

    }

    @Test
    void getRecipeOfSushiWithBodyChecksAfterRequestPositiveTest() {
        given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "sushi")
                .queryParam("cuisine", "Japanese")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200);

        JsonPath response = given()
                .queryParam("apiKey", apiKey)
                .queryParam("query", "sushi")
                .queryParam("cuisine", "Japanese")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(2));

    }

}
