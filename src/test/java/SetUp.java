import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SetUp {
    WebDriver driver;
    @BeforeTest
    public void driverSetUp() throws Exception

    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ibos\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        Thread.sleep(1000);
        // visit website
        driver.get("https://staging-scweb.arcapps.org/");
        Thread.sleep(1000);
        // login
        //enter username
        List<WebElement> userName = driver.findElements(By.name("username"));
        userName.get(0).sendKeys("tester");
        Thread.sleep(1000);
        //enter password
        List<WebElement> password = driver.findElements(By.name("password"));
        password.get(0).sendKeys("tester2023!");
        Thread.sleep(1000);
        //click ok login button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[4]/button")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 0, description = "should select facility after login")

    public void selectFacility() throws Exception
    {
        // select province
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[1]/select"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Lusaka");
        Thread.sleep(2000);
        // select District
        WebElement dropdownElement1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[2]/select"));
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByVisibleText("Lusaka");
        Thread.sleep(2000);
         //select Facility
        // Locate the input element
        WebElement facilityInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[3]/div/div[2]/input"));

        // Send the search query
        facilityInput.sendKeys("Dr Watson Dental Clinic");

        // Wait for the dropdown suggestions to appear
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[3]/div/div[2]/div/div[3]")));

        // Iterate through suggestions and click the one that matches the search query
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equals("Dr Watson Dental Clinic")) {
                suggestion.click();
                break;
            }
        }
        //click on enter button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[3]/button")).click();
        Thread.sleep(1000);
        //click on NRC
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[1]/button[2]")).click();
        //enter number
        List<WebElement> nrc = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/form/div[1]/div/div/input"));
        nrc.get(0).sendKeys("111111111");
        Thread.sleep(1000);
        //click on search button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/form/div[2]/button")).click();
        Thread.sleep(1000);
        //click on attend to patient button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[3]/div[2]/div/div/div[2]/div[2]/button[4]")).click();
        Thread.sleep(1000);
        //click on Vital box
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div/a/div")).click();
        Thread.sleep(1000);

    }
}
