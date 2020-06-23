import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty( "webdriver.chrome.driver", "/Users/tahs/Selenium/ChromeDriver/chromedriver79" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }
    @AfterClass
    public void quit(){

        //driver.quit();
    }

    @Test
    public void LogIn(){
        driver.get( "http://testing.todvachev.com/test-scenarios/login-form/");

        WebElement text = driver.findElement( By.name( "userid" ) );
        text.sendKeys( "username" );
        WebElement webElement = driver.findElement( By.name( "passid" ) );
        webElement.sendKeys( "Password" );
        WebElement textarea = driver.findElement( By.name( "repeatpassid" ) );
        textarea.sendKeys( "Password" );
        WebElement checkbox = driver.findElement( By.name( "submit" ) );
        checkbox.click();
        String alert =driver.switchTo().alert().getText();
        Assert.assertEquals("Succesful login!",alert);



    }
}