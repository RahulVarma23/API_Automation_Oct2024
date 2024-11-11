import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUploadOperation {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://file.io";

        File fileToUpload = new File("D://Users//ansinha//Downloads//body.txt");

        Response response = given()
                .multiPart("file", fileToUpload)
                .contentType(ContentType.MULTIPART)
                .log().all()
                .when()
                .post()
                .then()
                .extract().response();

        System.out.println("Status code: "+response.statusCode());
    }
}
