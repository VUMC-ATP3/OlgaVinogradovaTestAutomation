package mavenTestNGHomework;

import Calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCalculatorHomeWork {
private Calculator calculator;

    @Test
    public void testAddition(){
        Assert.assertEquals(calculator.addition(-4,5),1);
        Assert.assertEquals(calculator.addition(5,-6),-1);
        Assert.assertEquals(calculator.addition(4,9),13);
        Assert.assertEquals(calculator.addition(-4,-7),-11);
        Assert.assertEquals(calculator.addition(0,0),0);
        Assert.assertEquals(calculator.addition(0,7),7);
        Assert.assertEquals(calculator.addition(9,0),9);
    }

    @Test
    public void testSubstract(){
        Assert.assertEquals(calculator.substract(0,0),0);
        Assert.assertEquals(calculator.substract(0,5),-5);
        Assert.assertEquals(calculator.substract(5,0),5);
        Assert.assertEquals(calculator.substract(-5,-9),4);
        Assert.assertEquals(calculator.substract(-5,9),-14);
        Assert.assertEquals(calculator.substract(9,-5),14);
        Assert.assertEquals(calculator.substract(7,6),1);
    }

    @Test
    public void testMultiply(){
        Assert.assertEquals(calculator.multiply(0,0),0);
        Assert.assertEquals(calculator.multiply(0,7),0);
        Assert.assertEquals(calculator.multiply(7,0),0);
        Assert.assertEquals(calculator.multiply(4,5),20);
        Assert.assertEquals(calculator.multiply(-4,5),-20);
        Assert.assertEquals(calculator.multiply(-3,-4),12);
        Assert.assertEquals(calculator.multiply(3,-4),-12);
    }

    @Test
    public void testDivide(){
        Assert.assertEquals(calculator.divide(0.0,5.0),0.0);
        Assert.assertEquals(calculator.divide(6.4,3.2),2.0);
        Assert.assertEquals(calculator.divide(-7.7,4.4),-1.75);
        Assert.assertEquals(calculator.divide(4.0,-2.5), -1.6);
        Assert.assertEquals(calculator.divide(-5.0,-2.5),2.0);
    }
@BeforeMethod
    public void beforeMethod(){
    System.out.println("Tests ir sācies");
}
@BeforeClass
    public void beforeClass(){
        this.calculator = new Calculator();
}
@AfterMethod
    public void afterMethod(){
    System.out.println("Tests ir beidzies");
}

}
