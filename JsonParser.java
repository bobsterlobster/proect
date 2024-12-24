package Practika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParser {
    public List<Account> parseJson(String json) {
        // Удаляем пробелы и квадратные скобки
        json = json.trim().replaceAll("[\\[\\]]", "");

        // Разделяем на объекты
        String[] objects = json.split("\\},\\s*\\{");

        List<Account> accounts = new ArrayList<>();

        for (String object : objects) {
            // Удаляем фигурные скобки
            object = object.replaceAll("[{}]", "");

            // Разделяем на пары ключ-значение
            String[] pairs = object.split(",");

            Map<String, String> jsonMap = new HashMap<>();

            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                if (keyValue.length != 2) {
                    throw new IllegalArgumentException("Некорректный формат пары ключ-значение: " + pair);
                }
                String key = keyValue[0].trim().replaceAll("\"", ""); // Убираем кавычки
                String value = keyValue[1].trim();

                jsonMap.put(key, value);
            }

            // Проверка обязательных полей
            if (!jsonMap.containsKey("accountId") || !jsonMap.containsKey("accountHolder") ||
                    !jsonMap.containsKey("balance") || !jsonMap.containsKey("accountType") ||
                    !jsonMap.containsKey("isActive")) {
                throw new IllegalArgumentException("JSON не содержит обязательных полей.");
            }

            // Извлечение значений
            String accountId = jsonMap.get("accountId");
            String accountHolder = jsonMap.get("accountHolder");
            double balance;
            boolean isActive;

            // Проверка формата для баланса
            try {
                balance = Double.parseDouble(jsonMap.get("balance"));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Значение баланса не является числом.");
            }

            // Проверка формата для активности
            isActive = Boolean.parseBoolean(jsonMap.get("isActive"));

            String accountType = jsonMap.get("accountType");

            // Создание и добавление объекта Account в список
            accounts.add(new Account(accountId, accountHolder, balance, accountType, isActive));
        }

        return accounts;
    }
}