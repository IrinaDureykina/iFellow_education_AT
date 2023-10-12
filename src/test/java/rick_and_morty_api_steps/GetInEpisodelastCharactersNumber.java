package rick_and_morty_api_steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import request_specification_and_response.RequestSpecificationAndResponseTests;

public class GetInEpisodelastCharactersNumber extends RequestSpecificationAndResponseTests {

    @Step("Получение Id последнего персонажа в эпизоде Id: \"{idEpisode}\"")
    public static String getInEpisodeLastCharactersNumber(RequestSpecification request, String endpoint, String idEpisode) {

        Response response = responseGet(request, null, endpoint, "GET", "200");

        JSONObject responseBody = new JSONObject(response.body().asString());

        String lastCharactersUrl = responseBody.getJSONArray("characters").getString(responseBody.getJSONArray("characters").length() - 1);

        return lastCharactersUrl.substring(lastCharactersUrl.lastIndexOf("/") + 1);

    }
}