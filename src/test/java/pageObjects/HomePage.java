package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy (css = "div[class='nav float-end'] div[class='dropdown'] span[class='d-none d-md-inline']")
    WebElement InkMyAccount;

    @FindBy (xpath = "//a[normalize-space()='Register']")
    WebElement InkRegister;

    @FindBy (xpath = "//a[normalize-space()='Login']")
    WebElement InkLogin;


    public void clickMyAccount()
    {
        InkMyAccount.click();
        WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(15));
        mywait.until(ExpectedConditions.elementToBeClickable(InkMyAccount)).click();
    }
    public void clickRegister() {
        InkRegister.click();
    }
    public void clickLogin() {
        InkLogin.click();
    }
}
