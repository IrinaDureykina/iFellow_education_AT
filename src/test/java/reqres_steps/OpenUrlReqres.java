package reqres_steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import request_specification_and_response.RequestSpecificationAndResponseTests;

import static org.hamcrest.Matchers.*;

public class OpenUrlReqres extends RequestSpecificationAndResponseTests {

    @Step("Проверка доступности сайта Reqres.in")
    public static void openUrlReqres(RequestSpecification request, String endpoint){

        Response response = responseGet(request, null, endpoint, "GET", "200");
        response.then()
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("page", equalTo(1))
                .body("total_pages", equalTo(2))
                .body("support.text", containsString("To keep ReqRes free, contributions towards server costs are appreciated!"))
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .body("data", hasSize(6))
                .body("data[0].color", equalTo("#98B2D1"))
                .body("data[0].year", equalTo(2000))
                .body("data[0].name", equalTo("cerulean"))
                .body("data[0].id", equalTo(1))
                .body("data[0].pantone_value", equalTo("15-4020"));
    }
}
