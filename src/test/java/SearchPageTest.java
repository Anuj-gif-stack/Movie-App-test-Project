import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

import java.time.Duration;
import java.util.List;

public class SearchPageTest {

    WebDriver driver;
    WebDriverWait wait;
    SearchPage searchPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gbmmh\\OneDrive\\Desktop\\Anuj\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.enterUsernameandPassword("rahul", "rahul@2021");
        loginPage.clickLoginButton();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        searchPage.clickHomePageSearchButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1)
    public void searchFunctionality(){

        searchPage.enterSearchInput("No");
        searchPage.clickOnSearchButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.search-movies-container >li")));
        int expectedNumber = 4;

        List<WebElement> movies = driver.findElements(By.cssSelector("ul.search-movies-container >li"));
        int movieCount = movies.size();

        Assert.assertEquals(movieCount, expectedNumber, "Movies count are mismatch");
    }

    @Test(priority = 2)
    public void searchFunctionalityWithFailureCase(){

        searchPage.enterSearchInput("Noproblem");
        searchPage.clickOnSearchButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.not-found-search-image")));
        WebElement errorImage = searchPage.errorMessageImage();
        Assert.assertTrue(errorImage.isDisplayed(), "Error image is not diaplayed");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.not-found-search-paragraph")));
        String expectedErrorMessage = "Your search for Noproblem did not find any matches.";
        String actualerrorMessage = searchPage.errorMessageText();
        Assert.assertEquals(actualerrorMessage, expectedErrorMessage, "Error message not match");
    }
}
