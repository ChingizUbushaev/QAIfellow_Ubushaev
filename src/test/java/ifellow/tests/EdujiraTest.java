package ifellow.tests;

import ifellow.WebHooks;
import ifellow.steps.EdujiraProjectsSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ifellow.steps.EdujiraLoginSteps;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EdujiraTest extends WebHooks {
    EdujiraLoginSteps stepEdujiraTest = new EdujiraLoginSteps();
    EdujiraProjectsSteps stepEdujiraProject = new EdujiraProjectsSteps();

    Properties property = stepEdujiraTest.getPropertiesObject();
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(EdujiraTest.class.getName());

    public EdujiraTest() throws IOException {
    }

    @Test
    @DisplayName("Авторизация пользователя")
    @Tag("Edugira")
    public void authorizationUser() {
        stepEdujiraTest
                .enterLoginAndPassword(property.getProperty("login"), property.getProperty("password"))
                .clickLoginButton()
                .checkTaskBar(property.getProperty("titleTaskbar"));
        LOGGER.log(Level.INFO, "Тест авторизации в edujira.ifellow.ru пройден успешно!");
    }

    @Test
    @DisplayName("Переход в проект Test")
    @Tag("Edugira")
    public void openProject() {
        authorizationUser();
        stepEdujiraProject
                .clickProgectsButton()
                .clickProjectTestButton()
                .checkBoardTasks(property.getProperty("titleTitleBoardTasks"));
        LOGGER.log(Level.INFO, "Тест перехода в проект Test пройден успешно!");
    }

    @Test
    @DisplayName("Создание задачи")
    @Tag("Edugira")
    public void createTask() {
        openProject();
        int oldNumberTasks = stepEdujiraProject.checkNumberTasks();
        stepEdujiraProject
                .clickCreateButton()
                .enterTypeTask(property.getProperty("typeTask"))
                .enterSummaryField(property.getProperty("summary"))
                .clickCreateTask()
                .refreshPage();
        int newNumberTasks = stepEdujiraProject.checkNumberTasks();
        stepEdujiraProject.compareNumberTasks(oldNumberTasks, newNumberTasks);
        LOGGER.log(Level.INFO, "Тест создания новой задачи пройден успешно!");
    }

    @Test
    public void checkTestSeleniumATHomework() {
        openProject();
        stepEdujiraProject
                .searchkTask(property.getProperty("taskName"))
                .checkFieldsTask(property.getProperty("version"), property.getProperty("status"));
        LOGGER.log(Level.INFO, "Тест проверки задачи TestSeleniumATHomework пройден успешно!");
    }

    @Test
    @DisplayName("Создание бага")
    @Tag("Edugira")
    public void createBug() {
        openProject();
        stepEdujiraProject
                .clickCreateButton()
                .enterTypeTask(property.getProperty("typeBug"))
                .enterSummaryField(property.getProperty("summary"))
                .enterTextarea(property.getProperty("textarea"))
                .clickCreateTask()
                .clickBugLink()
                .changeStatus()
                .checkStatus(property.getProperty("bugStatus"));
        LOGGER.log(Level.INFO, "Тест создания нового бага пройден успешно!");
    }
}
