package jptv22game;
import java.util.Random;
import java.util.Scanner;

public class App{
    private final Scanner scanner;
    private final Random random;
    private int balance;
   
    public App() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.balance = 0; // Изначально баланс равен 0
    }
   
    public void run() {
        boolean repeat = true;
        System.out.println("--- GuessGame ---");

        do {
            System.out.println("0. Назад в меню");
            System.out.println("1. Сыграть в игру угадай число");
            System.out.println("2. Пополнить баланс");
            System.out.println("Текущий баланс: " + balance);
            System.out.print("Номер задачи: ");  
            int task = scanner.nextInt();
            scanner.nextLine();

            switch (task) {
                case 0:
                    System.out.println("Выбран выход в меню");
                    repeat = false;
                    break;
                case 1:
                    if (balance <= 0) {
                        System.out.println("У вас недостаточно средств на балансе. Пополните баланс.");
                    } else {
                        playGuessNumberGame();
                    }
                    break;
                case 2:
                    System.out.print("Введите сумму для пополнения баланса: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    if (amount > 0) {
                        balance += amount;
                        System.out.println("Баланс успешно пополнен. Текущий баланс: " + balance);
                    } else {
                        System.out.println("Введите положительную сумму для пополнения баланса.");
                    }
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите 0, 1 или 2.");
            }
        } while (repeat);
    }

    private void playGuessNumberGame() {
        int secretNumber = random.nextInt(11); // Генерация случайного числа от 0 до 10
        int maxAttempts = 3;
        boolean win = false;
       
        System.out.println("Угадайте число от 0 до 10. У вас есть " + maxAttempts + " попытки.");
       
        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Попытка #" + attempts + ": Введите ваше число: ");
           
            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();
                scanner.nextLine();
               
                if (userGuess >= 0 && userGuess <= 10) {
                    if (userGuess == secretNumber) {
                        System.out.println("Поздравляем! Вы угадали число.");
                        win = true;
                        balance +=10;
                        break;
                    } else {
                        System.out.println("Число не угадано. Попробуйте ещё раз.");
                        balance--; // Снимаем 1 с баланса за неправильную попытку
                    }
                } else {
                    System.out.println("Введите число в диапазоне от 0 до 10.");
                }
            } else {
                System.out.println("Введите корректное число.");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }

        if (!win) {
            System.out.println("Вы проиграли. Верное число: " + secretNumber);
        }

        System.out.print("Хотите сыграть ещё раз? (Да - любая клавиша, Выйти - q): ");
        String playAgain = scanner.nextLine().toLowerCase();
       
        if ("q".equals(playAgain)) {
            System.out.println("Игра завершена.");
        }
    }
}