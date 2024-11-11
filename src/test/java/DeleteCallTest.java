import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteCallTest {

    @Test
    public void testDelete() {
        String BASE_URI= "https://reqres.in/api/users/2";

        Response response = given().baseUri(BASE_URI).when().log().all().delete().then().extract().response();

        System.out.println("response code : "+response.statusCode());

        Assert.assertEquals(response.statusCode(), 204, "status code is not matching");
    }
}
