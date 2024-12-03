package ifellow.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks {
    @Before("@edujira")
    public void beforeEdujira(Scenario scenario) {
        scenario.log("Runs before each scenarios tagged with @edujira");
        // Тест начнется после загрузки основных элементов страницы
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        // Открываем нужный сайт
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        // Открываем окно браузера во весь экран
        getWebDriver().manage().window().maximize();
    }

    @After("@edujira")
    public void afterEdujira() {
        Selenide.closeWebDriver();
    }
}
