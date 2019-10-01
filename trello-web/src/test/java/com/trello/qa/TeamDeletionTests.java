package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

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
    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        clickOnFirstTeam();
        openSettings();
        deleteTeam();
        returnToHomePage();

        int after=getTeamsCount();
        Assert.assertEquals(after,before-1);
    }


}
