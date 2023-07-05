package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenShot {
    public static void getScreenShot(WebDriver driver, String filename){
        File file= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(new SimpleDateFormat("dd_MM_HH_mm_ss").format(Calendar.getInstance().getTime())+filename+".png");
        try {
            FileUtils.copyFile(file,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
