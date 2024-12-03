package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import org.junit.jupiter.api.Assertions;
import pages.EdujiraLoginPage;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.time.Duration;

public class EdujiraLoginSteps extends EdujiraLoginPage {

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
    public void appearTaskBar(String titleTaskBar){
        Assertions.assertEquals( taskBar.text(), titleTaskBar);
        Selenide.sleep(5000);
    }
}
