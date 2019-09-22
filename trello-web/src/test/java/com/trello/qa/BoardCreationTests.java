package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

@Test
public void testBoardCreation(){
    clickOnPlusButtonOnHeader();
    selectCreateBoardFromDropDown();
    fillBoardCreationForm("first 1.2", "gg");
    confimBoardCreation();

}




}
