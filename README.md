#Фреймворк для автоматического тестирования сайта artnow.ru

Для запуска программы необходимо ввести команду следующего формата:

'mvn clean test -Dbrowser=chrome'

В параметре Dbrowser также можно указать firefox, при необходимости запуска тестов в Mozilla Firefox

Для генерации отчёта к команде выше нужно добавить:

'allure:report'

Для отображения графического отчёта необходимо запустить команду:

'mvn allure:serve'