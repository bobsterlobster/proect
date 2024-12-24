package Practika;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.json"; // Укажите путь к вашему файлу JSON

        try {
            String json = FileUtil.readJsonFromFile(filePath);
            JsonParser parser = new JsonParser();
            List<Account> accounts = parser.parseJson(json);
            System.out.println("Созданные объекты Account:");
            for (Account account : accounts) {
                System.out.println(account);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка парсинга JSON: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
