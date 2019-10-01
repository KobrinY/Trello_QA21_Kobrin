package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

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
    public void deletionPersonalBoard() throws InterruptedException {
        int before= getBoardCount();
        clickOnFirstPersonalBoard();
        clickOnMoreButtonInBoardMenu();
        clickCloseBoard();
        returnToHomePage();

        int after = getBoardCount();
        Assert.assertEquals(after,before-1);

    }

    @Test (enabled = false)
    public void deletionAlmostEveryonePersonalBoards() throws InterruptedException {
        cleaningPersonalBoards();
    }


}
