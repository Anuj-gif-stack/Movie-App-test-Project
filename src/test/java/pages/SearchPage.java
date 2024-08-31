package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchPage {

    By homePageSearchButton = By.className("search-empty-button");

    By searchInputEl = By.cssSelector("input#search");

    By searchButtonEl = By.cssSelector(".search-button") ;

    By errorMessageImageEl = By.cssSelector("img.not-found-search-image") ;

    By errorMessageEl = By.cssSelector("p.not-found-search-paragraph");

    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickHomePageSearchButton(){
        driver.findElement(homePageSearchButton).click();
    }

    public void enterSearchInput(String movieName){
        driver.findElement(searchInputEl).sendKeys(movieName);
    }

    public void clickOnSearchButton(){
        driver.findElement(searchButtonEl).click();
    }

    public WebElement errorMessageImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageImageEl));
        WebElement messageImage = driver.findElement(errorMessageImageEl);
        return messageImage;
    }

    public String errorMessageText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEl));
        WebElement errorMessage = driver.findElement(errorMessageEl);
        return errorMessage.getText();
    }
}
