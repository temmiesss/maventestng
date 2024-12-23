package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Text {
    public  String printFirstTwoLetters(String text){
        return text.substring(0, 2).toLowerCase() + text.substring(2);
    }

    @Test
    public void test(){
        Text text = new Text();
        String result = "Hello World!";
        Assert.assertTrue(text.printFirstTwoLetters(result).charAt(0) == 'h');
    }
}
