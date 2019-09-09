package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

    int before= getTeamCounts();


    public int getTeamCounts() {

        return driver.findElements(By.cssSelector("")).size();
    }

    @Test
    public void testTeamCreation(){
        Assert.assertTrue(isUserLoggIn());
    }

    public boolean isUserLoggIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }
}
