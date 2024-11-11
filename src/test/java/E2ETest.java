import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Category;
import model.Pet;
import model.Tag;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class E2ETest {

    @Test
    public void testE2e() {
        String URL= "https://petstore.swagger.io/v2/pet";

        //https://petstore.swagger.io/v2/pet/1234

        Category category = Category.builder()
                .id(0).name("animal").build();

        Tag tag1 = Tag.builder().id(0).name("tag1").build();
        Tag tag2 = Tag.builder().id(1).name("tag2").build();

        Pet petRequest = Pet.builder()
                .id(1234)
                .category(category)
                .name("cat")
                .photoUrls(Arrays.asList("www.google.com","www.photourl.com"))
                .tags(List.of(tag1, tag2))
                .status("available")
                .build();

        Response response = given().header("content-type","application/json").body(petRequest).log().all().when().post(URL).then().extract().response();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK, "status code is not matching");

        Pet petResponse = response.as(Pet.class);

        Assert.assertEquals(petResponse.getId(), petRequest.getId(), "Id is not matching");
        Assert.assertEquals(petResponse.getName(), petRequest.getName(), "Name is not matching");
        Assert.assertEquals(petResponse.getStatus(), petRequest.getStatus(), "Name is not matching");
        Assert.assertEquals(petResponse.getPhotoUrls(), petRequest.getPhotoUrls(), "photoUrls not maching");

        int petId = petResponse.getId();
        System.out.println(petId);

        response = given().baseUri(URL).basePath("/"+petId).log().all().when().get().then().extract().response();

        System.out.println(response.getStatusCode());

        response = given().baseUri(URL).basePath("/"+petId).log().all().when().delete().then().extract().response();

        System.out.println(response.statusCode());

        response = given().baseUri(URL).basePath("/"+petId).log().all().when().get().then().extract().response();

        System.out.println(response.getStatusCode());

    }
}
