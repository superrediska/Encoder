import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Bruteforce {
    @SneakyThrows
    public static void bruteforce() {
        ConsoleHelper.writeMessage("Введите путь к файлу для его расшифровки");
        String src = ConsoleHelper.readString();
        Path dst = ConsoleHelper.buildFileName(src, "_brute");
        CaesarCipher caesarCipher = new CaesarCipher();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst);
        ) {
            List<String> list = new ArrayList<>();

            while (reader.ready()) {
                String string = reader.readLine();
                list.add(string);

            }
            String fullText = String.join("", list);
            for (int i = 0; i < caesarCipher.alphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(fullText, i);
                if (isValidateText(decrypt)) {
                    for (String string : list) {
                        String result = caesarCipher.decrypt(string, i);
                        writer.write(result);
                        writer.newLine();
                    }
                    ConsoleHelper.writeMessage("Содержимое файла расшифровано, ключ расшифровки равен " + i);
                    break;
                }
            }
        }
    }

    private static boolean isValidateText(String text) {
        String[] strings = text.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > 28) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("? ") || text.contains("! ")) {
            isValidate = true;
        }
        while (isValidate) {
            ConsoleHelper.writeMessage(text.length() < 100 ? text : text.substring(0, 100));
            ConsoleHelper.writeMessage("Понятен ли вам этот текст? (y/n)");
            String answer = ConsoleHelper.readString();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                isValidate = false;

            } else {
                ConsoleHelper.writeMessage("Выбрать можно только y/n");
            }

        }
        return false;
    }
}


