package io.wowemail.tests;/* Created by user on 14.08.20 */

import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @Test(enabled = false, description = "Find out with display images inside slider bar")
    public void should_DisplayAllImages_WhenUserIsOnTheMainPage() {
        mainPage.open();
        Assert.assertTrue(mainPage.AreAllImagesDisplayingOnTheMainPage());
    }

    @Test
    public void should_ShowSuccessPopup_When_TheUserFillsTheGetInTouchWithUsFormOnTheMainPage() {
        mainPage.open()
                .enterTheNameToTheNameField("Test")
                .enterTheEmailToTheEmailField("test@jelxiv.com")
                .enterTheMessageToTheMessageField("Test Message");
        mainPage.clickTheSendButton();
        Assert.assertTrue(mainPage.isSuccessSendingPopupDisplay());
    }

    @Test
    public void should_DeliverTheMessageToTheInfoWowEmailMailBox_When_TheUserSendsGetInTouchFormTheMainPage() throws UnirestException {
        mainPage.open()
                .enterTheNameToTheNameField("John Doe421")
                .enterTheEmailToTheEmailField("test@jelvix.com")
                .enterTheMessageToTheMessageField("Test Message")
                .clickTheSendButton();
        mainPage.isSuccessSendingPopupDisplay();
        mainPage.clickCloseButtonOnTheSuccessSendingOfTheGetInTouchPopup();
        System.out.println(httpSender.getDataOfTheFirstMessage());
    }

    @Test
    public void should_RedirectToTheOrderNowPage_When_TheUserClicksOrderNowButton(){
        mainPage.open()
                .clickTheOrderNowButton();
        Assert.assertTrue(orderNowPage.isTitleOfThePageDisplay());
    }

    @Test
    public void should_RedirectToTheOrderNowPage_When_TheUserClicksSendProjectBriefButton(){
        howWeWorkPage.open()
                .clickSendProjectBriefButton();
        Assert.assertTrue(orderNowPage.isTitleOfThePageDisplay());
    }

}
