package testBases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;


public class BaseClass {
    public WebDriver driver;
    public Logger logger;

    @BeforeClass
    @Parameters ({"browser"})
    public void setUp(String br)
    {
        logger= LogManager.getLogger(this.getClass());

        switch(br)
        {
            case "edge" : driver=new EdgeDriver();
            case "chrome" : driver=new ChromeDriver();
            default:
                System.out.println("Invalid browser");
        }
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--headless=new");
//        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
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

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
