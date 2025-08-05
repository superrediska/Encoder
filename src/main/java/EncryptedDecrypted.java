import lombok.SneakyThrows;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EncryptedDecrypted {

    @SneakyThrows
    public static void encryptedDecrypted(boolean flag) {
        ConsoleHelper.writeMessage("Введите адрес файла для его " + (flag ? "" : "раc") + "шифровки");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите ключ");
        int key = ConsoleHelper.readInt();

        Path dst = ConsoleHelper.buildFileName(src, (flag ? "_e" : "_d"));
        CaesarCipher caesarCipher = new CaesarCipher();
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(Path.of(src));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(dst);
        ) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = flag ? caesarCipher.encrypt(string, key) : caesarCipher.decrypt(string, key);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
    }
}
