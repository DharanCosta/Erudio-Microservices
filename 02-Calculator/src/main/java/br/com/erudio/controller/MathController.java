package br.com.erudio.controller;

import br.com.erudio.operations.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

   Operations operations = new Operations();

    @GetMapping ("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        NumberConverter.isNumeric(numberOne);
        NumberConverter.isNumeric(numberTwo);
        return operations.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping ("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        NumberConverter.isNumeric(numberOne);
        NumberConverter.isNumeric(numberTwo);
        return operations.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping ("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        NumberConverter.isNumeric(numberOne);
        NumberConverter.isNumeric(numberTwo);
        return operations.multiplication(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping ("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        NumberConverter.isNumeric(numberOne);
        NumberConverter.isNumeric(numberTwo);
        return operations.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @GetMapping ("/average/{numbers}")
    public Double average(@PathVariable("numbers") String[] numbers){
        for (String number : numbers) {
          NumberConverter.isNumeric(number);
        }
        return operations.average(numbers);
    }

    @GetMapping ("/square/{number}")
    public Double square(@PathVariable("number") String number) {
        NumberConverter.isNumeric(number);
        return operations.square(NumberConverter.convertToDouble(number), 2);
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable("number") String number) {
        NumberConverter.isNumeric(number);
        return operations.squareRoot(NumberConverter.convertToDouble(number));
    }

}
