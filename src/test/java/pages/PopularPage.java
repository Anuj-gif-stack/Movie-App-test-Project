package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PopularPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]")
    WebElement moviesAreDisplayed;

    @FindBy(css = ".active-nav-link")
    WebElement popularSectionEl;

    public PopularPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement displayOfMovies(){
        return moviesAreDisplayed;
    }

    public void clickOnPopularSection(){
        popularSectionEl.click();
    }
}
