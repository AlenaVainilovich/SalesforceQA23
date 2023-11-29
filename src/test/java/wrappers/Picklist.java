package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Picklist {

    WebDriver driver;
    String label;

    public Picklist(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;

    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format("//*[contains(text(),'Rating')]/ancestor::lightning-picklist//button", label)))
                .click();
        driver.findElement(By.xpath(String.format("//lightning-base-combobox-item//span[test()='%s']", option))).click();
    }

}

