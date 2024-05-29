import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddVital extends SetUp{
    @Test(priority = 1, description = "scroll up down the website view some product")
    public void addNewVital() throws Exception
    {
      //click on add vital button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/div[1]/div/button")).click();
        Thread.sleep(1000);
        //enter weight
        WebElement weight = driver.findElements(By.name("weight")).get(0);
        weight.clear();
        weight.sendKeys("65");
        Thread.sleep(1000);
        //enter height
        WebElement height = driver.findElements(By.name("height")).get(0);
        height.clear();
        height.sendKeys("174");
        Thread.sleep(1000);
        //enter Temperature (c)
        List<WebElement> temperature= driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[5]/div/input"));
        temperature.get(0).sendKeys("36.7");
        Thread.sleep(1000);
        //enter Systolic
        List<WebElement> systolic = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[6]/div/input"));
        systolic.get(0).sendKeys("110");
        Thread.sleep(1000);
        //enter Diastolic
        List<WebElement> diastolic = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[7]/div/input"));
        diastolic.get(0).sendKeys("80");
        Thread.sleep(1000);
        //enter Pulse Rate
        List<WebElement> pulseRate = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[9]/div/input"));
        pulseRate.get(0).sendKeys("72");
        Thread.sleep(1000);
        //enter Respiratory Rate
        List<WebElement> RespiratoryRate = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[10]/div/input"));
        RespiratoryRate.get(0).sendKeys("18");
        Thread.sleep(1000);
        //enter Oxygen Saturation
        List<WebElement> OxygenSaturation = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[11]/div/input"));
        OxygenSaturation.get(0).sendKeys("99");
        Thread.sleep(1000);
        //note
        List<WebElement> note = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[17]/div/textarea"));
        note.get(0).sendKeys("Test by Etu");
        Thread.sleep(1000);
       //save
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[2]/div/button[2]")).click();
        Thread.sleep(2000);
//       // asser the successful message
//        String expectedMessage = "Vital submit successfully";
//        String actualMessage = successMessage.getText();
//        Assert.assertEquals(actualMessage,expectedMessage, "Vital has been created successfully");

    }
}
