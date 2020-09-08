package com.jelvix.useremailbox;/* Created by user on 22.07.20 */

import com.jelvix.pages.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Mailinator extends Page {
    public Page_Mailinator(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addOverlay")
    private WebElement emailInput;


    public void goToEmailBox(String email) {
        if (email.length() == 0) {
            System.out.println("Email is empty");
        }
        String emailName = "";
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                emailName = email.substring(0, i);
            }
        }
        driver.get("https://www.mailinator.com/");
        emailInput.sendKeys(emailName + Keys.ENTER);
    }
}
