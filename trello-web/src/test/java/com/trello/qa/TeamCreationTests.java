package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    @BeforeClass
    public void ensurePreconditionsLogin() {
        if (!isUserLoggedIn()) {
            login("yurchikkobrin@gmail.com", "yurchikkobrin");
        }
    }

    @BeforeMethod
    public void isOnHomePage() {
        if (!isTherePersonalBoards()) {
            returnToHomePage();
        }
    }


    @Test
    public void testTeamCreationFromButtonOnHeader() throws InterruptedException {

        int before = getTeamsCount();

        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "team " + System.currentTimeMillis();
        fillTeamCreationForm(teamName, "descr first");
        clickContinueButton();
        String createdTeamName = getTeamNameFromPage();
        returnToHomePage();
        refreshPage();
        int after = getTeamsCount();

        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());
        // Assert.assertTrue(isUserLoggedIn());
    }


}
