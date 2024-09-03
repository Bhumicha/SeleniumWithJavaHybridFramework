package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBases.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() throws InterruptedException {
        HomePage hp=new HomePage(driver);
        Thread.sleep(10000);
        hp.clickMyAccount();
        Thread.sleep(10000);
        hp.clickRegister();
        Thread.sleep(10000);

        AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
        Thread.sleep(10000);
        regpage.setFirstname(randomString().toUpperCase());
        regpage.setTxtLastname(randomString().toUpperCase());
        regpage.setTxtEmail(randomString()+"@gmail.com");
        regpage.setTxtPassword(randomAlphaNumeric());
        Thread.sleep(10000);
        regpage.setPrivacy();
        Thread.sleep(10000);
        regpage.clickContinue();
        Thread.sleep(10000);
        String confMsg=regpage.getConfirmationMsg();
        Assert.assertEquals(confMsg, "Your Account Has Been Created!");

    }

}
