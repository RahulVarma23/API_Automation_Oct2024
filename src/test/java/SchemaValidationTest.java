import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SchemaValidationTest {

    @Test
    public void testJsonSchema() {
        String BASE_URI = "https://reqres.in/api";
        Response response = given().baseUri(BASE_URI).basePath("/users").queryParams("page", 2).when().log().all().get()
                .then().extract().response();

        Assert.assertEquals(response.statusCode(), 200, "response is not matching");

        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/getUsersSchema.json"));
    }
}
