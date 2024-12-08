import io.restassured.response.Response;
import model.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTestNew {
    String BASE_URI = "https://reqres.in/api/users";

    @Test
    public void testPostRequest() {
        Employee employee = new Employee("laxman", "qa" , 20);

        Response response = given().baseUri(BASE_URI).body(employee).log().all().post().then().extract().response();

        Assert.assertEquals(response.statusCode(),201,"Status code not matching");
    }
}
