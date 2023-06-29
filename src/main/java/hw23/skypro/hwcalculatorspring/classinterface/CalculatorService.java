package hw23.skypro.hwcalculatorspring.classinterface;

public interface CalculatorService {
    String welcomePage();

    int addingNumbers(int num1, int num2);

    int minusNumbers(int num1, int num2);

    int multiplyNumbers(int num1, int num2);

    double divideNumbers(int num1, int num2);
}
