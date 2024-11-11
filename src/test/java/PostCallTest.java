
import io.restassured.response.Response;
import model.Employe;
import model.Employee;
import model.GoRest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostCallTest {


    //https://reqres.in/api/users
    //{
    //    "name": "morpheus",
    //    "job": "leader"
    //}

    @Test
    public void testPostRequestUsingString() {

        String BASE_URI = "https://reqres.in/api/users";

        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

       Response response =  given().header("Content-Type", "application/json").baseUri(BASE_URI).body(body).log().all().when().post()
               .then().extract().response();

        System.out.println("status code: "+response.statusCode());
    }

    @Test
    public void testPostRequestUsingMap() {
        String BASE_URI = "https://reqres.in/api/users";

        Map<String , String> map = new HashMap<>();
        map.put("name" , "morpheus");
        map.put("job" , "leader");

        Response response =  given().header("Content-Type", "application/json").body(map).baseUri(BASE_URI).log().all().when().post()
                .then().log().all().extract().response();

        System.out.println("status code: "+response.statusCode());

    }

    @Test
    public void testPostRequestUsingJsonFile() {
        String BASE_URI = "https://reqres.in/api/users";

        File file = new File("src/main/resources/test.json");

        Response response =  given().body(file).header("Content-Type", "application/json").baseUri(BASE_URI).log().all().when().post()
                .then().log().all().extract().response();

        System.out.println("status code: "+response.statusCode());
    }

    @Test
    public void testPostRequestUsingConstructor() {
        String BASE_URI = "https://reqres.in/api/users";

        Employee employee = new Employee("laxman", "qa" , 20);

        Response response = given().baseUri(BASE_URI).body(employee).log().all().post().then().extract().response();

        System.out.println("status code: "+response.statusCode());
    }

    @Test
    public void testPostRequestUsingBuilder() {
        String BASE_URI = "https://reqres.in/api/users";

       // Employee employee = new Employee("laxman", "qa" , 20);

        Employe e = Employe.builder().name("fhfjf").age(11).build();

        Response response = given().baseUri(BASE_URI).body(e).log().all().post().then().extract().response();

        System.out.println("status code: "+response.statusCode());
    }

    @Test
    public void testPostRequestForGoRest() {
        String BASE_URI = "https://gorest.co.in/public/v2/users";

        File file = new File("src/main/resources/gorest.json");

        Response response = given().header("Content-Type", "application/json").header("Authorization", "Bearer 515b7d9edf971d939519265adcc22f5654e2986007fa51a0d839ca92cdf8aabb").baseUri(BASE_URI).body(file).log().all().post().then().log().all().extract().response();

        System.out.println("status code: "+response.statusCode());
    }

    @Test
    public void testPostRequestForGoRestUsingBuilder() {
        String BASE_URI = "https://gorest.co.in/public/v2/users";

        GoRest goRest = GoRest.builder().name("mayur").email("abc744944@gmail.com").gender("male").status("active").build();

        Map<String, String > map = new HashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Bearer 515b7d9edf971d939519265adcc22f5654e2986007fa51a0d839ca92cdf8aabb");

        Response response = given().headers(map).baseUri(BASE_URI)
                .body(goRest).log().all().post().then().log().all().extract().response();

        System.out.println("status code: "+response.statusCode());
    }
}
