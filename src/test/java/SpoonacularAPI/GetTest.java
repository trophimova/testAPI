package SpoonacularAPI;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class GetTest extends AbstractTest{

    @Test
    void getRecipeOfPizzaWithBodyChecksAfterRequestPositiveTest() {
        given().spec(requestSpecification)
                .queryParam("query", "pizza")
                .queryParam("excludeCuisine", "Italian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("query", "pasta")
                .queryParam("diet", "Pescetarian")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("query", "lasagna")
                .queryParam("maxCalories", "350")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("query", "caesar salad")
                .queryParam("diet", "Gluten Free")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
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
        given().spec(requestSpecification)
                .queryParam("query", "sushi")
                .queryParam("cuisine", "Japanese")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .spec(responseSpecification);

        JsonPath response = given().spec(requestSpecification)
                .queryParam("query", "sushi")
                .queryParam("cuisine", "Japanese")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(2));

    }

}
