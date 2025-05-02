package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

public class BasePage {
    protected final String key = ConfigReader.get("key");
    protected final String token = ConfigReader.get("token");
    protected final String baseURI = ConfigReader.get("base_uri");

    public BasePage() {
        RestAssured.baseURI = baseURI;
    }

    public Response post(String endpoint, String params) {
        return given()
                .contentType("application/json")
                .when()
                .post(endpoint + params)
                .then().statusCode(200)
                .extract().response();
    }

    public Response delete(String endpoint, String params) {
        return given()
                .contentType("application/json")
                .when()
                .delete(endpoint + params)
                .then().statusCode(200)
                .extract().response();
    }

    public Response put(String endpoint, String params) {
        return given()
                .contentType("application/json")
                .when()
                .put(endpoint + params)
                .then().statusCode(200)
                .extract().response();
    }
}
