package br.com.erudio.operations;

public class Operations {

    public Double sum(double a, double b){
        return a + b;
    }

    public Double subtraction(double a, double b){
        return a - b;
    }

    public Double multiplication(double a, double b){
        return a * b;
    }

    public Double division(double a, double b){
        return a/b;
    }

    public Double average(String[] numbers ){
        double total = 0D;
        int counter = 0;
        for (String number : numbers) {
            total += NumberConverter.convertToDouble(number);
            counter++;
        }
        if(counter == 0) return null;
        return total/counter;
    }

    public Double square(double a, int expo){
        return Math.pow(a,expo);
    }

    public Double squareRoot(double a){
        return Math.sqrt(a);
    }
}
