package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.EdujiraProjectsPage;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EdujiraProjectsSteps extends EdujiraProjectsPage {
    private int oldNumberTasks;
    private int newNumberTasks;
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(EdujiraProjectsSteps.class.getName());

    // 2 тест
    @Дано("^нажимаем на кнопку Проекты")
    public void clickProjectsButton() {
        projectsButton.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
    }

    @И("^нажимаем на кнопку Тест")
    public void clickButtonTest() {
        testButton.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
    }

    @Тогда("^появляется заголовок '(.*)'")
    public void checkTitle(String titleH1) {
        Assertions.assertEquals(tagH1.text(), titleH1);
        LOGGER.log(Level.INFO, "Переход в проект Test выполнен");
    }

    // 3 тест
    @Дано("^проверяем количество задач")
    public void checkTaskNumber() {
        String[] partsStrOld = numberTasks.text().split(" ");
        oldNumberTasks = Integer.parseInt(partsStrOld[2]);
    }

    @И("^нажимаем на кнопку Создать")
    public void clickCreateButton() {
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
    }

    @И("^задаем тип задачи '(.*)'")
    public void enterTypeTask(String taskType) {
        typeTaskField.shouldBe(Condition.visible, Duration.ofSeconds(120)).doubleClick();
        typeTaskField.sendKeys(Keys.BACK_SPACE);
        typeTaskField.val(taskType);
    }

    @И("^заполняем тему '(.*)'")
    public void enterSummaryTask(String anySummary) {
        summaryField.click();
        summaryField.val(anySummary);
    }

    @И("^нажимаем на кнопку создать задачу")
    public void clickIssueButton() {
        createIssueButton.click();
        Selenide.refresh();
    }

    @И("^снова проверяем количество задач")
    public void checkNewNumberTask() {
        String[] partsStrOld = numberTasks.text().split(" ");
        newNumberTasks = Integer.parseInt(partsStrOld[2]);
    }

    @Тогда("^количество задач увеличится")
    public void compareNumberTasks() {
        Assertions.assertTrue(newNumberTasks > oldNumberTasks);
        LOGGER.log(Level.INFO, "Количество задач увеличилось");
    }

    @Когда("^в поле поиска вводим '(.*)' и заходим в эту задачу")
    public void searchTask(String taskName) {
        searchField.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
        searchField.val(taskName);
        searchField.sendKeys(Keys.RETURN);
    }

    @Тогда("^проверяем что статус задачи '(.*)' и Исправить в версиях '(.*)'")
    public void checkFieldsTask(String taskStatus, String versionType) {
        Assertions.assertEquals(taskTypeVersion.text(), versionType);
        Assertions.assertEquals(taskStatusText.text(), taskStatus);
        LOGGER.log(Level.INFO, "Тест задачи TestSeleniumATHomework пройден успешно");
    }

    @И("^заполняем поле Описание текстом '(.*)'")
    public void fillTextAreaDescription(String text) {
        textareaDescription.val("Любое описание");
    }

    @И("^нажимаем на кнопку создать баг")
    public void clickBugButton() {
        createIssueButton.click();
    }

    @Тогда("^меняем статус задачи на '(.*)'")
    public void changeTaskStatus(String status) {
        newBugLink.click();
        businessProcessButton.click();
        doneButton.click();
        Assertions.assertEquals(bugStatusText.text(), status);
        LOGGER.log(Level.INFO, "Создание бага пройдено успешно");
    }
}
