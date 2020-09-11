package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderNowPage extends Page {

    public OrderNowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//div[@class='banner-section compact']//img")
    private WebElement mainImage;

    @FindBy(xpath = "//div[@class='flip-card']//strong[text()='ONLY CODING']")
    private WebElement codingBlock;

    @FindBy(xpath = "//div[@class='flip-card']//strong[text()='DESIGN+CODING']")
    private WebElement designCodingBlock;

    public boolean isTitleOfThePageDisplay() {
        wait.withMessage("Title isn't displaying").until(ExpectedConditions.visibilityOf(title));
        return title.isDisplayed();
    }


    public OrderNowPage open() {
        driver.navigate().to(Page.host + PageRoutes.ORDER_NOW.getRoute());
        return this;
    }
}
