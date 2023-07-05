package config;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void befparent(){
        System.out.println("Before from parent Class");
    }

    @AfterClass
    public static void aftparent(){
        System.out.println("After from parent Class");
    }
}
