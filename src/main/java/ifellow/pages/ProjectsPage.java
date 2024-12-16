package ifellow.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {
    public static final SelenideElement projectsButton = $x("//a[@id = 'browse_link']").as("кнопка Проекты");
    public static final SelenideElement testButton = $x("//a[@id = 'admin_main_proj_link_lnk']").as("ссылка на проект Test");
    public static final SelenideElement tagH1 = $x("//span[@id = 'issues-subnavigation-title']").as("h1-заголовок Открытые задачи");
    public static final SelenideElement numberTasks = $x("//div[@class = 'showing']").as("поле с количеством задач");
    public static final SelenideElement createTaskButton = $x("//a[@id = 'create_link']").as("кнопка Создать");
    public static final SelenideElement typeTaskField = $x("//input[@id = 'issuetype-field']").as("поле Тип задачи");
    public static final SelenideElement summaryField = $x("//input[@id = 'summary']").as("поле Тема задачи");
    public static final SelenideElement createIssueButton = $x("//input[@id = 'create-issue-submit']").as("кнопка Создать задачу");
    public static final SelenideElement textareaDescription = $x("//textarea[@id = 'description']").as("поле Описание");
    public static final SelenideElement newBugLink = $x("//a[@class = 'issue-created-key issue-link']").as("ссылка на созданную задачу");
    public static final SelenideElement businessProcessButton = $x("//span[text() = 'Бизнес-процесс']").as("кнопка Бизнес-процесс");
    public static final SelenideElement doneButton = $x("//span[text() = 'Выполнено']").as("кнопка Выполнено");
    public static final SelenideElement bugStatusText = $x("//span[text() = 'Готово']").as("поле Статус задачи");
    public static final SelenideElement searchField = $x("//input[@id = 'quickSearchInput']").as("поле Пойск");
    public static final SelenideElement taskStatusText = $x("//span[@id = 'status-val']").as("поле Статус задачи");
    public static final SelenideElement taskTypeVersion = $x("//span[@id = 'fixVersions-field']").as("поле Версия");
}
