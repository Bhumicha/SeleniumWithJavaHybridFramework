package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBases.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() throws InterruptedException {
        logger.info("**Starting TC001_AccountRegistrationTest****");
        try {
            HomePage hp = new HomePage(driver);
            Thread.sleep(10000);
            hp.clickMyAccount();
            Thread.sleep(10000);
            logger.info("Clicked on Myaccount link");

            hp.clickRegister();
            Thread.sleep(10000);
            logger.info("Clicked on Register link");


            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            logger.info("Providing customer details");
            Thread.sleep(10000);
            regpage.setFirstname(randomString().toUpperCase());
            regpage.setTxtLastname(randomString().toUpperCase());
            regpage.setTxtEmail(randomString() + "@gmail.com");
            regpage.setTxtPassword(randomAlphaNumeric());
            Thread.sleep(10000);
            regpage.setPrivacy();
            Thread.sleep(10000);
            regpage.clickContinue();
            Thread.sleep(10000);

            logger.info("Validating expected message");
            String confMsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confMsg, "Your Account Has Been Created!");

        } catch (Exception e) {
            logger.error("Test failed");
            logger.debug("Debug logs");
        }
        logger.info("***Finished TC0001_AccountRegistrationTEst ***");
    }

}
