package io.wowemail.pages;/* Created by user on 25.08.20 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SamplesPage extends Page {


    public SamplesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='image-col']//img")
    private WebElement previewImage;

    @FindBy(xpath = "//h1")
    private WebElement titleOfTheSamplePage;

    @FindBy(xpath = "//div[@class='main-text']/p")
    private WebElement previewText;

    @FindBy(xpath = "//div[@class='col']")
    private List<WebElement> samples;

    public SamplesPage open(){
        driver.navigate().to(Page.host + PageRoutes.SAMPLES.getRoute());
        return this;
    }

    public List<WebElement> getSamples() {
        return samples;
    }

    public WebElement getSample(int sampleNumber) {
        if (sampleNumber > samples.size()) {
            throw new IllegalArgumentException("Wrong Sample Number" + sampleNumber);

        }
        return samples.get(sampleNumber);
    }

    public boolean isPreviewImageDisplaying() {
        return previewImage.isDisplayed();
    }
}

