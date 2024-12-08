import io.restassured.response.Response;
import model.Employee;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTestNew {
    String BASE_URI = "https://reqres.in/api/users";

    @Test
    public void testPatchRequest() {
        Employee employee = new Employee("laxman", "qa" , 20);

        Response response = given().baseUri(BASE_URI).body(employee).log().all().patch().then().extract().response();

        System.out.println("status code: "+response.statusCode());
    }
}
