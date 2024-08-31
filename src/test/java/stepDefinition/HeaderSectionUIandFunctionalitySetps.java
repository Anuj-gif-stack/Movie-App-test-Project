package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class HeaderSectionUIandFunctionalitySetps {

    WebDriver driver = Hooks.getDriver();

    @Given("I am on the Login Page")
    public void iAmOnTheLoginPage() {
        driver.get("https://qamoviesapp.ccbp.tech/login");
    }

    @When("I enter valid username and password")
    public void enterUsernameandPassword(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
    }

    @And("I click on login Button")
    public void clickonLoginBt(){
        driver.findElement(By.className("login-button")).click();
    }

    @And("I should be redirected to the home page")
    public void entertheHomePage(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Urls Not Matched");
    }

    @And("I want to check the website logo")
    public void chakeWebsiteLogo(){
        WebElement logo = driver.findElement(By.className("website-logo"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not Visible");
    }

    @Then("I want to check the Home, Popular text")
    public void headersectionText(){
        String expectedHomeText = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
        String expectedPopulartext = driver.findElement(By.xpath("//a[contains(text(),'Popu')]")).getText();

        Assert.assertEquals(expectedHomeText, "Home", "Home text not Match");
        Assert.assertEquals(expectedPopulartext, "Popular", "Popular Text Not match");
    }

}
