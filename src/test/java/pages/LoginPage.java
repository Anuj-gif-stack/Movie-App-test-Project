package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(className = "login-website-logo")
    WebElement websitelogoImageEl;

    @FindBy(className = "sign-in-heading")
    WebElement headingTextEl;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/form/div[1]/label")
    WebElement usrnameLebelTextEl;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/form/div[2]/label")
    WebElement passwordLebelTextEl;

    @FindBy(className = "login-button")
    WebElement loginButtonEl;

    @FindBy(id = "usernameInput")
    WebElement enterUserNameEl;

    @FindBy(id = "passwordInput")
    WebElement enterPasswordEl;

    @FindBy(className = "error-message")
    WebElement getErrorMessageEl ;

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findWebsiteLogoImage(){
        return websitelogoImageEl;
    }

    public WebElement getHeadingText(){
        return headingTextEl;
    }

    public WebElement getUsernameLebel(){
        return usrnameLebelTextEl;
    }

    public WebElement getPasswordLebel(){
        return passwordLebelTextEl;
    }

    public void clickLoginButton(){
        loginButtonEl.click();
    }

    public void enterUsernameandPassword(String username, String password){
        enterUserNameEl.sendKeys(username);
        enterPasswordEl.sendKeys(password);
    }

    public WebElement errorTextMessage(){
        return getErrorMessageEl;
    }
}
