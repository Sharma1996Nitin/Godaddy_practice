package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefiation {
    WebDriver driver;

    @Given("^User on the google page$")
    public void onGooglePage()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }
    @When("^User hit the Godaddy URL$")
    public void onGodaddyPage()
    {
        driver=this.driver;
        driver.get("https://www.godaddy.com/");
    }

    @Then("^Print the title of the page$")
    public void printTitlePage()
    {
        String title=driver.getTitle();
        System.out.println(title);
    }

    @And("^Login into Godaddy Site$")
    public void login()
    {
        String us= "ns1089219@gmail.com";
        String ps="9559071140";
        driver=this.driver;
        driver.findElement(By.cssSelector(".account-dropdown .icon.icon-chevron-down-lt")).click();
        driver.findElement(By.cssSelector(".act-dd-a")).click();
        driver.findElement(By.id("username")).sendKeys(us);
        driver.findElement(By.id("password")).sendKeys(ps);
        driver.findElement(By.id("submitBtn")).click();

    }


}
