import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AddVital extends SetUp{
    @Test(priority = 1, description = "scroll up down the website view some product")
    public void addNewVital() throws Exception
    {
      //click on add vital button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div/div[1]/div/button")).click();
        Thread.sleep(1000);
    }
}
