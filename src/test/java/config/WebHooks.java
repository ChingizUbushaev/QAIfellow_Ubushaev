package config;

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

        // Тест начнется после загрузки основных элементов страницы
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        // Открываем нужный сайт
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        // Открываем окно браузера во весь экран
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeDriver(){
        WebDriverRunner.closeWebDriver();
    }
}


