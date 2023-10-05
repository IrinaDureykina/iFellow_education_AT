import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import java.io.FileReader;
import java.io.IOException;

import static reqres_steps.CreateUsersRequest.createUsersRequest;
import static reqres_steps.OpenUrlReqres.openUrlReqres;
import static util.Config.getProperties;

public class TestsReqres extends RequestSpecificationAndResponseTests {

    protected RequestSpecification request = requestSpecificationTests(getProperties("UrlReqres"));

    @Test
    public void testOpenUrl() {
        String endpoint = "/unknown";
        openUrlReqres(request, endpoint);
    }

    @Test
    public void testCreate() throws IOException {

        String endpoint = "/users";
        String nameReqres = getProperties("nameReqres");
        String jobReqres = getProperties("jobReqres");

        String filePath = "src/test/resources/reqres/reqres.json";
        JsonParser jsonParser = new JsonParser();
        FileReader fileReader = new FileReader(filePath);
        JsonObject jsonObject = jsonParser.parse(fileReader).getAsJsonObject();
        fileReader.close();
        jsonObject.addProperty("name", nameReqres);
        jsonObject.addProperty("job", jobReqres);

        String body = jsonObject.toString();

        createUsersRequest(request, endpoint, body, nameReqres, jobReqres);
    }

}
