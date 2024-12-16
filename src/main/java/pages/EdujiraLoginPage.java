package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class EdujiraLoginPage{
    public static final SelenideElement fieldUsername = $x("//input[@id = 'login-form-username']").as("input-поле Имя пользователя");
    public static final SelenideElement fieldPassword = $x("//input[@id = 'login-form-password']").as("input-поле Пароль");
    public static final SelenideElement loginButton = $x("//input[@id = 'login']").as("кнопка Войти");
    public static final SelenideElement taskBar = $x("//h3[text() = 'Назначенные мне']").as("h3-заголовок панели задач");
}
