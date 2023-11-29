package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import wrappers.Input;
import wrappers.Picklist;

import java.time.Duration;

public class AccountTest extends BaseTest {

    @Test
    public void createAccount() {
        driver.get("https://tms41-dev-ed.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("drak@tms.sandbox");
        driver.findElement(By.id("password")).sendKeys("Password01!!");
        driver.findElement(By.id("Login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=User]")));
        driver.get("https://tms41-dev-ed.lightning.force.com/lightning/o/Account/new");
        //driver.findElement(By.cssSelector("[title=New]")).click();
        new Input(driver, "Account Name").write(faker.artist().name());
        new Picklist(driver, "Rating").select("Hot");
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();

    }

}
