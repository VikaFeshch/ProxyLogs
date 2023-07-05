import config.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.ScreenShot;
import util.WorkWithFile;

import java.util.ArrayList;
import java.util.List;

public class GoogleTest extends BaseClass {
    static final String url = "https://www.youtube.com";
    @BeforeClass
    public static void st(){
        driver.get(url);
    }
    @Test
    public void test1(){
     //   driver.findElement(By.name("q")).sendKeys("Ukraine");
       // driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        List<String> list=new ArrayList<>();
        list.add("Vika");
        list.add("Valery");
        list.add("Vero");
        WorkWithFile.writeStrings(list,"names");
        System.out.println(WorkWithFile.readFile("04_07_17_37_28names.txt"));
        ScreenShot.getScreenShot(driver,"test1");
    }
}
