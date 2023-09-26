# REST-Interval-Merger
Тестовое задание для Лаборатории ШИФТ ЦФТ

---
## Функционал
1. Объединение пересекающихся интервалов по запросу и сохрание в in-memory базу данных H2.
   - в базе данных могут храниться пересекающиеся интервалы, полученные разными запросами
2. Получение минимального интервала 
   - реализовано SQL запросом в БД
   - минимальным считается самый короткий интервал, начало которого меньше начал других интервалов

    
Интервалы могут быть 2-х видов:
1. Числовые (kind=digits)
2. Символьные (kind=letters)

## Endpoints
### Добавление интервалов
```
POST /api/v1/intervals/merge?kind=digits
```
```json
[
  [2, 5],
  [3, 7],
  [10, 12]
]
```
```
POST /api/v1/intervals/merge?kind=letters
```
```json
[
  ["a", "c"],
  ["b", "d"],
  ["e", "f"]
]
```

### Получение минимального интервала
```
GET /api/v1/intervals/min?kind=digits
GET /api/v1/intervals/min?kind=letters
```

##  Сборка, запуск и тестирование
 ```./mvnw spring-boot:run``` - запуск приложения \
 ```./mvnw surefire:test``` - запуск тестов

Также для тестирования можно использовать postman коллекцию - ```REST-Interval-Merger.postman_collection.json```
 