package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FaqPage extends Page {
    public FaqPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }




    public FaqPage open() {
        driver.navigate().to(Page.host + PageRoutes.FAQ.getRoute());
        return this;
    }
}
