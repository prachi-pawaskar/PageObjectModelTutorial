package pawaskar.prachi.PageObjectModelTutorial;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pawaskar.prachi.PageObjectModelTutorial.pages.DefaultPageAfterLogin;
import pawaskar.prachi.PageObjectModelTutorial.pages.HomePage;
import pawaskar.prachi.PageObjectModelTutorial.pages.LoginHomePage;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class TestsToExecute {
    
    //Declarations
    WebDriver driver;
    HomePage homePage;
    LoginHomePage loginHomePage;
    DefaultPageAfterLogin defaultPageAfterLogin;
    
    //Runs once before every Test CLASS
    @BeforeTest
    public void beforeTest(){
        //Get the driver path
        String resourceFilePath = "src/main/java/pawaskar/prachi/PageObjectModelTutorial/drivers";
        String resourceURL = new File(resourceFilePath).getAbsolutePath();
        //Set the driver path
        System.setProperty("webdriver.chrome.driver", resourceURL +"/chromedriver.exe");
        //Initialize browser
        // To disable pop up: Loading of unpacked extensions is disabled by the administrator
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/index.html");
    }

    //Shut down the browser
    @AfterTest
    public void afterTest(){
        driver.close();
    }


    //Run the test to login and verify that the dashboard is loaded by default
    @Test
    public void verifyLogin() throws InterruptedException {
        //Home Page actions
        homePage = new HomePage(driver);
        homePage.goToSignInPage();
        //Login page actions
        loginHomePage = new LoginHomePage(driver);
        loginHomePage.login("username","password");
        //Default landing page options
        defaultPageAfterLogin = new DefaultPageAfterLogin(driver);
        Boolean isDisplayed = defaultPageAfterLogin.verifyLandingPage();
        assertTrue(isDisplayed);
    }

}
