package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedTests {

    @Test
    @Parameters("browser")
    public void test(@Optional("kekus") String browser ){
        System.out.println("Browser " + browser);
    }
}
