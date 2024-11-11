import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AuthTest {

    String BASE_URI = "https://httpbin.org/basic-auth/user/password";

    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(BASE_URI)
            .setAuth(RestAssured.basic("user","password"))
            .build();

    @Test
    public void testWithoutBasicAuth() {
        Response response = given().spec(requestSpecification).when().get().then().extract().response();
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200, "status code is not matching");
    }

    @Test
    public void testWithBasicAuth() {
        Response response = given().spec(requestSpecification).when().get().then().extract().response();

        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200, "status code is not matching");
    }
}
