package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int before= getTeamsCount();

        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName="second";
        fillTeamCreationForm(teamName, "descr first");
        clickContinueButton();
        String createdTeamName=getTeamNameFromPage();
        returnToHomePage();
        refreshPage();
        int after=getTeamsCount();

        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
       // Assert.assertTrue(isUserLoggedIn());
    }


}
