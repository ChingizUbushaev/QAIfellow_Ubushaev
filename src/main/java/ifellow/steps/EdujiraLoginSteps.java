package ifellow.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ifellow.pages.EdujiraLoginPage;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class EdujiraLoginSteps extends EdujiraLoginPage {
    @Step("Вводим Имя пользователя {username} и Пароль {password}")
    public EdujiraLoginSteps enterLoginAndPassword(String username, String password) {
        fieldUsername.shouldBe(Condition.visible, Duration.ofSeconds(120)).setValue(username);
        fieldPassword.setValue(password);
        return this;
    }

    @Step("Нажимаем на кнопку Войти")
    public EdujiraLoginSteps clickLoginButton() {
        loginButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Проверяем панель задач с заголовком {title}")
    public void checkTaskBar(String title) {
        Assertions.assertEquals(taskBar.text(), title);
    }

    @Step("Открываем файл с properties")
    public Properties getPropertiesObject() throws IOException {
        File file = new File("src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        return properties;
    }
}
