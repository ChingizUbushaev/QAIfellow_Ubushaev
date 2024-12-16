package ifellow.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ifellow.pages.ProjectsPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class EdujiraProjectsSteps extends ProjectsPage {

    @Step("Нажимаем на кнопку Проекты")
    public EdujiraProjectsSteps clickProgectsButton() {
        projectsButton.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
        return this;
    }

    @Step("Выбираем проект Test")
    public EdujiraProjectsSteps clickProjectTestButton() {
        testButton.click();
        return this;
    }

    @Step("Проверяем, что появилась панель с заголовком {titleBoardTasks}")
    public EdujiraProjectsSteps checkBoardTasks(String titleBoardTasks) {
        Assertions.assertEquals(tagH1.text(), titleBoardTasks);
        return this;
    }

    @Step("Проверяем количество задач на текущий момент")
    public int checkNumberTasks() {
        String[] partsStrOld = numberTasks.shouldBe(Condition.visible, Duration.ofSeconds(120)).text().split(" ");
        return Integer.parseInt(partsStrOld[2]);
    }

    @Step("Кликаем на кнопку Создать задачу")
    public EdujiraProjectsSteps clickCreateButton() {
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
        return this;
    }

    @Step("Заполняем поле Тип {typeTask}")
    public EdujiraProjectsSteps enterTypeTask(String typeTask) {
        typeTaskField.doubleClick();
        typeTaskField.sendKeys(Keys.BACK_SPACE);
        typeTaskField.val(typeTask);
        return this;
    }

    @Step("Заполняем поле Тема {summary}")
    public EdujiraProjectsSteps enterSummaryField(String summary) {
        summaryField.click();
        summaryField.val(summary);
        return this;
    }

    @Step("Нажимаем на кнопку Создать задачу")
    public EdujiraProjectsSteps clickCreateTask() {
        createIssueButton.click();
        return this;
    }

    @Step("Обновляем страницу")
    public EdujiraProjectsSteps refreshPage() {
        Selenide.refresh();
        return this;
    }

    @Step("Проверяем что количество задач увеличелось")
    public EdujiraProjectsSteps compareNumberTasks(int oldNumberTasks, int newNumberTasks) {
        Assertions.assertTrue(newNumberTasks > oldNumberTasks);
        return this;
    }

    @Step("Заполняем поле Описание строкой {textarea}")
    public EdujiraProjectsSteps enterTextarea(String textarea) {
        textareaDescription.val(textarea);
        return this;
    }

    @Step("Переходим в созданный баг")
    public EdujiraProjectsSteps clickBugLink() {
        newBugLink.click();
        return this;
    }

    @Step("Переводим баг в статус готово")
    public EdujiraProjectsSteps changeStatus() {
        businessProcessButton.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
        doneButton.click();
        return this;
    }

    @Step("Проверяем, что статус стал {bugStatus}")
    public EdujiraProjectsSteps checkStatus(String bugStatus) {
        Assertions.assertEquals(bugStatusText.text(), bugStatus);
        return this;
    }

    @Step("Проверяем задачу {taskName}")
    public EdujiraProjectsSteps searchkTask(String taskName) {
        searchField.shouldBe(Condition.visible, Duration.ofSeconds(120)).click();
        searchField.val(taskName);
        searchField.sendKeys(Keys.RETURN);
        return this;
    }

    @Step("Проверяем {version} и {status} задачи")
    public EdujiraProjectsSteps checkFieldsTask(String version, String status) {
        Assertions.assertEquals(taskTypeVersion.text(), version);
        Assertions.assertEquals(taskStatusText.text(), status);
        return this;
    }
}
