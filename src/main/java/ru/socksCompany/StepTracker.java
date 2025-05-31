package ru.socksCompany;

import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {
    //Логика сохранения шагов, ввода данных, изменения ежедневной нормы и вывода статистики.
    private int stepsGoal; // объявление переменной цели шагов
    private final MonthData[] monthToData; // объявление массива месяцев

    public StepTracker() { // конструктор
        stepsGoal = 10000; // присваиваю значение 10000 по умолчанию
        monthToData = new MonthData[12]; //создаю массив на 12 элементов
        for (int i = 0; i < monthToData.length; i++) { //заполняю массив объектами
            monthToData[i] = new MonthData();
        }
    }


    //Вводим количество шагов за день (запросить месяц, день, количество шагов, проверить корректность, сохранить результат):
    public void addNewNumberStepsPerDay() {

        //сканер для ввода инфо:
        Scanner scanner = new Scanner(System.in);

        //просим ввести месяц:
        System.out.println("Введите месяц (1-12): ");
        int mounth = scanner.nextInt();
        if (mounth < 1 || mounth > 12) {

            System.out.println("Некорректный месяц: " + mounth + ", корректное значение 1-12");
            return;
        }
        //просим ввести день:
        System.out.println("Введите число (1-30): ");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Некорректный день месяца: " + day + ", корректное значение 1-30");
            return;
        }
        //просим ввести кол-во шагов:
        System.out.println("Введите кол-во шагов: ");
        int amountSteps = scanner.nextInt();
        if(amountSteps<0){
            System.out.println("Некорректное кол-во шагов: " + amountSteps + ", корректное значение >=0");
            return;
        }

        //сохраняем данные:
        monthToData[mounth-1].setAmountSteps(day, amountSteps);

    }


    //Меняем цель по количеству шагов в день (изменить цель по шагам (с проверкой корректности)):
    public void changeStepGoal() {

        //сканер для ввода инфо:
        Scanner scanner = new Scanner(System.in);

        //просим ввести кол-во шагов: (надо подумать потом как отрефакторить повторяющиеся методы)
        System.out.println("Введите кол-во шагов для цели (по умолчанию 10000): ");
        int changeStepsGoal = scanner.nextInt();
        if (changeStepsGoal==10000) {
            System.out.println("Такое значение уже указано по умолчанию! Введите другое значение.");
            return;
        }

        //сохраняем данные:
        stepsGoal = changeStepsGoal;
    }

    //Выводим статистику шагов за определенный месяц ( запросить номер месяца, вывести):

    public void printStatistic() {
        //сканер для ввода инфо:
        Scanner scanner = new Scanner(System.in);

        //просим ввести месяц:
        System.out.println("Введите месяц: ");
        int month = scanner.nextInt();


        //выводим инфо по статистике
        System.out.println("Список шагов по дням: " + Arrays.toString(monthToData[month-1].getStepsByDay()));
        System.out.println("Общее количество шагов за месяц: " + monthToData[month-1].getSumSteps());
        System.out.println("Максимальное количество шагов за день: " + monthToData[month-1].getMaxSteps());
        System.out.println("Среднее количество шагов: " + monthToData[month-1].getAvgSteps());
        System.out.println("Пройденная дистанция (км): " + monthToData[month-1].getDistance());
        System.out.println("Сожжённые килокалории: " + monthToData[month-1].getLostCcal());
        System.out.println("Лучшая серия дней, когда шагов было не меньше цели: " + monthToData[month-1].getBestDaysGoal(stepsGoal));
    }


}
