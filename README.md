# Framework for automated testing of artnow.ru

To run use this:

```
mvn clean test -Dbrowser=chrome
```

In Dbrowser you can also use firefox, if you need to run the tests in Mozilla Firefox

To generate a report add this to the command above:

```
allure:report
```

To view the allure report use this:

```
mvn allure:serve
```