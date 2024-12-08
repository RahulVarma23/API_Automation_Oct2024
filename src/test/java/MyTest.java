import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyTest {

    @Test
    public void testGetRequest() {
        String BASE_URI = "https://reqres.in/api";
        Response response = given().baseUri(BASE_URI).basePath("/users").queryParams("page", 2).when().log().all().get()
                .then().extract().response();

        Assert.assertEquals(response.statusCode(), 200, "response is not matching");

        List<String> fnames = response.jsonPath().getList("data.first_name");

        //  System.out.println(fnames);
        List<String> lnames = response.jsonPath().getList("data.last_name");
        //  System.out.println(lnames);
        Map<String, String> map = new LinkedHashMap<>();
        for(int i=0; i<lnames.size(); i++) {
            map.put(fnames.get(i), lnames.get(i));
        }
        System.out.println(map);
    }
}
