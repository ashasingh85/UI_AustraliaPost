package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.configuration.Browser;
import com.configuration.Config;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyStepDefinitions {
	public WebDriver driver;
	

    @Given("^User is on Australia post Landing page$")
    public void user_is_on_australia_post_landing_page() throws Throwable {
    	driver = Browser.browserInformation();
     	driver.get(Config.getStringValue("url"));
        
    }

    @When("^User enters source and destination post code$")
    public void user_enters_source_and_destination_post_code() throws Throwable {
    	driver.findElement(By.xpath("//input[@id='domFrom_value']")).sendKeys("2133");
    	driver.findElement(By.xpath("//input[@id='domTo_value']")).sendKeys("2060");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
        
    }
    @And("^Select the size weight and delivery date$")
    public void select_the_size_weight_and_delivery_date() throws Throwable {
    	driver.findElement(By.xpath("//a[contains(text(),'Enter size & weight')]")).click();
    	driver.findElement(By.xpath("//input[@name='lengthInput']")).sendKeys("2");
    	driver.findElement(By.xpath("//input[@name='widthInput']")).sendKeys("2");
    	driver.findElement(By.xpath("//input[@name='heightInput']")).sendKeys("2");
    	driver.findElement(By.xpath("//input[@name='weightInput']")).sendKeys("2");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	driver.findElement(By.xpath("//a[contains(text(),'Enter a date')]")).click();
    	driver.findElement(By.xpath("//input[@name='dateInput']")).sendKeys("18/09/2020");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
        
    }

    @Then("^Two parcel options along with the cost are displayed$")
    public void two_parcel_options_along_with_the_cost_are_displayed() throws Throwable {
    	
    	WebElement parcelDetail=driver.findElement(By.xpath("//div[@class='postage-service__summary-container']"));
    	List<WebElement>  parcelServcieNameList =  parcelDetail.findElements(By.xpath("//*[@class = 'postage-service__section__name-label ng-binding']"));
    	List<WebElement>  parcelCostList =  parcelDetail.findElements(By.xpath("//*[@class = 'postage-service__section__price ng-binding']"));
    	
    	assertEquals("Express Post",parcelServcieNameList.get(0).getText());
    	assertEquals("Parcel Post",parcelServcieNameList.get(1).getText());
    	System.out.println("parcelServcieName  : " + parcelServcieNameList.get(0).getText() + " & parcelCost : " + parcelCostList.get(0).getText());
    	System.out.println("parcelServcieName  : " + parcelServcieNameList.get(1).getText() + " & parcelCost : " + parcelCostList.get(1).getText());
    	assertNotNull(parcelCostList.get(0));
    	assertNotNull(parcelCostList.get(1));
    	
    	
    }
    
}



