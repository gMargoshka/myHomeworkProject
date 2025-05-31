package ru.socksCompany;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        //Логика выбора и вывода пунктов меню:
        while (true) {
            System.out.println("Добро пожаловать в наше приложение." + "\n" + "Введите номер операции, которую хотите выполнить: ");
            System.out.println("1 - Ввести количество шагов за день");
            System.out.println("2 - Изменить цель по количеству шагов");
            System.out.println("3 - Напечатать статистику за месяц");
            System.out.println("4 - Выйти из приложения");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                }
                case 2: {
                    stepTracker.changeStepGoal();
                    break;
                }
                case 3: {
                    System.out.println("переход в Напечатать статистику за месяц");
                    break;
                }
                case 4: {
                    // Закрываем Scanner
                    scanner.close();
                    System.out.println("Пока пока!");
                    break;
                }
                default: {
                    System.out.println("Ошибка! Введена некорректная операция. Попробуйте еще раз.");
                }
            }

        }


    }
}