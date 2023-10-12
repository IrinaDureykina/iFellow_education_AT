package reqres_steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import static org.hamcrest.Matchers.equalTo;

public class CreateUsersRequest extends RequestSpecificationAndResponseTests {

    @Step("Создание пользователя на сайте Reqres.in")
    public static void createUsersRequest(RequestSpecification request, String endpoint, String bodyValue, String expectedName, String expectedJob) {

        Response response = responseGet(request, bodyValue, endpoint, "POST", "201");
        response.prettyPrint();

        response.then()
                .assertThat()
                .body("name", equalTo(expectedName))
                .body("job", equalTo(expectedJob));
    }

}
