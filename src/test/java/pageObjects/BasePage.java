package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String randomString()
    {
        String generateString= RandomStringUtils.randomAlphabetic(5);
        return generateString;
    }
    public String randomAlphaNumeric()
    {
        String generateString= RandomStringUtils.randomAlphabetic(3);
        String generateNumeric=RandomStringUtils.randomNumeric(3);
        return (generateString+generateNumeric);
    }
}
