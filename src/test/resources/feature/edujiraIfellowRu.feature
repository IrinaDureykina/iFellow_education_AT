
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
    Then Заходим в проект "nameTask"
    Then Получаем количество задач в проекте

  @selectTaskTest
  Scenario: Поиск задачи по имени и просмотр статуса задачи и привязку к версии
    When Вводим "login" вводим "password" и нажимаем Войти
    Then Заходим в профиль
    Then Производим поиск задачи по "taskName"
    Then Сверяем статус задачи и привязку к заданной версии "affectedVersion"


  @creatingTaskTest
  Scenario: Создаем задачу и переводим созданную задачу по статусам
    When Вводим "login" вводим "password" и нажимаем Войти
    Then Создаем задачу с типом Ошибка и темой "inputTopic" и получаем номер созданной задачи
    Then Переводим созданную задачу по статусам