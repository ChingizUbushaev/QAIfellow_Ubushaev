package ifellow;

import ifellow.dto.User;
import ifellow.steps.ReqresSteps;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class ReqresTest {
    private static final ReqresSteps reqresSteps = new ReqresSteps();

    @Test
    @DisplayName("Тестирование API Reqres")
    public void testingReqresApi() throws IOException, ParseException {
        HashMap bodyToReqresApi = reqresSteps.createBodyToReqres();
        User user = reqresSteps.createNewUser(bodyToReqresApi);
        Assertions.assertEquals(user.name, "Tomato");
        Assertions.assertEquals(user.job, "Eat maket");
    }
}
