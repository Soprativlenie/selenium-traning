package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderNowPage extends Page {

    public OrderNowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }





    public OrderNowPage open() {
        driver.navigate().to(Page.host + PageRoutes.ORDER_NOW.getRoute());
        return this;
    }
}
