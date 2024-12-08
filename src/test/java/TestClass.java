import io.restassured.response.Response;
import model.Category;
import model.Pet;
import model.Tag;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestClass {

    @Test
    public void testPostRequestAddPet() {
        String BASE_URI = "https://petstore.swagger.io/v2/pet";

        Category category = Category.builder().id(100).name("animal").build();
        Tag tag1 = Tag.builder().id(10).name("fhnjfnjnf").build();
        Tag tag2 = Tag.builder().id(11).name("ffgg").build();

        List<Tag> list =  Arrays.asList(tag1, tag2);

        List<String> photoUrls = Arrays.asList("www.google.com", "www.abc.com");

        Pet pet = Pet.builder()
                .id(200)
                .category(category)
                .name("doggie")
                .photoUrls(photoUrls)
                .tags(list)
                .status("available")
                .build();


        Map<String, String > map = new HashMap<>();
        map.put("Content-Type", "application/json");

        Response response = given().headers(map).baseUri(BASE_URI)
                .body(pet).log().all().post().then().log().all().extract().response();

        System.out.println("status code: "+response.statusCode());
        System.out.println("status code: "+response.statusCode());




    }
}
