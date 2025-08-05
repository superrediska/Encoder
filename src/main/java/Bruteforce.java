import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Bruteforce {
    @SneakyThrows
    public static void bruteforce(){
        Scanner scan = new Scanner(System.in);
        ConsoleHelper.writeMessage("Введите путь к файлу для его расшифровки");
        String src = scan.nextLine();
        ConsoleHelper.writeMessage("Введите путь к файлу куда записать результат");
        Path dst = ConsoleHelper.buildFileName(src, "_brute");
        try (BufferedReader reader = Files.newBufferedReader(Path.of(src));
             BufferedWriter writer = Files.newBufferedWriter(dst);
        ) {
        }

    }
}
