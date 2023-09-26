@ifellowEduJira
Feature: ifellowEduJiraTest

  Background Открыт сайт "https://edujira.ifellow.ru"

  @CheckUrlTest
  Scenario: Проверяем URL и ссылку
    Then Проверяем "URL" и наличие ссылки на главную страницу

  @authorizationTest
  Scenario: Авторизация
    When Вводим "login" вводим "password" и нажимаем Войти
    Then Заходим в профиль
    Then Сверяем имя профиля с введенным "login"

  @openProjectTest
  Scenario: Заходим в проект и получаем количество задач в проекте
    When Вводим "login" вводим "password" и нажимаем Войти
    Then Заходим в проект "nameProject"
    Then Получаем количество задач в проекте

  @selectTaskTest
  Scenario: Поиск задачи по имени и просмотр статуса задачи и привязку к версии
    When Вводим "login" вводим "password" и нажимаем Войти
    Then Заходим в профиль
    Then Производим поиск задачи: "nameTask"
    Then Сверяем "statusTask" и привязку "affectVersion"


  @creatingTaskTest
  Scenario: Создаем задачу и переводим созданную задачу по статусам
    When Вводим "login" вводим "password" и нажимаем Войти
    Then Создаем задачу тип: "issueType" тема: "issueSummary"
    Then Переводим созданную задачу по статусам