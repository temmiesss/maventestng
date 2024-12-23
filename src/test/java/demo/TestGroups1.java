package demo;

import org.testng.annotations.Test;

public class TestGroups1 {

    @Test(groups = "UI")
    public void testGroups1(){
        System.out.println("testGroups1");
    }

    @Test(groups = "API")
    public void testGroups2(){
        System.out.println("testGroups1");
    }

    @Test(groups = "UI")
    public void testGroups3(){
        System.out.println("testGroups1");
    }

    @Test(groups = "DB")
    public void testGroups4(){
        System.out.println("testGroups1");
    }
}
