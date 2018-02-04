package implementationFunctionTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test for  App.
 */
public class AppBaseTest {
    protected App app =  new App();

    @Test(groups = "negative", expectedExceptions = Exception.class)
    //a = 0, x = 0
    public void divideByZero() throws Exception {
       app.implFunction(0,0);
    }

    @Test(groups = "negative", expectedExceptions = Exception.class)
    //x = -a
    public void divideByZero2() throws Exception {
        app.implFunction(1, -1);
    }

    @Test(groups = "positive")
    //a = -3, x = 2
    public void simpleCountFunction() throws Exception {
        Assert.assertEquals(app.implFunction(-3, 2), -1.0);
    }

    @Test(groups = "positive")
    //a = 0, x = 2
    public void aIsZero() throws Exception {
        Assert.assertEquals(app.implFunction(0, 2), 0.5, 1e-10);
       // Assert.assertEquals(app.implFunction(0, 2), "0.5");
    }

    @Test(groups = "positive")
    //a = 2, x = 0
    public void xIsZero() throws Exception {
        Assert.assertEquals(app.implFunction(2, 0), 0.5);
    }

    @Test(groups = "positive")
    //a = Double.MAX_VALUE, x = Double.MAX_VALUE
    public void useDoubleMaxValue() throws Exception {
        Assert.assertEquals(app.implFunction(Double.MAX_VALUE, Double.MAX_VALUE), 0.0);
    }

    @Test(groups = "positive")
    //a = NEGATIVE_INFINITY, x = POSITIVE_INFINITY : Неявное деление на ноль
    public void divideByZeroUsedInfinity() throws Exception {
        Assert.assertEquals(app.implFunction(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY), Double.NaN);
    }

    @Test(groups = "positive")
    //a = NEGATIVE_INFINITY, x = NEGATIVE_INFINITY : Деление на бесконечно-маленькое число
    public void divideByNegativeInfinity() throws Exception {
        Assert.assertEquals(app.implFunction(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), 0.0, 1e-10);
    }

    @Test(groups = "positive")
    //a = POSITIVE_INFINITY, x = POSITIVE_INFINITY : Деление на бесконечно-большое число
    public void divideBPositiveInfinity() throws Exception {
        Assert.assertEquals(app.implFunction(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), 0.0);
    }



}
