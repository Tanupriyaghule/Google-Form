package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        WebElement nameField = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[2]/div[1]/div/div/div[1]/div"));
        nameField.sendKeys("John Doe");
        WebElement automationReasonField = driver.findElement(By.xpath("//*[@id='i5']/span[1]"));
        automationReasonField.sendKeys("I want to improve efficiency in testing processes.");
        WebElement experienceField = driver.findElement(By.xpath("//*[@id='i9']/span[1]"));
        experienceField.click();
        String experienceRange = "0 - 2";

        switch (experienceRange) {
            case "0 - 2":
                WebElement checkbox0to2 = driver.findElement(By.xpath("//*[@id='i9']/div[3]/div/div"));
                checkbox0to2.click();
                break;
            case "3 - 5":
                WebElement checkbox3to5 = driver.findElement(By.xpath("//*[@id='i9']/div[3]/div/div"));
                checkbox3to5.click();
                break;
            case "6 - 10":
                WebElement checkbox6to10 = driver.findElement(By.xpath("//*[@id='i9']/div[3]/div/div"));
                checkbox6to10.click();
                break;
            case "> 10":
                WebElement checkboxGreaterThan10 = driver.findElement(By.xpath("//*[@id='i9']/div[3]/div/div"));
                checkboxGreaterThan10.click();
                break;
            default:
                System.out.println("Invalid experience range provided");
                break;
        }

        WebElement learnedField = driver.findElement(By.xpath("//*[@id='i25']/span[1]"));
        WebElement optionSelenium = driver.findElement(By.xpath("//*[@id='i25']/div[3]/div"));
        optionSelenium.click();
        WebElement addressField = driver.findElement(By.xpath("//*[@id='i42']/span[1]"));
        addressField.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement optionsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i42']/div[3]")));
        WebElement option = driver.findElement(By.xpath("//*[@id='i42']/div[3]/div/div[1]"));
        option.click();
        WebElement date = driver.findElement(By.xpath("//*[@id='i46']/span[1]"));
        WebElement datepicker = driver.findElement(By.xpath("//*[@id='i46']/div[3]"));
        datepicker.click();
        WebElement time = driver.findElement(By.xpath("//*[@id='i51']/span[1]"));
        WebElement timepicker = driver.findElement(By.xpath("//*[@id='i51']/div[3]/div/div"));
        timepicker.sendKeys("12:33");
        WebElement submit = driver.findElement(By.xpath("//*[@id='mG61Hd']/div[2]/div/div[3]/div[1]/div[1]/div/span/span"));
        submit.click();
        System.out.println("End Test case: testCase01");
    }
}
