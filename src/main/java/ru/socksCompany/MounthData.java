package ru.socksCompany;

public class MounthData {
    //Хранение данных и логика по подсчёту статистики для конкретного месяца.
    private int sumSteps = 0;
    private int maxSteps = 0;
    private int[] days = new int[30];


    public void setAmountSteps(int day, int amountSteps) {
        days[day] = amountSteps;
    }

    //реализовать методы для подсчёта суммы, максимума, лучшей серии, печати шагов по дням


    public int getSumSteps() {

        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;

    }
    public int getMaxSteps() {
        for (int i = 0; i < days.length; i++) {
           if (maxSteps < days[i]) {
               maxSteps = days[i];
        }
        return maxSteps;
    }
    public void printDaySteps() {
            for (int i = 0; i < days.length; i++) {
                System.out.println(days[i]);
            }
    }

    public double getAvgSteps() {
            int sum = 0;

            for (int i = 0; i < days.length; i++) {
                sum = sum + days[i];
            }
            double avgSteps = sum/days.length;
                return avgSteps;
            }



}
