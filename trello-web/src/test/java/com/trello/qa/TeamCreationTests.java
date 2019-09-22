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
        driver.navigate().refresh();
        int after=getTeamsCount();
        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());


       // Assert.assertTrue(isUserLoggedIn());
    }

    public String getTeamNameFromPage() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void returnToHomePage() throws InterruptedException {
        Thread.sleep(10000);
        click(By.cssSelector("a[href='/']"));
    }

    public int getTeamsCount() {

        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }


}
