# language: ru
@edujira

Функция: Тестирование сайта Edujira

  @edujira
  Сценарий: Вход на сайт Edujira
    Когда в поле Имя пользователя вводим 'AT13'
    И в поле пароль вводим 'Qwerty123'
    И нажимаем кнопку Войти
    Тогда появляется панель задач с заголовком 'Назначенные мне'

  @edujira
  Сценарий: Переход в проект Тест сайта Edujira
    # Заходим на сайт Edujira
    Когда в поле Имя пользователя вводим 'AT13'
    И в поле пароль вводим 'Qwerty123'
    И нажимаем кнопку Войти
    Тогда появляется панель задач с заголовком 'Назначенные мне'
    # Переход в проект Тест
    Дано нажимаем на кнопку Проекты
    И нажимаем на кнопку Тест
    Тогда появляется заголовок 'Открытые задачи'

  @edujira
  Сценарий: Проверить общее количество заведенных задач в проекте Тест
    # Заходим на сайт Edujira
    Когда в поле Имя пользователя вводим 'AT13'
    И в поле пароль вводим 'Qwerty123'
    И нажимаем кнопку Войти
    Тогда появляется панель задач с заголовком 'Назначенные мне'
    # Переход в проект Тест
    Дано нажимаем на кнопку Проекты
    И нажимаем на кнопку Тест
    Тогда появляется заголовок 'Открытые задачи'
    # Проверяем количество заведенных задач
    Дано проверяем количество задач
    И нажимаем на кнопку Создать
    И задаем тип задачи 'Задача'
    И заполняем тему 'Любая тема'
    И нажимаем на кнопку создать задачу
    И снова проверяем количество задач
    Тогда количество задач увеличится

  @edujira
  Сценарий: Проверяем задачу TestSeleniumATHomework
    # Заходим на сайт Edujira
    Когда в поле Имя пользователя вводим 'AT13'
    И в поле пароль вводим 'Qwerty123'
    И нажимаем кнопку Войти
    Тогда появляется панель задач с заголовком 'Назначенные мне'
    # Проверяем задачу TestSeleniumATHomework
    Когда в поле поиска вводим 'TestSeleniumATHomework' и заходим в эту задачу
    Тогда проверяем что статус задачи 'СДЕЛАТЬ' и Исправить в версиях 'Version 2.0'

  @edujira
  Сценарий: Сождание нового бага
    # Заходим на сайт Edujira
    Когда в поле Имя пользователя вводим 'AT13'
    И в поле пароль вводим 'Qwerty123'
    И нажимаем кнопку Войти
    Тогда появляется панель задач с заголовком 'Назначенные мне'
    # Переход в проект Тест
    Дано нажимаем на кнопку Проекты
    И нажимаем на кнопку Тест
    Тогда появляется заголовок 'Открытые задачи'
    # Создание нового бага
    И нажимаем на кнопку Создать
    И задаем тип задачи 'Ошибка'
    И заполняем тему 'Любая тема'
    И заполняем поле Описание текстом 'Любое описание'
    И нажимаем на кнопку создать баг
    Тогда меняем статус задачи на 'ГОТОВО'