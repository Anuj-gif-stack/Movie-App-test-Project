package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/h1")
    WebElement homeHeadingText1El;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/h1")
    WebElement homeHeadingTextEl2;

    @FindBy(className = "website-logo")
    WebElement websiteLogoEl ;

    @FindBy(className = "home-movie-play-button")
    WebElement homePlayButtonEl;

    @FindBy(className = "home-container")
    WebElement homePageMovieBackground;

    @FindBy(className = "contact-us-paragraph")
    WebElement contactUsTextEl;

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomeHeadingText(){
        return homeHeadingText1El;
    }

    public WebElement getPopularHeadingText(){
        return homeHeadingTextEl2;
    }

    public WebElement getWebsiteLogo(){
        return websiteLogoEl;
    }

    public WebElement playButtonDisplay(){
        return homePlayButtonEl;
    }

    public WebElement moviesImageAreDisplay(){
        return homePageMovieBackground;
    }

    public WebElement contactText(){
        return contactUsTextEl;
    }
}
