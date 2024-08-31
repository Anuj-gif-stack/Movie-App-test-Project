import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    AccountsPage accountsPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gbmmh\\OneDrive\\Desktop\\Anuj\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);

        loginPage.enterUsernameandPassword("rahul", "rahul@2021");
        loginPage.clickLoginButton();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void accountPageUITest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));

        accountsPage.setAccountButtonEl();

        String accountHeading = accountsPage.getAccountHeadingEl().getText();
        String expectedAccountHeading = "Account";
        Assert.assertEquals(accountHeading, expectedAccountHeading, "Heading not match");

        String membershipUsername = accountsPage.getMembershipUsernameEl().getText();
        Assert.assertEquals(membershipUsername,"User name : rahul", "Username not match");

        String membershipPassword = accountsPage.getMembershipPassword().getText();
        Assert.assertEquals(membershipPassword, "Password : **********", "Password not match");

        Assert.assertTrue(accountsPage.getPlanDetailsEl().isDisplayed(), "Plan Details are not displayed");

        Assert.assertTrue(accountsPage.setLogoutButtonEl().isDisplayed(), "Logout Button is not displayed");
    }

    @Test(priority = 2)
    public void logOutAccountTest(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));

        accountsPage.setAccountButtonEl();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout-button")));
        accountsPage.setLogoutButtonEl().click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Url not match");
    }
}
