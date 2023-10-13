import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import static rick_and_morty_api_steps.CharacterCompare.characterCompare;
import static rick_and_morty_api_steps.GetCharacter.getCharacter;
import static rick_and_morty_api_steps.GetInEpisodelastCharactersNumber.getInEpisodeLastCharactersNumber;
import static rick_and_morty_api_steps.OpenUrl.openUrl;
import static util.Config.getProperties;

@Epic("Rest Assured Api")
public class TestsRickAndMortyApi extends RequestSpecificationAndResponseTests {

    protected final RequestSpecification request = requestSpecificationTests(getProperties("UrlRickAndMorti"));

    @Feature("Сайт https://rickandmortyapi.com")
    @DisplayName("Тест Проверки открытия стартовой страницы")
    @Test
    public void testOpenUrl() {
        openUrl(request);
    }

    @Feature("Сайт https://rickandmortyapi.com")
    @DisplayName("Тест Получение и сравнение характеристик персонажей")
    @Test
    public void testGetCharacterAndGetLastEpisodeAndGetLastCharacter() {

        String endpoint = "character/" + getProperties("character");
        JSONObject characterJson1 = getCharacter(request, endpoint, getProperties("character"));

        String lastEpisodeNumber = characterJson1.getString("lastEpisodeNumber");

        endpoint = "episode/" + lastEpisodeNumber;
        String characterNumber2 = getInEpisodeLastCharactersNumber(request, endpoint, lastEpisodeNumber);

        endpoint = "character/" + characterNumber2;
        JSONObject characterJson2 = getCharacter(request, endpoint, characterNumber2);

        characterCompare(characterJson1, characterJson2);
    }
}