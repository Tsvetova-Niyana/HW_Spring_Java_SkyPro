package hw23.skypro.hwcalculatorspring.service;

import hw23.skypro.hwcalculatorspring.classinterface.CalculatorService;
import org.springframework.stereotype.Service;

/*
Написать 5 методов, которые при вызове из браузера делают следующее:

1. Метод по адресу /calculator должен вернуть приветствие “Добро пожаловать в калькулятор".
2. Метод по адресу /calculator/plus?num1=5&num2=5 должен сложить num1 и num2
    и вернуть результат в формате “5 + 5 = 10”.
3. Метод по адресу /calculator/minus?num1=5&num2=5 должен вычесть из num1 num2
    и вернуть результат в формате “5 − 5 = 0”.
4. Метод по адресу /calculator/multiply?num1=5&num2=5 должен умножить num1 на num2
    и вернуть результат в формате “5 * 5 = 25”.
5. Метод по адресу /calculator/divide?num1=5&num2=5 должен разделить num1 на num2
    и вернуть результат в формате “5 / 5 = 1”.
    Деление на 0 в Java выкидывает ошибку.
 */

@Service
public class CalculatorServiceImpl implements CalculatorService {


    public String welcomePage() {
        return "Добро пожаловать в калькулятор";
    }


    public int addingNumbers(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }


    public int minusNumbers(int num1, int num2) {
        int differenceResult = num1 - num2;
        return differenceResult;
    }


    public int multiplyNumbers(int num1, int num2) {
        int multiplyResult = num1 * num2;
        return multiplyResult;
    }


    public double divideNumbers(int num1, int num2) {
        double divideResult = num1 / (double)num2;
        return divideResult;
    }
}
