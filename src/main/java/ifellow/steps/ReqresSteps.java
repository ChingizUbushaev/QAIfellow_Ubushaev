package ifellow.steps;

import ifellow.dto.User;
import org.json.simple.parser.*;
import ifellow.api.ReqresApi;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class ReqresSteps {
    private static final ReqresApi reqresApi = new ReqresApi();

    public User createNewUser(HashMap<String, String> bodyToReqres) {
        User user = reqresApi.postPet(bodyToReqres)
                .statusCode(201)
                .extract()
                .body()
                .as(User.class);
        return user;
    }

    public HashMap createBodyToReqres() throws IOException, ParseException {
        HashMap<String, String> bodyToReqres = new HashMap<>();
        Object object = new JSONParser().parse(new FileReader("src/test/resources/reqres.json"));
        JSONObject jsonObject = (JSONObject) object;
        String nameMean = (String) jsonObject.get("name");
        bodyToReqres.put("name", nameMean);
        bodyToReqres.replace("name", "Tomato");
        bodyToReqres.put("job", "Eat maket");
        return bodyToReqres;
    }
}
