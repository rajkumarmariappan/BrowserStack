
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
       
        System.out.println("29 april git check1");
        System.out.println("29 april git check2");
        System.out.println("29 april git check3 commit 2");
        System.out.println("Ma 10");
    }


}
