package ifellow.api;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static ifellow.constants.EnvConstants.*;
import static io.restassured.RestAssured.given;

public class ReqresApi {
    public ValidatableResponse postPet(HashMap<String, String> bodyToReqres) {
        return given()
                .spec(BaseReqresApi.baseRequestSpec(BASE_REQRES_URL))
                .when().body(bodyToReqres)
                .post(REQRES_POST_URN)
                .then()
                .spec(BaseReqresApi.baseResponseSpecSuccess());
    }
}
