import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import java.io.FileReader;
import java.io.IOException;

import static reqres_steps.CreateUsersRequest.createUsersRequest;
import static reqres_steps.OpenUrlReqres.openUrlReqres;
import static util.Config.getProperties;

@Epic("Rest Assured Api")
public class TestsReqres extends RequestSpecificationAndResponseTests {

    protected RequestSpecification request = requestSpecificationTests(getProperties("UrlReqres"));

    @Feature("Сайт https://reqres.in")
    @DisplayName("Тест Проверки открытия стартовой страницы")
    @Test
    public void testOpenUrl() {
        String endpoint = "/unknown";
        openUrlReqres(request, endpoint);
    }

    @Feature("Сайт https://reqres.in")
    @DisplayName("Тест создания тестотового пользователя и проверки ответа")
    @Test
    public void testCreate() throws IOException {

        String endpoint = "/users";
        String nameReqres = getProperties("nameReqres");
        String jobReqres = getProperties("jobReqres");

        String filePath = "src/test/resources/reqres/reqres.json";

        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader(filePath);
        JsonObject newJsonFiles = jsonParser.parse(fileReader).getAsJsonObject();
        fileReader.close();
        newJsonFiles.addProperty("name", nameReqres);
        newJsonFiles.addProperty("job", jobReqres);

        String body = newJsonFiles.toString();

        createUsersRequest(request, endpoint, body, nameReqres, jobReqres);
    }

}