
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class Runner extends BrowserStackConfig {

    @Test
    public void homePageTest() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.loadSBIGPage();
        home.choosePolicyType();
        home.enterPolicyDetails();
    }


}
