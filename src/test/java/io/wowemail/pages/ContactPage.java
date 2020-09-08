package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "")
    private WebElement element;

    public ContactPage open() {
        driver.navigate().to(Page.host + PageRoutes.CONTACT.getRoute());
        return this;
    }
}
