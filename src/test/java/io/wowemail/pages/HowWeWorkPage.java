package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HowWeWorkPage extends Page {

    public HowWeWorkPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[@class='container make-order']/a")
    private WebElement sendProjectBriefButton;





    public HowWeWorkPage open(){
        driver.navigate().to(Page.host + PageRoutes.HOW_WE_WORK.getRoute());
        return this;
    }

    public void clickSendProjectBriefButton(){
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sendProjectBriefButton.click();
    }
}
