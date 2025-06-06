package ru.socksCompany;

public class Converter {
    //Преобразование шагов в километры и килокалории.
    //с методами для перевода шагов в километры (1 шаг = 0.75 м) и в килокалории (1 шаг = 50 калорий, 1 ккал = 1000 калорий).

    private static final double ONESTEPMETR = 0.75 ;
    private static final int ONESTEPCAL = 50 ;
    private static final int CCAL = 1000;


    //возвращаем перевод шагов в КМ:
    public double convertToKM() {
        double dayToKM = ONESTEPMETR / 1000;
        return dayToKM;

    }

    //возвращаем перевод шагов в ккал:
    public double convertToCcal() {
        double dayToCcal = (double) ONESTEPCAL / CCAL;
        return dayToCcal;

    }

}
