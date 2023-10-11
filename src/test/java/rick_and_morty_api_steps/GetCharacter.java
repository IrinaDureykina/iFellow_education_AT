package rick_and_morty_api_steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import request_specification_and_response.RequestSpecificationAndResponseTests;

public class GetCharacter extends RequestSpecificationAndResponseTests {

    @Step("Получение характеристик персонажа по его Id: \"{2}\"")
    public static JSONObject getCharacter(RequestSpecification request, String endpoint, String id) {

        Response response = responseGet(request, null, endpoint, "GET", "200");

        JSONObject characterJson = new JSONObject();

        JSONObject responseBody = new JSONObject(response.body().asString());

        characterJson.put("name", responseBody.getString("name"));
        characterJson.put("species", responseBody.getString("species"));
        characterJson.put("location", responseBody.getJSONObject("location").getString("name"));

        String lastEpisodeUrl = responseBody.getJSONArray("episode").getString(responseBody.getJSONArray("episode").length() - 1);
        characterJson.put("lastEpisodeNumber", lastEpisodeUrl.substring(lastEpisodeUrl.lastIndexOf("/") + 1));

        return characterJson;

    }
}