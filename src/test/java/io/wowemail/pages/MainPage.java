package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Page {


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='banner-section']//img")
    private WebElement previewImage;

    @FindBy(xpath = "//img")
    private List<WebElement> images;

    public MainPage open() {
        driver.navigate().to(Page.host + PageRoutes.MAIN.getRoute());
        return this;
    }

    public boolean isPreviewImageDisplay() {
        return previewImage.isDisplayed();
    }

    public boolean AreAllImagesDisplayingOnTheMainPage() {
        for (WebElement image : images) {
            if (!image.isDisplayed()) {
                System.out.println("The image " + image.getAttribute("src") + " isn't displaying");
                return false;
            }
            System.out.println(image.getAttribute("src"));
        }
        return true;
    }
}
