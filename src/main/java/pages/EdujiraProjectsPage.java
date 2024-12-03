package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class EdujiraProjectsPage {
    // 2 тест
    public static final SelenideElement projectsButton = $x("//a[@id = 'browse_link']").as("кнопка Проекты");
    public static final SelenideElement testButton = $x("//a[@id = 'admin_main_proj_link_lnk']").as("кнопка с проектом Тест");
    public static final SelenideElement tagH1 = $x("//span[@id = 'issues-subnavigation-title']").as("заголовок h1 'Открытые задачи'");
    // 3 тест
    public static final SelenideElement numberTasks = $x("//div[@class = 'showing']").as("количество задач");
    public static final SelenideElement createTaskButton = $x("//a[@id = 'create_link']").as("кнопка Создать");
    public static final SelenideElement typeTaskField = $x("//input[@id = 'issuetype-field']").as("поле с типом задачи");
    public static final SelenideElement summaryField = $x("//input[@id = 'summary']").as("поле с описанием");
    public static final SelenideElement createIssueButton = $x("//input[@id = 'create-issue-submit']").as("кнопка создать задачу");
    // 4 тест
    public static final SelenideElement searchField = $x("//input[@id = 'quickSearchInput']").as("поле Поиск");
    public static final SelenideElement taskStatusText = $x("//span[@id = 'status-val']").as("статус задачи");
    public static final SelenideElement taskTypeVersion = $x("//span[@id = 'fixVersions-field']").as("поле Исправить в версиях");
    // 5 тест
    public static final SelenideElement textareaDescription = $x("//textarea[@id = 'description']");
    public static final SelenideElement newBugLink = $x("//a[@class = 'issue-created-key issue-link']");
    public static final SelenideElement businessProcessButton = $x("//span[text() = 'Бизнес-процесс']");
    public static final SelenideElement doneButton = $x("//span[text() = 'Выполнено']");
    public static final SelenideElement bugStatusText = $x("//span[text() = 'Готово']");
}
