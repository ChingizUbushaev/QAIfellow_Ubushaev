package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class EdujiraLoginPage {
    public static final SelenideElement fieldUsername = $x("//input[@id = 'login-form-username']");
    public static final SelenideElement fieldPassword = $x("//input[@id = 'login-form-password']");
    public static final SelenideElement loginButton = $x("//input[@id = 'login']");
    public static final SelenideElement taskBar = $x("//h3[text() = 'Назначенные мне']");
}
