import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import static rick_and_morty_api_steps.CharacterCompare.characterCompare;
import static rick_and_morty_api_steps.GetCharacter.getCharacter;
import static rick_and_morty_api_steps.GetInEpisodelastCharactersNumber.getInEpisodeLastCharactersNumber;
import static rick_and_morty_api_steps.OpenUrl.openUrl;
import static util.Config.getProperties;

public class TestsRickAndMortyApi extends RequestSpecificationAndResponseTests {

    protected RequestSpecification request = requestSpecificationTests(getProperties("UrlRickAndMorti"));

    @Test
    public void testOpenUrl() {
        openUrl(request);
    }

    @Test
    public void testGetCharacterAndGetLastEpisodeAndGetLastCharacter() {

        String endpoint = "character/" + getProperties("character");
        JSONObject characterJson1 = getCharacter(request, endpoint);

        String lastEpisodeNumber = characterJson1.getString("lastEpisodeNumber");

        endpoint = "episode/" + lastEpisodeNumber;
        String characterNumber2 = getInEpisodeLastCharactersNumber(request, endpoint);

        endpoint = "character/" + characterNumber2;
        JSONObject characterJson2 = getCharacter(request, endpoint);

        characterCompare(characterJson1, characterJson2);
    }
}
