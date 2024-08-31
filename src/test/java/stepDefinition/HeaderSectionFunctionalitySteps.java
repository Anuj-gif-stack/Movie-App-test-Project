package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderSectionFunctionalitySteps {

    WebDriver driver = Hooks.getDriver();

    @And("I check the navigation to Home page and Popular page")
    public void navigationToHomeAndPopularPage(){
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Urls not match");

        driver.findElement(By.xpath("//a[contains(text(),'Popu')]")).click();

        String expectedPopularpageUrl = "https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(expectedPopularpageUrl, driver.getCurrentUrl(), "Urls not match");
    }

    @Then("I check the navigation to account page")
    public void navigateToAccountPage(){
        driver.findElement(By.className("avatar-button")).click();

        String expectedUrl = "https://qamoviesapp.ccbp.tech/account";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(), "Urls not match");
    }
}
