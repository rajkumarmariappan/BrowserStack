import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserConfigOld {

    public static final String USERNAME = "rajkumar357";
    public static final String AUTOMATE_KEY = "Ew2SsdyiQeeUBpCqpQ4F";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static WebDriver driver;
    public String path = "C:\\Users\\sainathr\\Documents\\PICNIC\\Selenium\\";
    
    public BrowserConfigOld(String environment) throws MalformedURLException {
        switch (environment) {
            case "local":
                //System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
                break;
            case "remote":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "81.0");
                caps.setCapability("build", "Build Alpha");
                caps.setCapability("name", "Bstack Sample Test");
//              caps.setCapability("browserstack.local", "true");
                driver = new RemoteWebDriver(new URL(URL), caps);
                driver.manage().window().maximize();
                break;
        }
    }

    public void endSession() {
        driver.quit();
    }
}
