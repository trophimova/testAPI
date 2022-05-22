package SpoonacularAPI;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateAndDeleteTest {

    private final String apiKey = "6ed2c561862f4fd39f4131cc0efca006";

    @Test
    void MealPlanIngredientsTest() {
        String id = given()
                .queryParam("hash", "01403f920bebdc9eaad975ab4912a26d15bb7d72")
                .queryParam("apiKey", apiKey)
                .body("{\n"
                        + " \"date\": 1653217200,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/anna98/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "01403f920bebdc9eaad975ab4912a26d15bb7d72")
                .queryParam("apiKey", apiKey)
                .delete("https://api.spoonacular.com/mealplanner/anna98/items/" + id)
                .then()
                .statusCode(200);
    }

    @Test
    void MealPlanRecipeTest() {
        String id = given()
                .queryParam("hash", "01403f920bebdc9eaad975ab4912a26d15bb7d72")
                .queryParam("apiKey", apiKey)
                .body("{\n"
                        + " \"date\": 1653303600,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"id\": 1,\n"
                        + " \"servings\": 2,\n"
                        + " \"title\": \"Pasta and Seafood\",\n"
                        + " \"imageType\": \"jpg\",\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/anna98/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "01403f920bebdc9eaad975ab4912a26d15bb7d72")
                .queryParam("apiKey", apiKey)
                .delete("https://api.spoonacular.com/mealplanner/anna98/items/" + id)
                .then()
                .statusCode(200);
    }
}
