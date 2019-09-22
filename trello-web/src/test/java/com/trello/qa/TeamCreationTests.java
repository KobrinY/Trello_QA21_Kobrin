package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

//    int before= getTeamCounts();
//
//
//    public int getTeamCounts() {
//
//        return driver.findElements(By.cssSelector("")).size();
//    }

    @Test
    public void testTeamCreationFromButtonOnHeader(){


        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("first", "descr first");
        clickContinueButton();

        Assert.assertTrue(isUserLoggedIn());
    }


}
