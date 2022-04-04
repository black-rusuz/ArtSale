Методы:
1. viewProducts(String filter, long productId) — Показать доступные товары и заказать выбранный
2. filterView(String filter) — Фильтр товаров
3. orderProduct(long productId) — Заказ выбранного товара
4. leaveUserData(String name, String phone, String email, String address) — Оставить контактные данные для заказов
5. leaveContactDetails(String name, String phone, String email) — Оставить контактные данные для связи
6. leaveAddress(String name, String address) — Оставить контактные данные для доставки

Параметры:
Для environment.properties: -Denv
Для логгера: -Dlog4j2.configurationFile

Типы Датасорсов:
CSV
XML
JDBC

Примеры команд запуска:
java -jar -Denv=./environment.properties -Dlog4j2.configurationFile=./log4j2.xml ./Accounter.jar XML
java -jar -Denv=./environment.properties -Dlog4j2.configurationFile=./log4j2.xml ./Accounter.jar XML
java -jar -Denv=./environment.properties -Dlog4j2.configurationFile=./log4j2.xml ./Accounter.jar CSV
java -jar -Denv=./environment.properties -Dlog4j2.configurationFile=./log4j2.xml ./Accounter.jar CSV
java -jar -Denv=./environment.properties -Dlog4j2.configurationFile=./log4j2.xml ./Accounter.jar JDBC
java -jar -Denv=./environment.properties -Dlog4j2.configurationFile=./log4j2.xml ./Accounter.jar JDBC