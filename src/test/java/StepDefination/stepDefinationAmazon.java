package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class stepDefinationAmazon {
    WebDriver driver;

    @Given("^User on google page$")
    public void googlePage()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver=this.driver;

        driver.get("https://www.google.com/");

    }
    @When("^User hit the Amazon URL$")
    public void amazonPage()
    {
        driver=this.driver;
        driver.get("https://www.amazon.in/");
    }

    @Then("^Print and validate the title of the page$")
    public void validateTitle()
    {

        driver=this.driver;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       //click on flag button
        Actions action = new Actions(driver);
        By bb = By.xpath("//div[@id=\"nav-flyout-icp\"]//a[8]");

       WebElement flag=  driver.findElement(By.xpath("//div[@id=\"nav-tools\"]//a[1]"));
       action.moveToElement(flag).perform();
       Wait wait =new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bb));
       WebElement loc = driver.findElement(bb);
       loc.click();
        List<WebElement> country = driver.findElements(By.xpath("//select[@id=\"icp-selected-country\"]//option"));
        for(int i=0; i<country.size(); i++)
        {
            if(country.get(i).getText().equals("United States"))
            {
                country.get(i).click();
                break;
            }
        }
//      Select dropdown =new Select(driver.findElement(By.id("icp-selected-country")));
//      dropdown.selectByVisibleText("United States");
      WebElement value= driver.findElement(By.xpath("//span[@class=\"a-dropdown-prompt\"]"));
      String actual = value.getText();
      System.out.println(actual);
      String expected= "United States";
      Assert.assertEquals(actual,expected);
      driver.findElement(By.xpath("//span[text()=\"Changing country/region website\"]")).click();
      driver.findElement(By.xpath("//span[@id=\"a-autoid-2\"]")).click();

      //window switch
        Set<String> s1= driver.getWindowHandles();
        Iterator<String> i= s1.iterator();
        System.out.println();
        String main_window = i.next();
        String child_window = i.next();

        driver.switchTo().window(child_window);

      driver.findElement(By.id("aee-xop-dismiss")).click();
      By bb1 = By.xpath("//div[@id=\"nav-flyout-icp\"]//span[text()=\"$ - USD - U.S. Dollar\"]");

        WebElement flag1=  driver.findElement(By.xpath("//div[@id=\"nav-tools\"]//a[1]"));
        action.moveToElement(flag1).perform();
        Wait wait1 =new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(bb1));
        String currency_name =driver.findElement(bb1).getText();
        String exp_currency_name = "$ - USD - U.S. Dollar";
        Assert.assertEquals(currency_name,exp_currency_name);
        driver.close(); //close current child window
        driver.quit();

        }
    }

