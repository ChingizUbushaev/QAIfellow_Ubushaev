package ifellow.api;

import io.restassured.response.ValidatableResponse;

import static ifellow.constants.EnvConstants.*;
import static io.restassured.RestAssured.given;

public class RickAndMortyApi {
    public ValidatableResponse getCharacterId(String id) {
        return given()
                .spec(BaseRickAndMortyApi.baseRequestSpec(BASE_RICK_AND_MORTY_URL))
                .when()
                .get(CHARACTER_URN + "/" + id)
                .then()
                .spec(BaseRickAndMortyApi.baseResponseSpecSuccess());
    }

    public ValidatableResponse getEpisodeId(String id) {
        return given()
                .spec(BaseRickAndMortyApi.baseRequestSpec(BASE_RICK_AND_MORTY_URL))
                .when()
                .get(EPISODE_URN + "/" + id)
                .then()
                .spec(BaseRickAndMortyApi.baseResponseSpecSuccess());
    }
}
