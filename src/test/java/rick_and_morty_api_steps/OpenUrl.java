package rick_and_morty_api_steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import static org.hamcrest.Matchers.equalTo;

public class OpenUrl extends RequestSpecificationAndResponseTests {

    public static void openUrl(RequestSpecification request) {

        Response response = responseGet(request, null, null, "GET", "200");

        response
                .then()
                .body("characters", equalTo("https://rickandmortyapi.com/api/character"))
                .body("locations", equalTo("https://rickandmortyapi.com/api/location"))
                .body("episodes", equalTo("https://rickandmortyapi.com/api/episode"));

    }
}
