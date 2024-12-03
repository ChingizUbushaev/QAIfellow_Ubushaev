package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;
import pages.EdujiraLoginPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EdujiraLoginSteps extends EdujiraLoginPage {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(EdujiraLoginSteps.class.getName());

    @Когда("^в поле Имя пользователя вводим '(.*)'")
    public void enterUsername(String username) {
        fieldUsername.shouldBe(Condition.visible, Duration.ofSeconds(120)).setValue(username);
    }

    @И("^в поле пароль вводим '(.*)'")
    public void enterPassword(String password) {
        fieldPassword.setValue(password);
    }

    @И("^нажимаем кнопку Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Тогда("^появляется панель задач с заголовком '(.*)'")
    public void appearTaskBar(String titleTaskBar) {
        Assertions.assertEquals(taskBar.text(), titleTaskBar);
        LOGGER.log(Level.INFO, "Авторизация пользователя пройдена успешна");
    }
}
