package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

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
    public void testBoardCreation() throws InterruptedException {

    int before = getBoardCount();

    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();

    String boardName="board "+System.currentTimeMillis();
    fillBoardCreationForm(boardName, "gg");
    confimBoardCreation();
    String createdBoardName= getBoardNameFromPage();
    returnToHomePage();
    refreshPage();
    int after=getBoardCount();

    Assert.assertEquals(after, before+1);
    Assert.assertEquals(createdBoardName.toLowerCase(),boardName.toLowerCase());
     
}
}
