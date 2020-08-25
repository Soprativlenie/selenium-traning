package io.wowemail.tests;/* Created by user on 14.08.20 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @Test
    public void should_verifyThatPreviewImageIsDisplaying_WhenUserIsOnTheMainPage(){
        mainPage.open();
        Assert.assertTrue(mainPage.AreAllImagesDisplayingOnTheMainPage());
    }
}
