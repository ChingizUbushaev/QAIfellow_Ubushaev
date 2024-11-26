package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {
    // 3 тест
    public static final SelenideElement projectsButton = $x("//a[@id = 'browse_link']");
    public static final SelenideElement testButton = $x("//a[@id = 'admin_main_proj_link_lnk']");
    public static final SelenideElement tagH1 = $x("//span[@id = 'issues-subnavigation-title']");
    public static final SelenideElement numberTasks = $x("//div[@class = 'showing']");
    public static final SelenideElement createTaskButton = $x("//a[@id = 'create_link']");
    public static final SelenideElement typeTaskField = $x("//input[@id = 'issuetype-field']");
    public static final SelenideElement summaryField = $x("//input[@id = 'summary']");
    public static final SelenideElement createIssueButton = $x("//input[@id = 'create-issue-submit']");
    // 5 тест
    public static final SelenideElement textareaDescription = $x("//textarea[@id = 'description']");
    public static final SelenideElement newBugLink = $x("//a[@class = 'issue-created-key issue-link']");
    public static final SelenideElement businessProcessButton = $x("//span[text() = 'Бизнес-процесс']");
    public static final SelenideElement doneButton = $x("//span[text() = 'Выполнено']");
    public static final SelenideElement bugStatusText = $x("//span[text() = 'Готово']");
    // 4 тест
    public static final SelenideElement searchField = $x("//input[@id = 'quickSearchInput']");
    public static final SelenideElement taskStatusText = $x("//span[@id = 'status-val']");
    public static final SelenideElement taskTypeVersion = $x("//span[@id = 'fixVersions-field']");
}
