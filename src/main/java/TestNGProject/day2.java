package TestNGProject;

import org.testng.annotations.Test;


public class day2 {

    @Test(groups = {"Smoke"})
    public void Demo3 () {
        System.out.println("This is the Demo3 in the Day2 class");
    }


    @Test
    public void Demo4 () {
        System.out.println("This is the Demo4 in the Day2 class");
    }

}