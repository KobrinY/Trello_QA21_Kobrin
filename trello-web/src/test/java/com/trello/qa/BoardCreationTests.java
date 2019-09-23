package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

@Test
public void testBoardCreation() throws InterruptedException {

    int before = getBoardCount();

    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();

    String boardName="second 1.3";
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
