package SpoonacularAPI;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingListTest extends AbstractTest{

    @Test
    void GetShoppingListTest() {
        given().spec(requestSpecification)
                .queryParam("hash", "01403f920bebdc9eaad975ab4912a26d15bb7d72")
                .when()
                .get("https://api.spoonacular.com/mealplanner/anna98/shopping-list")
                .then()
                .spec(responseSpecification);


    }

    @Test
    void AddToShoppingListTest() {
         String id = given().spec(requestSpecification)
                .queryParam("hash", "01403f920bebdc9eaad975ab4912a26d15bb7d72")
                .body("{\n"
                        + " \"item\": \"1 package baking powder\",\n"
                        + " \"aisle\": \"Baking\",\n"
                        + " \"parse\": true\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/anna98/shopping-list/items")
                .then()
                .spec(responseSpecification)
                .extract()
                .jsonPath()
                .get("id")
                .toString();


    }




}
