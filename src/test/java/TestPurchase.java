import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestPurchase {


    private static final WebDriver driver = new ChromeDriver();
    final static Logger logger = Logger.getLogger(TestPurchase.class);
    WebForm webForm = new WebForm(driver);


    public static void main(String[] args) {


    }

    @Test
    public void testWebsiteIsOpened() {

        String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String expectedUrl = Utils.BASE_URL;
        driver.manage().window().maximize();

        driver.get(expectedUrl);

        try {
            Assert.assertEquals(expectedTitle, driver.getTitle());
            logger.warn("Navigated to correct webpage ");

        } catch (Throwable pageNavigationError) {
            logger.error("Navigated to uncorrect webpage ");

        }
    }


    @Test
    public void testUserLogin() {

        String expectedTitle = "Hesabım\n" +
                "vefavefa762278";

        driver.get("https://www.gittigidiyor.com/uye-girisi");
        webForm.enterUsername();
        webForm.enterPassword();
        webForm.pressSubmitButton();
        String s = webForm.getAccount();

        try {
            Assert.assertEquals(expectedTitle, s);
            logger.warn("Logged in ");

        } catch (Throwable pageNavigationError) {
            logger.error("cant Log in ");

        }

    }

    @Test
    public void testIfEnterSecondPage() {
        testUserLogin();

        driver.manage().window().maximize();
        webForm.enterSearchQ();
        webForm.pressSearchButton();
        try {
            Assert.assertEquals(driver.getCurrentUrl().toLowerCase(), "https://www.gittigidiyor.com/arama/?k=bilgisayar");
            logger.warn("bilgisayar search is done ");

        } catch (Throwable pageNavigationError) {
            logger.error("bilgisayar search is not done ");

        }


    }


    @Test
    public void RandomProduct() {
        testIfEnterSecondPage();
        String s= webForm.selectRandomProduct();
        try {
            assertTrue(s.length()>0);
            logger.warn("the selceted product is :  "+s);

        } catch (Throwable pageNavigationError) {
            logger.error("cant select a product ");

        }
    }


}


