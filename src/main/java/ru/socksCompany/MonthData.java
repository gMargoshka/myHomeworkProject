package ru.socksCompany;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonthData {
    //Хранение данных и логика по подсчёту статистики для конкретного месяца.
    private int sumSteps;
    private int maxSteps;
    private double avgSteps;
    private int[] days = new int[30];

    //заполняем массив дней шагами
    public void setAmountSteps(int day, int amountSteps) {
        days[day-1] = amountSteps;
    }

    //реализовать методы для подсчёта суммы, максимума, лучшей серии, печати шагов по дням

    //возвращаем сумму шагов за месяц:
    public int getSumSteps() {
        sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;

    }
    //возвращаем максимального значения шагов:
    public int getMaxSteps() {
        maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }
    /*возвращаем все шаги за месяц (Простой вывод значений массива):
    public int[] getStepsByDay() {
        return days;
    }*/

    //возвращаем все шаги за месяц (красивое):
    public String[] getStepsByDay() {
         String[] stepsByDay = new String[days.length];

        for (int i = 0; i < days.length; i++) {
            stepsByDay[i] = String.format("День %d: %d шагов", i+1, days[i]);
        }
        return stepsByDay;
    }


    //возвращаем среднее кол-во шагов
    public double getAvgSteps() {
            int sum = 0;

            for (int i = 0; i < days.length; i++) {
                sum = sum + days[i];
            }
            avgSteps = (double) sum/days.length;
                return avgSteps;
            }
    //возвращаем пройденную дистанцию (км)
    Converter converter = new Converter();


    public double getDistance(){
        return converter.convertToKM() * sumSteps;
    }

    //возвращаем сожжённые килокалории
    public double getLostCcal(){
        return converter.convertToCcal() * sumSteps;
    }

    /*возвращаем лучший день по кол-ву шагов:
    public int getBestDays(int stepsGoal) {
        int bestDays = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= bestDays) {
                bestDays = days[i];
            }
        }
        return bestDays;
    }*/

    //возвращаем лучшую серию дней:
    public int getBestDaysGoal(int stepsGoal) {
        int bestsSeries = 0; //длина лучшей серии
        int currentSeries = 0; //счетчик

        for (int i = 0; i < days.length; i++) {
            if (days[i] >= stepsGoal) {
                currentSeries++;
                if (currentSeries > bestsSeries) {
                    bestsSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
            return bestsSeries;
    }


}
