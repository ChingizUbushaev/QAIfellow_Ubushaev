package config;

import org.openqa.selenium.Keys;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static pages.ProjectsPage.*;
import static pages.EdujiraLoginPage.*;




public class EdujiraTest extends WebHooks {

    @Test
    public void authorizationUser() {
        // Тест авторизации в edujira.ifellow.ru
        fieldUsername.click();
        fieldUsername.sendKeys(Keys.BACK_SPACE);
        fieldUsername.val("AT13");

        fieldPassword.click();
        fieldPassword.sendKeys(Keys.BACK_SPACE);
        fieldPassword.val("Qwerty123");
        loginButton.click();
        Assertions.assertEquals( taskBar.text(), "Назначенные мне");
        System.out.println("Тест авторизации в edujira.ifellow.ru пройден успешно!");
    }

    @Test
    public void openProject() {
        // Тест перехода в проект "Test"
        authorizationUser(); // Авторизация пользователя
        projectsButton.click();
        testButton.click();
        Assertions.assertEquals(tagH1.text(), "Открытые задачи");
        System.out.println("Тест перехода в проект 'Test' пройден успешно!");
    }

    @Test
    public void createTask() {
        // Тест создания новой задачи
        openProject(); // Переход на страницу проекта 'Тест'
        // Парсим строку с количеством текущих задач
        String [] partsStrOld = numberTasks.text().split(" ");
        // Количество задач переводим в int
        int oldNumber = Integer.parseInt(partsStrOld[2]);
        createTaskButton.click();
        typeTaskField.doubleClick();
        typeTaskField.sendKeys(Keys.BACK_SPACE);
        typeTaskField.val("Задача");
        summaryField.click();
        summaryField.val("Любая тема");
        createIssueButton.click();
        Selenide.refresh();
        // Парсим строку с количеством текущих задач
        String [] partsStrNew = numberTasks.text().split(" ");
        // Количество задач переводим в int
        int newNumber = Integer.parseInt(partsStrNew[2]);
        Selenide.sleep(5000);
        System.out.println("Задач было:" + oldNumber);
        System.out.println("Задач стало" + newNumber);
        Assertions.assertTrue(newNumber > oldNumber);
        System.out.println("Тест создания новой задачи пройден успешно!");
    }

    @Test
    public void checkTestSeleniumATHomework() {
        // Тест проверки задачи TestSeleniumATHomework
        openProject(); // Переход на страницу проекта 'Тест'
        searchField.click();
        searchField.val("TestSeleniumATHomework");
        searchField.sendKeys(Keys.RETURN);
        System.out.println(taskTypeVersion.text());
        Assertions.assertEquals(taskTypeVersion.text(), "Version 2.0");
        Assertions.assertEquals(taskStatusText.text(), "СДЕЛАТЬ");
        System.out.println("Тест проверки задачи TestSeleniumATHomework пройден успешно!");
    }

    @Test
    public void createBug() {
        // Тест создания нового бага
        openProject(); // Переход на страницу проекта 'Тест'
        createTaskButton.click();
        typeTaskField.doubleClick();
        typeTaskField.sendKeys(Keys.BACK_SPACE);
        typeTaskField.val("Ошибка");
        summaryField.click();
        summaryField.val("Любая тема");
        textareaDescription.val("Любое описание");
        createIssueButton.click();
        newBugLink.click();
        businessProcessButton.click();
        doneButton.click();
        Assertions.assertEquals(bugStatusText.text(), "ГОТОВО");
        System.out.println("Тест создания нового бага пройден успешно!");
    }

}
