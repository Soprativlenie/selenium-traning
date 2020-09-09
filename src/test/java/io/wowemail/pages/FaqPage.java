package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqPage extends Page {
    public FaqPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@id='be-select']//li[text()='Organization']")
    private WebElement organizationTab;

    @FindBy(xpath = "//div[@id='be-select']//li[text()='Privacy']")
    private WebElement privacyTab;

    @FindBy(xpath = "//div[@id='be-select']//li[text()='Payment']")
    private WebElement paymentTab;

    @FindBy(xpath = "//div[@id='be-select']//li[text()='Email coding']")
    private WebElement emailCodingTab;

    @FindBy(xpath = "//div[@id='tab-1']//h2")
    private WebElement organizationHeader;

    @FindBy(xpath = "//div[@id='tab-2']//h2")
    private WebElement privacyHeader;

    @FindBy(xpath = "//div[@id='tab-3']//h2")
    private WebElement paymentHeader;

    @FindBy(xpath = "//div[@id='tab-4']//h2")
    private WebElement emailCodingHeader;



    public FaqPage open() {
        driver.navigate().to(Page.host + PageRoutes.FAQ.getRoute());
        return this;
    }
}
