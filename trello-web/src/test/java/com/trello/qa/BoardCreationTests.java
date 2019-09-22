package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

@Test
public void testBoardCreation(){

    //int before = getBoardCount();

    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();

   // String
    fillBoardCreationForm("first 1.2", "gg");
    confimBoardCreation();

}




}
