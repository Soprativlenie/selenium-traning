package io.wowemail.tests;/* Created by user on 14.08.20 */

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @Test(enabled = false, description = "Find out with display images inside slider bar")
    public void should_DisplayAllImages_WhenUserIsOnTheMainPage() {
        mainPage.open();
        Assert.assertTrue(mainPage.AreAllImagesDisplayingOnTheMainPage());
    }

    @Test
    @Parameters({"name","email","message"})
    public void should_ShowSuccessPopup_When_TheUserFillsTheGetInTouchWithUsFormOnTheMainPage(String name, String email,
             String message)
    {
        mainPage.open()
                .enterTheNameToTheNameField(name)
                .enterTheEmailToTheEmailField(email)
                .enterTheMessageToTheMessageField(message);
        mainPage.clickTheSendButton();
        Assert.assertTrue(mainPage.isSuccessSendingPopupDisplay());
    }

    @Test(enabled = false, description = "Figure out how to wait until message is sent to the mailbox")
    @Parameters({"name1","email1","message1"})
    public void should_DeliverTheMessageToTheInfoWowEmailMailBox_When_TheUserSendsGetInTouchFormTheMainPage(
            String name, String email, String message) {
        mainPage.open()
                .enterTheNameToTheNameField(name)
                .enterTheEmailToTheEmailField(email)
                .enterTheMessageToTheMessageField(message)
                .clickTheSendButton();
        mainPage.isSuccessSendingPopupDisplay();
        mainPage.clickCloseButtonOnTheSuccessSendingOfTheGetInTouchPopup();

    }

    @Test
    public void should_RedirectToTheOrderNowPage_When_TheUserClicksOrderNowButton()  {
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
