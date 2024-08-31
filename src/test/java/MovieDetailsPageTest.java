import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MovieDetailsPageTest {
    public static void main(String[] args){
        try {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gbmmh\\OneDrive\\Desktop\\Anuj\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
            // open the chrome browser
            WebDriver driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech");

            // Login To Account
            WebElement username = driver.findElement(By.id("usernameInput"));
            username.sendKeys("rahul");

            WebElement password = driver.findElement(By.id("passwordInput"));
            password.sendKeys("rahul@2021");

            WebElement loginButton = driver.findElement(By.className("login-button"));
            loginButton.click();

            // Home Page UI Test
            String expectedHomeUrl = "https://qamoviesapp.ccbp.tech/";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expectedHomeUrl));
            Assert.assertEquals(expectedHomeUrl, driver.getCurrentUrl(), "Home Url not match");

            WebElement movieOnHomePage = driver.findElement(By.cssSelector("img[src *= 'no-time-to-']"));
            movieOnHomePage.click();

            String expectedMovieUrl = "https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
            wait.until(ExpectedConditions.urlToBe(expectedMovieUrl));
            Assert.assertEquals(expectedMovieUrl, driver.getCurrentUrl(), "Movie Url not Match");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/h1")));
            WebElement movieName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/h1"));
            String expectedMovieName = "No Time to Die";
            Assert.assertEquals(expectedMovieName, movieName.getText(), "Movie name not match");

            WebElement movieDiscription = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/p"));
            String expectedMovieDiscription = "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.";
            Assert.assertEquals(expectedMovieDiscription, movieDiscription.getText(), "Movie Discription not match");

            WebElement playButton = driver.findElement(By.className("play-button"));
            Assert.assertTrue(playButton.isDisplayed(), "Play button is not visible");

            //Categories Section(Home Page Movie)
            WebElement generesCategory = driver.findElement(By.className("genres-category"));
            Assert.assertTrue(generesCategory.isDisplayed(), "Genres category is not visible");

            WebElement audioCategory = driver.findElement(By.className("audio-category"));
            Assert.assertTrue(audioCategory.isDisplayed(), "Audio category is not visible");

            WebElement ratingCategory = driver.findElement(By.className("rating-category"));
            Assert.assertTrue(ratingCategory.isDisplayed(), "Rating category is not visible");

            WebElement budgetCategory = driver.findElement(By.className("budget-category"));
            Assert.assertTrue(budgetCategory.isDisplayed(), "Budget category is not visible");


            //More Like this Section
            List<WebElement> numberOfMoviesInMoreLikeSection = driver.findElements(By.cssSelector("li >img.image-style:first-child"));
            int expectedMoviesInMoreLikeSection = 38;
            Assert.assertEquals(expectedMoviesInMoreLikeSection, numberOfMoviesInMoreLikeSection.size(), "Number of movies in more like section are as not expected");

            //Get on Popular Section
            WebElement popularSection = driver.findElement(By.cssSelector("ul.nav-menu-list >:last-child >a"));
            popularSection.click();
            String expectedPopularSectionUrl = "https://qamoviesapp.ccbp.tech/popular";
            wait.until(ExpectedConditions.urlToBe(expectedPopularSectionUrl));
            Assert.assertEquals(expectedPopularSectionUrl, driver.getCurrentUrl(), "Urls not match");

            //Popular Page Movie UI Test
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src *= 'veno']")));
            WebElement popularPageMovie = driver.findElement(By.cssSelector("img[src *= 'venom']"));
            popularPageMovie.click();

            String expectedPopularPageMovieUrl = "https://qamoviesapp.ccbp.tech/movies/320dee56-fdb2-40cf-8df8-92b251bd781f";
            wait.until(ExpectedConditions.urlToBe(expectedPopularPageMovieUrl));
            Assert.assertEquals(driver.getCurrentUrl(), expectedPopularPageMovieUrl);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/h1")));

            WebElement popularPageMovieName = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/h1"));
            String expectedPopularPageMovieName = "Venom";
            Assert.assertEquals(expectedPopularPageMovieName, popularPageMovieName.getText(), "Movie name is not match");

            WebElement popularPageMovieDiscription = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/p"));
            String expectedPopularPageMovieDiscription = "nvestigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote.";
            Assert.assertEquals(expectedPopularPageMovieDiscription, popularPageMovieDiscription.getText(), "Movie Discription is not match");

            //Categories Section(Popular Movie Page)

            WebElement popularPageMovieGeneresCategory = driver.findElement(By.className("genres-category"));
            Assert.assertTrue(popularPageMovieGeneresCategory.isDisplayed(), "Popular Page Movie Genres category is not visible");

            WebElement popularPageMovieAudioCategory = driver.findElement(By.className("audio-category"));
            Assert.assertTrue(popularPageMovieAudioCategory.isDisplayed(), "Popular Page Movie Audio category is not visible");

            WebElement popularPageMovieRatingCategory = driver.findElement(By.className("rating-category"));
            Assert.assertTrue(popularPageMovieRatingCategory.isDisplayed(), "Popular Page Movie Rating category is not visible");

            WebElement popularPageMovieBudgetCategory = driver.findElement(By.className("budget-category"));
            Assert.assertTrue(popularPageMovieBudgetCategory.isDisplayed(), "Popular Page Movie Budget category is not visible");

            //More Like this Section(Popular Movie Page)
            List<WebElement> popularPageNumberOfMoviesInMoreLikeSection = driver.findElements(By.cssSelector("li >img.image-style:first-child"));
            int popularPageExpectedMoviesInMoreLikeSection = 33;
            Assert.assertEquals(popularPageExpectedMoviesInMoreLikeSection, popularPageNumberOfMoviesInMoreLikeSection.size(), "Number of movies in more like section are as not expected");



            driver.quit();
        }
        catch (NoSuchElementException e){
            System.out.println(e);
        }
    }
}
