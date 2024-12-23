package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculator {
    public int add(int a, int b){
        return a + b;
    }

    public int substract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int a, int b){
        if(b == 0 ){
            throw  new ArithmeticException("Divide by zero is not allowed");
        }
        return a / b;
    }

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(2, 3),5);
    }

    @Test // аннотация
    void testSubstract() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.substract(2, 3),-1);
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(2, 3),-1);
    }

    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(3, 3),1);
        Assert.assertThrows(ArithmeticException.class, () -> {throw new ArithmeticException("Divide by zero is not allowed");});
    }
}
