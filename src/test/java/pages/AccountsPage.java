package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
    @FindBy(className = "avatar-button")
    WebElement accountButtonEl;

    @FindBy(className = "account-heading")
    WebElement accountHeadingEl;

    @FindBy(className = "logout-button")
    WebElement logoutButtonEl;

    @FindBy(className = "membership-username")
    WebElement membershipUsernameEl;

    @FindBy(className = "membership-password")
    WebElement membershipPassword;

    @FindBy(className = "plan-details-container")
    WebElement planDetailsEl;

    WebDriver driver;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAccountButtonEl(){
        accountButtonEl.click();
    }

    public WebElement getAccountHeadingEl(){
        return accountHeadingEl;
    }

    public WebElement getMembershipUsernameEl(){
        return membershipUsernameEl;
    }

    public WebElement getMembershipPassword(){
        return membershipPassword;
    }

    public WebElement getPlanDetailsEl(){
        return planDetailsEl;
    }

    public WebElement setLogoutButtonEl(){
        return logoutButtonEl;
    }
}
