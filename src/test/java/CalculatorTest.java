import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    @Test
    public void testsum(){ //testa metode neko neatgriez. Tas ir Unit test
        Calculator calculator = new Calculator();
        int actualResult = calculator.sum(5, 3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(calculator.sum(-5,3),-2);
        Assert.assertEquals(calculator.sum(-5,-3),-8);
        Assert.assertEquals(calculator.sum(0,-3),-3);
        Assert.assertEquals(calculator.sum(2,0),2);
        Assert.assertEquals(calculator.sum(0,0),0);

        System.out.println("This is my first test ever");
    }
    @Test
    public void dalisanasTests(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(8.2,2.0),4.1);
    }
@BeforeClass
    public void beforeClass(){
    System.out.println("Izpildas before class"); //izpildas si anotacija pirms testa
}

//    @BeforeClass
//    public void beforeClass(){
//        this.calculator = new Calculator();
//    }
// private Calculator calculator; <---- augsa nomainit
//
////////////////////////////////////////////
//@BeforeTest
//public void izpilditPirmsKatraTesta(){
//    System.out.println("Izpildas before test.");
//}



}