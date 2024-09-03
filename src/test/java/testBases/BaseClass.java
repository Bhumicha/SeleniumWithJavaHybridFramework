package testBases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;


public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters ({"browser"})
    public void setUp(String br) throws IOException {

        //Loading config.properties file
        FileReader file=new FileReader(".//src//test//resources//config.properties");
        p=new Properties();
        p.load(file);

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
        driver.get(p.getProperty("appURL")); //reading url from properties file
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
