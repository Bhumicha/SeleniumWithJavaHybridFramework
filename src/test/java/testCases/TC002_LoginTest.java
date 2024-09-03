package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test
    public void verify_login() throws InterruptedException {
        logger.info("**** Starting TC_002_LoginTest ***");
        try {
            Thread.sleep(5000);
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            Thread.sleep(5000);
            hp.clickLogin();
            Thread.sleep(5000);

            LoginPage lp = new LoginPage(driver);
            Thread.sleep(5000);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            Thread.sleep(5000);
            lp.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExists();

            Assert.assertTrue(targetPage);
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("**** Finished TC_002_TestLogin");

    }


}
