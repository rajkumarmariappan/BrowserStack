import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public Select select;
    public String parentWindow;
    public String childWindow;
    public WebDriver driver;

    public String AppURL = "https://www.sbigeneral.in/portal/";

    @FindBy(how = How.XPATH, using = "//div[text()='Motor']//img")
    WebElement motorIcon;

    @FindBy(how = How.XPATH, using = "//div[@class='fade tab-pane active show']//a[text()='Buy']")
    WebElement buyInsurance;

    @FindBy(how = How.XPATH, using = "//select[@name='policy_type']")
    WebElement selectVehicle;

    @FindBy(how = How.XPATH, using = "//a[@class='cwvnLink']")
    WebElement cwvnLink;

    @FindBy(how = How.XPATH, using = "//button[@class='closemenu']")    
    // @FindBy(how = How.XPATH, using = "//div[@class='close-btn']")    
    WebElement banner;

    @FindBy(how = How.XPATH, using = "//input[@value='Bajaj Auto']")
    WebElement vehicleBrand;

    @FindBy(how = How.XPATH, using = "//input[@id='car_search_varient']")
    WebElement searchVehicle;

    @FindBy(how = How.XPATH, using = "//input[@value='Pulsar 150 DTS-i ES UG III']/../../..")
    WebElement scrollVehicle;

    @FindBy(how = How.XPATH, using = "//input[@value='Pulsar 150 DTS-i ES UG III']/..")
    WebElement pickVehicle;

    @FindBy(how = How.XPATH, using = "//input[@id='verify']")
    WebElement verifyVehicle;

    @FindBy(how = How.XPATH, using = "//select[@name='registration_year']")
    WebElement registrationYear;

    @FindBy(how = How.XPATH, using = "//select[@name='registration_month']")
    WebElement registrationMonth;

    @FindBy(how = How.XPATH, using = "//input[@id='registration_city']")
    WebElement registrationCity;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Andheri')]")
    WebElement selectRegistrationCity;

    @FindBy(how = How.XPATH, using = "//input[@id='Previous_policy_start_date']")
    WebElement policyStartDate;

    @FindBy(how = How.XPATH, using = "//input[@id='Previous_policy_end_date']")
    WebElement policyEndDate;

    @FindBy(how = How.XPATH, using = "//select[@name='policy_type']")
    WebElement policyType;

    @FindBy(how = How.XPATH, using = "//select[@name='Previous_Insurer_Name']")
    WebElement previousInsurerName;

    @FindBy(how = How.XPATH, using = "//select[@name='claimBonusN']")
    WebElement claimBonus;

    @FindBy(how = How.XPATH, using = "//select[@id='claimBonusN']/option[2]")
    WebElement claimBonusOption;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    WebElement submit;

    @FindBy(how = How.XPATH, using = "//input[@id='Previous_Insurer_city']")
    WebElement previousInsurerCity;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitToLoad(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchWindow() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
                System.out.println("Child window: " + ChildWindow);
                driver.switchTo().window(ChildWindow);
            } else
                driver.switchTo().window(parentWindow);
        }

    }

    public void getChildWindow() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!parentWindow.equalsIgnoreCase(ChildWindow)) {
                childWindow = ChildWindow;

            }
        }

    }

    public void loadSBIGPage() {
        driver.get(AppURL);
        //waitToLoad(banner);
        //banner.click();
    }

    public void choosePolicyType() {
        waitToLoad(motorIcon);
        motorIcon.click();
        buyInsurance.click();
        selectVehicleType();
        parentWindow = driver.getWindowHandle();
        System.out.println("Parent window: " + parentWindow);
        cwvnLink.click();
    }

    public void enterPolicyDetails() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Thread.sleep(2000);
//        switchWindow();
        Thread.sleep(3000);
        getChildWindow();
        System.out.println("Child window: " + childWindow);
        driver.switchTo().window(childWindow);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        System.out.println("Current window: " + driver.getWindowHandle());
 /*       vehicleBrand.click();
        Thread.sleep(3000);
        searchVehicle.sendKeys("Pulsar");
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", scrollVehicle);
        scrollVehicle.click();
//        pickVehicle.click();
        verifyVehicle.click();
//        waitToLoad(registrationYear);
        Thread.sleep(3000);
        selectRegistrationYear();
        selectRegistrationMonth();
        registrationCity.sendKeys("Mumbai");
        Thread.sleep(3000);
        selectRegistrationCity.click();
        js.executeScript("arguments[0].value='14/4/2019';", policyStartDate);
        js.executeScript("arguments[0].value='13/4/2020';", policyEndDate);
//        policyStartDate.sendKeys("14/4/2019");
        selectPolicyType();
        selectPreviousInsurer();
        previousInsurerCity.sendKeys("Mumbai");
        selectClaimBonus();
//        js.executeScript("arguments[0].click();",claimBonusOption);
        submit.click();
        Thread.sleep(2000);
*/
    }

    public void selectVehicleType() {
        select = new Select(selectVehicle);
        select.selectByValue("motor2wheeler");
    }

    public void selectRegistrationYear() {
        select = new Select(registrationYear);
        select.selectByValue("2018");
    }

    public void selectRegistrationMonth() {
        select = new Select(registrationMonth);
        select.selectByValue("4");
    }

    public void selectPolicyType() {
        select = new Select(policyType);
        select.selectByValue("2");
    }

    public void selectPreviousInsurer() {
        select = new Select(previousInsurerName);
        select.selectByValue("16");
    }

    public void selectClaimBonus() {
        select = new Select(claimBonus);
        select.selectByValue("1");
    }

}
