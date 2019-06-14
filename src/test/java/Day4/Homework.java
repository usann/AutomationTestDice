package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Homework {

        WebDriver driver;
        String mainPage = "https://www.dice.com";

        By searchFieldKeyword = By.id("search-field-keyword");
        By searchFieldLocation = By.id("search-field-location");
        By searchButton = By.id("findTechJobs");
        By countMobileId = By.id("posiCountId");
        By signInButton = By.id("Login_1");
        By myEmail = By.id("Email_1");
        By myPassword = By.id("Password_1");
        By loginButton = By.id("LoginBtn_1");
        By youLoggedIn = By.id("dice-login-customer-name");
        By keyWord = By.id("for_jt");
        By myCity = By.id("for_loc");
        By slider = By.id("radiusMileAnchor");
        By advancedSearch = By.id("adv_search");
        By advancedSearchWasDone = By.id("posiCountId");
        By partTimeJobSearchWasDone = By.id("posiCountId");
        By carreerButton = By.id("smart-toggle-Career");
        By keyWordSkills = By.id("s");
        By searchSkillsWasDone = By.id("s");

        @Test
        public void test001() throws Exception {
            String keywordForSearch = "Webdriver";
            String location = "San Francisco";

            openMainPage();
            typeKeyword(keywordForSearch);
            typeLocation(location);
            submitSearch();
            assertResultPage();
        }

        private void assertResultPage(){
            waitForElement(countMobileId);
            boolean isDisplayed = driver.findElement(countMobileId).isDisplayed();
            Assert.assertTrue(isDisplayed);
        }

        private void waitForElement(By elementLocator) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        }

        private void typeLocation(String location) {
            driver.findElement(searchFieldLocation).sendKeys(location);
        }

        private void typeKeyword(String keywordForSearch) {
            driver.findElement(searchFieldKeyword).sendKeys(keywordForSearch);
        }

        private void submitSearch() {
            driver.findElement(searchButton).click();
        }

    private void openMainPage() {
        driver.get(mainPage);
    }

        @BeforeSuite
        public void setup() {
            String path = System.getProperty("user.dir") + "/src/test/resources/geckodriver";
            System.setProperty("webdriver.gecko.driver", path);
            driver = new FirefoxDriver();
        }

    // sign in test
        @Test
        public void test002() throws Exception {

            open2MainPage();
            clickSingInButton();
            typeEmail();
            typePassword();
            clickLoginButton();
            assertThatYouLoggedIn();
        }

    private void assertThatYouLoggedIn(){
        boolean isDisplayed = driver.findElement(youLoggedIn).isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    private void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    private void typePassword() {
        driver.findElement(myPassword).click();
        driver.findElement(myPassword).sendKeys("lexolus4581211");
    }
        private void typeEmail() {
            driver.findElement(myEmail).click();
            driver.findElement(myEmail).sendKeys("usa.ann19@gmail.com");
            }

   private void clickSingInButton() {
        driver.findElement(signInButton).click();
    }

        private void open2MainPage() {
        driver.get(mainPage);
    }

        //advanced search
        @Test
        public void test003() throws Exception {
            String path = System.getProperty("user.dir") + "/src/test/resources/geckodriver";
            System.setProperty("webdriver.gecko.driver", path);

            driver = new FirefoxDriver();

            open3MainPage();
            clickAdvancedSearch();
            typeKeyWord();
            typeCity();
            scrollToSlider();
            moveSliderToHigherValue();
            click2AdvancedSearch();
            assertSearchWasDone();
        }

        private void assertSearchWasDone(){
        waitForElement(advancedSearchWasDone);
            boolean isDisplayed = driver.findElement(advancedSearchWasDone).isDisplayed();
            Assert.assertTrue(isDisplayed);
        }

        private void click2AdvancedSearch(){
            driver.findElement(advancedSearch).click();
        }

        private void moveSliderToHigherValue() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String xPath1 = "//*[@id=\"radiusMileAnchor\"]";
            WebElement a = driver.findElement(By.xpath(xPath1));
            js.executeScript("arguments[0].setAttribute('style', 'left: 100%;')", a);
        }

        private void scrollToSlider(){
            driver.findElement(slider).click();
        }

        private void typeCity() {
         driver.findElement(myCity).sendKeys("Cupertino, California");
        }

        private void typeKeyWord(){
            driver.findElement(keyWord).sendKeys("QA");
        }

        private void clickAdvancedSearch() {
          driver.findElement(By.cssSelector(".text-right > a:nth-child(1)")).click();
        }

        private void open3MainPage() {
            driver.get(mainPage);
        }

        //search for part-time job
        @Test
        public void test004() throws Exception {
            String path = System.getProperty("user.dir") + "/src/test/resources/geckodriver";
            System.setProperty("webdriver.gecko.driver", path);

            driver = new FirefoxDriver();

            open4MainPage();
            click3AdvancedSearch();
            type2KeyWord();
            type2Сity();
            clickSelectEmployType();
            clickPartTimeJob();
            click4AdvancedSearch();
            assert2SearchWasDone();
        }

        private void assert2SearchWasDone(){
            waitForElement(partTimeJobSearchWasDone);
            boolean isDisplayed = driver.findElement(partTimeJobSearchWasDone).isDisplayed();
            Assert.assertTrue(isDisplayed);
        }

        private void click4AdvancedSearch(){
            driver.findElement(advancedSearch).click();
        }

        private void clickPartTimeJob(){
            String xPath3 = "/html/body/div[5]/div/form/div/div[12]/div[2]/div/div/ul/li[2]/a/input";
            driver.findElement(By.xpath(xPath3)).click();
        }

        private void clickSelectEmployType() {
            String xPath2 = "/html/body/div[5]/div/form/div/div[12]/div[2]/div/div/button";
            driver.findElement(By.xpath(xPath2)).click();
        }
        private void type2Сity(){
            driver.findElement(myCity).sendKeys("Santa Cruz, California");
        }
        private void type2KeyWord(){
            driver.findElement(keyWord).sendKeys("Engineer");
        }

        private void click3AdvancedSearch(){
            driver.findElement(By.cssSelector(".text-right > a:nth-child(1)")).click();
        }

        private void open4MainPage(){
            driver.get(mainPage);
        }


        //skills center
        @Test
        public void test005() throws Exception {
            String path = System.getProperty("user.dir") + "/src/test/resources/geckodriver";
            System.setProperty("webdriver.gecko.driver", path);

            driver = new FirefoxDriver();

            open5MainPage();
            clickCareer();
            choseSkillsCenterFromDropdownList();
            typeKeywordSkills();
            searchSkills();
            assertSearch();
        }

        private void assertSearch(){
            boolean isDisplayed = driver.findElement(searchSkillsWasDone).isDisplayed();
            Assert.assertTrue(isDisplayed);
        }

        /*private void assertSearch() {
            String xPath6 = "/html/body/div[4]/div/div[2]/div/h1";
            waitForElement(By.xpath(xPath6));
            boolean isDisplayed = driver.findElement(By.xpath(xPath6)).isDisplayed();
            Assert.assertTrue(isDisplayed);
        }*/

        private void searchSkills() {
            String xPath5 = "/html/body/div[5]/div/div[1]/div/div/div[1]/div/div/button";
            driver.findElement(By.xpath(xPath5)).click();
        }

        private void typeKeywordSkills(){
            driver.findElement(keyWordSkills).sendKeys("Java");
        }

        private void choseSkillsCenterFromDropdownList(){
            String xPath4 = "/html/body/div[5]/header/div[1]/div/div[2]/ul[1]/li[1]/ul/li[2]/a";
            driver.findElement(By.xpath(xPath4)).click();
        }

        private void clickCareer(){
            driver.findElement(carreerButton).click();
        }

        private void open5MainPage() {
            driver.get(mainPage);
        }


}



