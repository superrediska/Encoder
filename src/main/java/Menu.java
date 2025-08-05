import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            ConsoleHelper.writeMessage("Выберите действие введя его номер");
            ConsoleHelper.writeMessage("1.Зашифровать текст в файле с помощью ключа");
            ConsoleHelper.writeMessage("2.Расшифровать текст в файле с помощью ключа");
            ConsoleHelper.writeMessage("3.Подобрать ключ используя Bruteforce");
            ConsoleHelper.writeMessage("4.Расшифровать текст с помощью синтаксического перебора");
            ConsoleHelper.writeMessage("5.Выход из программы");
            String answer = scan.nextLine();
            switch (answer) {
                case "1" -> EncryptedDecrypted.encryptedDecrypted(true);
                case "2" -> EncryptedDecrypted.encryptedDecrypted(false);
                case "3" -> ConsoleHelper.writeMessage("action 3");
                case "4" -> ConsoleHelper.writeMessage("action 4");
                case "5" -> {
                    return;
                }
            }

        }
    }
}
