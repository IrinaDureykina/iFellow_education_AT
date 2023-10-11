package rick_and_morty_api_steps;

import io.qameta.allure.Step;
import org.json.JSONObject;

public class CharacterCompare {

    @Step("Сравнение рас и местоположение персонажей")
    public static void characterCompare(JSONObject characterJson1, JSONObject characterJson2) {

        String name1 = characterJson1.getString("name");
        String species1 = characterJson1.getString("species");
        String location1 = characterJson1.getString("location");

        String name2 = characterJson2.getString("name");
        String species2 = characterJson2.getString("species");
        String location2 = characterJson2.getString("location");

        if (species1.equals(species2)) {
            System.out.println("Принадлежат к одной расе: " + name1 + " и " + name2 + ": " + species1);
        } else {
            System.out.println("Расы разные: " + name1 + "- " + species1 + ", " + name2 + "- " + species2);
        }

        if (location1.equals(location2)) {
            System.out.println("Находятся в одном месте: " + name1 + " и " + name2 + ": " + location1);
        } else {
            System.out.println("Находятся в разных местах: " + name1 + "- " + location1 + ", " + name2 + "- " + location2);
        }

    }

}