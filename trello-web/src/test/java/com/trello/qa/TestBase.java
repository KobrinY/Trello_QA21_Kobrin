package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openSite("https://trello.com/");
        login("yurchikkobrin@gmail.com", "yurchikkobrin");
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type(By.cssSelector("[type=password]"), password);
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void returnToHomePage() {
        if (isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))) {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));

    }

    public void refreshPage() {
        driver.navigate().refresh();
    }


//-----------------------------------------------------------------------

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public String getTeamNameFromPage() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public int getTeamsCount() throws InterruptedException {
        //Thread.sleep(5000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size()-1;
    }
    public void deleteTeam() {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openSettings()  {
        click(By.xpath("//span[@class='icon-gear icon-sm _2aV_KY1gTq1qWc']"));
    }

    public void clickOnFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));;
    }

//------------------------------------------------------------------------------------------

    public int getBoardCount() throws InterruptedException {
        //Thread.sleep(5000);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void fillBoardCreationForm(String boardName, String d) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
        if (isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))) {
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]")); //its no team
        }
    }

    public void confimBoardCreation() {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public String getBoardNameFromPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='js-board-editing-target board-header-btn-text']")));
        return driver.findElement(By.xpath("//span[@class='js-board-editing-target board-header-btn-text']")).getText();
    }


    public boolean isTherePersonalBoards() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    protected void clickCloseBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    public void clickOnMoreButtonInBoardMenu() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-header-btn.mod-show-menu")));
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        System.out.println(menuButton.getCssValue("visibility"));
        if(menuButton.getCssValue("visibility").equals("visible")){
            click(By.cssSelector(".mod-show-menu"));
            click(By.cssSelector(".js-open-more"));
        }else{
            click(By.cssSelector(".js-open-more"));
        }
    }

    public void clickOnFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li[1]"));
    }

    public void cleaningPersonalBoards() throws InterruptedException {
        int before= getBoardCount();
        do{
            clickOnFirstPersonalBoard();
            clickOnMoreButtonInBoardMenu();
            clickCloseBoard();
            returnToHomePage();

            int after = getBoardCount();
            Assert.assertEquals(after,before-1);
        }while(before>=3);
    }
}
