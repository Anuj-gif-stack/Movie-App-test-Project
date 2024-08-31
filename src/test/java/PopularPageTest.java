import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {

    WebDriver driver;
    PopularPage popularPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gbmmh\\OneDrive\\Desktop\\Anuj\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);

        loginPage.enterUsernameandPassword("rahul", "rahul@2021");
        loginPage.clickLoginButton();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void getOnPopularPage(){
        popularPage.clickOnPopularSection();

    }

    @Test(priority = 2)
    public void allMoviesAreDisplayed(){
        popularPage.clickOnPopularSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertTrue(popularPage.displayOfMovies().isDisplayed(), "All movies are not displayed");
    }
}
