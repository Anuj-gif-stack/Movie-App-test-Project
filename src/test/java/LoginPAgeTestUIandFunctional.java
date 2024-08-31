import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPAgeTestUIandFunctional {

    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gbmmh\\OneDrive\\Desktop\\Anuj\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testWebsiteLogo(){
        Assert.assertTrue(loginPage.findWebsiteLogoImage().isDisplayed(), "App logo is not displayed");
    }

    @Test(priority = 2)
    public void testHeadingText(){
        Assert.assertEquals(loginPage.getHeadingText().getText(), "Login", "Heading Text not match");
    }

    @Test(priority = 3)
    public void testLoginUIandFunctionality(){
        Assert.assertEquals(loginPage.getUsernameLebel().getText(),"USERNAME", "Username lebel not Match");
        Assert.assertEquals(loginPage.getPasswordLebel().getText(), "PASSWORD", "PAssword Lebel not Match");

        loginPage.enterUsernameandPassword("rahul", "rahul@2021");
        loginPage.clickLoginButton();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Urls not Matched");
    }

    @Test(priority = 4)
    public void testLoginwithInvalidCredentials(){
        Assert.assertEquals(loginPage.getUsernameLebel().getText(),"USERNAME", "Username lebel not Match");
        Assert.assertEquals(loginPage.getPasswordLebel().getText(), "PASSWORD", "PAssword Lebel not Match");

        loginPage.enterUsernameandPassword("rahul", "rahul2021");
        loginPage.clickLoginButton();

        String expectedError = "*username and password didn't match";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        Assert.assertEquals(loginPage.errorTextMessage().getText(), expectedError, "Error message not Matched");
    }

}
