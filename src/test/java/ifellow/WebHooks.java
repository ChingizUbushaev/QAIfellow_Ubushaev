package ifellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.PageLoadStrategy;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {

    @BeforeEach
    public void initBrowser() {
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }
}


