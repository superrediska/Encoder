import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            ConsoleHelper.writeMessage("""
                    Выберите действие введя его номер
                    1.Зашифровать текст в файле с помощью ключа
                    2.Расшифровать текст в файле с помощью ключа
                    3.Подобрать ключ используя Bruteforce
                    4.Расшифровать текст с помощью синтаксического перебора
                    5.Выход из программы""");
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
