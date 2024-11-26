package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class EdujiraLoginPage{
    public static final SelenideElement fieldUsername = $x("//input[@id = 'login-form-username']");
    public static final SelenideElement fieldPassword = $x("//input[@id = 'login-form-password']");
    public static final SelenideElement loginButton = $x("//input[@id = 'login']");
    public static final SelenideElement taskBar = $x("//h3[text() = 'Назначенные мне']");
}
