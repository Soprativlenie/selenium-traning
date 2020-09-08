package com.jelvix.pages.pageblocks;

import com.jelvix.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationTabs extends Page {
    public NavigationTabs(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[@class='logo']/a")
    private WebElement logo;

    @FindBy(xpath = "//button[@class='search-reset']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Industries']")
    private WebElement industriesButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Services']")
    private WebElement servicesButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Expertise']")
    private WebElement expertiseButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Technologies']")
    private WebElement technologiesButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Case Studies']")
    private WebElement caseStudiesButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Company']")
    private WebElement companyButton;

    @FindBy(xpath = "//ul[@class='nav-menu']//a[text()='Blog']")
    private WebElement blogButton;

    @FindBy(xpath = "//a[@class='btn btn-gray btn-flip']//span[@class='default-state']")
    private WebElement contactUsButton;

    public void clickIndustriesButton() {
        industriesButton.click();
    }
    public void clickCompanyButton() {
        industriesButton.click();
    }
}
