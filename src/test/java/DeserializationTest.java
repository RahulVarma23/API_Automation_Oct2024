import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import response.Data;
import response.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class DeserializationTest {

    @Test
    public void deserializationTest() {
        String BASE_URI = "https://reqres.in/api";
        Response response = given().baseUri(BASE_URI).basePath("/users").queryParams("page", 2).when().get()
                .then().extract().response();

        System.out.println(response.statusCode());

        Users users = response.as(Users.class); // deserialization

        System.out.println(users.getSupport().getUrl());

        System.out.println(users.getData().get(0).getFirst_name());

        System.out.println(users.getData().get(1).getLast_name());

    }

    @Test
    public void getListOfFirstNames() {
        String BASE_URI = "https://reqres.in/api";
        Response response = given().baseUri(BASE_URI).basePath("/users").queryParams("page", 2).when().get()
                .then().extract().response();

        System.out.println(response.statusCode());

        Users users = response.as(Users.class); // deserialization

        System.out.println(users.getSupport().getUrl());

        System.out.println(users.getData().get(0).getFirst_name());

        System.out.println(users.getData().get(1).getLast_name());

        List<String> emailList = new ArrayList<>();

        for( Data data  :users.getData()) {
            emailList.add(data.getEmail());
        }
        System.out.println(emailList);

//        List<String> list = users.getData().stream().map(Data::getFirst_name).collect(Collectors.toList());
//
//        System.out.println(list);
//
//        List<String> list1 = users.getData().stream().map(Data::getFirst_name).filter(s->s.contains("s")).collect(Collectors.toList());
//
//        System.out.println(list1);
//
//        List<String> list2 = users.getData().stream().map(data->data.getFirst_name()).filter(a->a.startsWith("T")).collect(Collectors.toList());
//        System.out.println(list2);

        Assert.assertTrue(emailList.contains("Byron"), "expected element is not present");

    }
}
