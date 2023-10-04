package jptv22game;

import java.util.Random;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final Random random;
    public App() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }
    public void run(){
        boolean repeat = true;
        System.out.println("");
        System.out.println("--- GuessGame ---");
        System.out.println("");
        
        do{
            System.out.println("0. Выход");
            System.out.println("1. Начать игру");
            System.out.print("Номер задачи: ");  
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    System.out.println("Выбран выход");
                    System.out.println("");
                    System.out.println("------------------------");
                    System.out.println("");
                    repeat = false;
                    break;                    
                
                case 1:
                    System.out.println("Игра началась!");
                    int secretNumber = random.nextInt(11); // Генерация случайного числа от 0 до 10
                    int maxAttempts = 3; // Макс колво попыток
                    boolean win = false;
                    System.out.println("");
                    System.out.println("Угадайте число от 0 до 10. У вас есть " + maxAttempts + " попытки.");
                    
                    for (int attempts = 1; attempts <= maxAttempts; attempts++){
                        System.out.print("Попытка #" + attempts + ": Введите ваше число: ");
                        
                        if (scanner.hasNextInt()){
                            int userGuess = scanner.nextInt();
                            scanner.nextLine();
                            
                            if (userGuess >= 0 && userGuess <= 10){
                                if (userGuess == secretNumber){
                                    System.out.println("Поздравляем! Вы угадали число.");
                                    win = true;
                                    break;
                                } else if (userGuess < secretNumber){
                                    System.out.println("Число больше. Попробуйте ещё раз."); 
                                }  else {
                                    System.out.println("Число меньше. Попробуйте ещё раз.");  
                                }                            
                            } else {
                                System.out.println("Введите число в диапазоне от 0 до 10.");     
                            }
                        } else {
                            System.out.println("Введите корректное число.");
                            scanner.nextLine(); // Очищаем буфер ввода
                        }
                    }
                    if (!win){
                        System.out.println("Вы проиграли. Верное число: " + secretNumber);
                    }
                    
                    System.out.print("Хотите сыграть ещё раз? (Да - любая клавиша, Выйти - q): ");
                    String playAgain = scanner.nextLine().toLowerCase();   
                    
                    if ("q".equals(playAgain)){
                        System.out.println("Игра завершена.");    
                    }
                    break;
                default:
                    System.out.println("ERROR");
                    System.out.println("Выберайте номер задачи из списка!");
            }
            
        }while(repeat);
    }
}