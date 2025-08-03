import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие введя его номер");
            System.out.println("1.Зашифровать текст в файле с помощью ключа");
            System.out.println("2.Расшифровать текст в файле с помощью ключа");
            System.out.println("3.Подобрать ключ используя Bruteforce");
            System.out.println("4.Расшифровать текст с помощью синтаксического перебора");
            System.out.println("5.Выход из программы");
            String answer = scan.nextLine();
            switch (answer) {
                case "1" -> EncryptedDecrypted.encryptedDecrypted(true);
                case "2" -> EncryptedDecrypted.encryptedDecrypted(false);
                case "3" -> System.out.println("action 3");
                case "4" -> System.out.println("action 4");
                case "5" -> {
                    return;
                }
            }

        }
    }
}
