package Activity2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Activity2 {

    private final String username = "justinc";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user";
        RestAssured.defaultParser = Parser.JSON; // avoids parser issues for empty responses
    }

    @Test(priority = 1)
    public void addNewUserFromFile() throws IOException {
        FileInputStream inputJSON = new FileInputStream("src/test/resources/userInfo.json");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(inputJSON)
                .when().post();

        inputJSON.close();

        response.then().statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo("9901"));
    }

    @Test(priority = 2)
    public void getUserInfo() throws IOException {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .when().get("/{username}");

        String resBody = response.getBody().asPrettyString();

        // Make sure directory exists
        File outputDir = new File("src/test/java/activities");
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        File outputJSON = new File(outputDir, "userGETResponse.json");
        try (FileWriter writer = new FileWriter(outputJSON)) {
            writer.write(resBody);
        }

        // Print response for debugging
        System.out.println(resBody);

        response.then().statusCode(200)
                .body("id", equalTo(9901))
                .body("username", equalTo(username))
                .body("firstName", equalTo("Justin"))
                .body("lastName", equalTo("Case"))
                .body("email", equalTo("justincase@mail.com"))
                .body("password", equalTo("password123"))
                .body("phone", equalTo("9812763450"));
    }

    @Test(priority = 3)
    public void deleteUser() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .when().delete("/{username}");

        response.then().statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo(username));
    }
}
