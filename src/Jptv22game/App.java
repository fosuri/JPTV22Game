package jptv22game;

import java.util.Random;
import java.util.Scanner;

public class App {

    public void run() {
        System.out.println("---игра---");
        Random random = new Random();
        boolean repeat = true;
        int maxAttempts = 3; // Максимальное количество попыток

        do {
            int myNumber = random.nextInt(11); // Генерация числа от 0 до 10
            int attempts = 0; // Счетчик попыток

            System.out.println("Угадайте загаданное число от 0 до 10. У вас 3 попытки.");
            Scanner scanner = new Scanner(System.in);

            while (attempts < maxAttempts) {
                String userInput = scanner.next();
                int userNumber;

                try {
                    userNumber = Integer.parseInt(userInput);
                } catch (NumberFormatException e) {
                    System.out.println("Нужно ввести число.");
                    continue; // Пропускаем текущую попытку
                }

                if (userNumber < 0 || userNumber > 10) {
                    System.out.println("Число должно быть в диапазоне от 0 до 10.");
                    continue; // Пропускаем текущую попытку
                }

                attempts++;

                if (myNumber == userNumber) {
                    System.out.println("Ты выиграл");
                    break; // Выход из цикла, если число угадано
                } else if (attempts < maxAttempts) {
                    if (myNumber < userNumber) {
                        System.out.println("Твоё число больше.");
                    } else {
                        System.out.println("Твоё число меньше.");
                    }
                    System.out.println("Осталось " + (maxAttempts - attempts) + " попыток.");
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Ты использовал все попытки. Моё число " + myNumber);
                System.out.println("Нажмите 'q' для выхода, или любую другую клавишу для продолжения.");
                String q = scanner.next();
                if (q.equals("q")) {
                    repeat = false;
                }
            } else {
                System.out.println("Нажмите 'q' для выхода, или любую другую клавишу для продолжения.");
                String q = scanner.next();
                if (q.equals("q")) {
                    repeat = false;
                }
            }
        } while (repeat);

        System.out.println("---игра окончена---");
    }
}