package hw23.skypro.hwcalculatorspring.controller;

import hw23.skypro.hwcalculatorspring.classinterface.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
1. /calculator повторяется. Рекомендуется использовать @RequestMapping на уровне контроллера.
 */
@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcomePage() {
        return calculatorService.welcomePage();
    }

    @GetMapping(path = "/plus")
    public String addingNumbers(@RequestParam(value = "num1", required = false) Integer num1,
                                @RequestParam(value = "num2", required = false) Integer num2) {

        return buildView(num1, " + ", num2);
    }

    @GetMapping(path = "/minus")
    public String minusNumbers(@RequestParam(value = "num1", required = false) Integer num1,
                               @RequestParam(value = "num2", required = false) Integer num2) {

        return buildView(num1, " - ", num2);
    }

    @GetMapping(path = "/multiply")
    public String multiplyNumbers(@RequestParam(value = "num1", required = false) Integer num1,
                                  @RequestParam(value = "num2", required = false) Integer num2) {

        return buildView(num1, " * ", num2);
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam(value = "num1", required = false) Integer num1,
                                @RequestParam(value = "num2", required = false) Integer num2) {

        return buildView(num1, " / ", num2);
    }


    private String buildView(Integer num1, String operation, Integer num2) {
        Number result;

        if (num1 == null || num2 == null) {
            return "Не передан один или несколько параметров";
        }

        if (" / ".equals(operation) && num2 == 0) {
            return "На 0 делить нельзя!";
        }
        switch (operation) {
            case " - ":
                result = calculatorService.minusNumbers(num1, num2);
                break;
            case " * ":
                result = calculatorService.multiplyNumbers(num1, num2);
                break;
            case " / ":
                result = calculatorService.divideNumbers(num1, num2);
                break;
            default:
                result = calculatorService.addingNumbers(num1, num2);
        }
        return num1 + operation + num2 + " = " + result;
    }
}
