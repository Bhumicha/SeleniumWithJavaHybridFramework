package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test (dataProvider="LoginData", dataProviderClass = DataProviders.class)
    public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {
        logger.info("**** Starting TC_003_LoginDDT ***");
        try {
            logger.info("Navigating to login page");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            Thread.sleep(5000);
            hp.clickLogin();

            logger.info("Entering login data");
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExists();



            logger.info("Entering valid data");
            if (exp.equalsIgnoreCase("valid"))
            {
                if (targetPage) {
                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("window.scrollBy(0,250)");
                    Thread.sleep(5000);
                    macc.clickLogout();
                    Assert.assertTrue(true);
                    driver.get(p.getProperty("appURLLogin")); //reading url from properties file


                } else {
                    Assert.fail();
                }
            }
            logger.info("Entering invalid data");
            if (exp.equalsIgnoreCase("invalid"))
            {
                if (targetPage) {
                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("window.scrollBy(0,250)");
                    Thread.sleep(5000);
                    macc.clickLogout();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("**** Finished TC_003_TestLoginDDT");
    }
}
