package sovcombank.example.testcase.api.cleanuri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CleanuriBaseTest {
    private final String  url = "https://cleanuri.com/";

    // можно реализовать динамическое определение ОС и подстраивать путь индивидуально или же использовать базу данных но деделайн извините)
    public ArrayList<String> readUrlFromFile() {
        BufferedReader reader = null;
        ArrayList<String> urls = new ArrayList<>();

        String currentDir = System.getProperty("user.dir");

        String path = currentDir +  "\\src\\test\\resources\\cleanuri\\URL";

        try {
            // Создаем объект reader для чтения файла
            reader = new BufferedReader(new FileReader(path));
            String line;

            // Читаем файл построчно
            while ((line = reader.readLine()) != null) {
                urls.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Закрываем reader после использования
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}
