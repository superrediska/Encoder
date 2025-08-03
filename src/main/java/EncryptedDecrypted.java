import lombok.SneakyThrows;

import java.io.*;
import java.util.Scanner;

public class EncryptedDecrypted {

    @SneakyThrows
    public static void encryptedDecrypted(boolean flag)  {
        if (flag) {
            System.out.println("Введите адрес файла для его расшифровки");
        } else {
            System.out.println("Введите адрес файла для его дешифровки");
        }
        Scanner scan = new Scanner(System.in);
        String src = scan.nextLine();
        System.out.println("Введите ключ");
        int key = Integer.parseInt(scan.nextLine());
        System.out.println("Введите адрес файла куда записать результат");
        String dst = scan.nextLine();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (
                FileReader fileReader = new FileReader(src);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                FileWriter fileWriter = new FileWriter(dst);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            while (bufferedReader.ready()) {
                String string = bufferedReader.readLine();
                String result = null;
                if (flag) {
                    result = caesarCipher.encrypt(string, key);

                } else {
                    result = caesarCipher.decrypt(string, key);
                }
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
        }
    }
}
