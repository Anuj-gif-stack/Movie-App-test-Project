import org.openqa.selenium.By;
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

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gbmmh\\OneDrive\\Desktop\\Anuj\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

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
    public void testHeadingtextofEachSections(){
        Assert.assertEquals(homePage.getHomeHeadingText().getText(), "Trending Now", "Home heading not Matched");
        Assert.assertEquals(homePage.getPopularHeadingText().getText(), "Originals", "Popular heading text not Matched");
        Assert.assertTrue(homePage.getWebsiteLogo().isDisplayed(), "Logo not Displayed");
    }

    @Test(priority = 2)
    public void testPlayButtonVisible(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-play-button")));
        Assert.assertTrue(homePage.playButtonDisplay().isDisplayed(), "Play button is not Displayed");
    }

    @Test(priority = 3)
    public void testMovieBackgroundImage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-container")));
        Assert.assertTrue(homePage.moviesImageAreDisplay().isDisplayed(), "Movie image background image is not visible");
    }

    @Test(priority = 4)
    public void testContactUsText(){
        Assert.assertEquals(homePage.contactText().getText(), "Contact Us", "Contact Text are not visible");
    }
}
