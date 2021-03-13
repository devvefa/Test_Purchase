import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestPurchase {


   private static final WebDriver driver = new ChromeDriver();
   final static Logger logger = Logger.getLogger(TestPurchase.class);
   WebForm webForm = new WebForm(driver);


   public static void main(String[] args) {


   }

   @Test
   public void  testWebsiteIsOpened(){

      String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
      String expectedUrl = Utils.BASE_URL;
      driver.manage().window().maximize();

      driver.get(expectedUrl);

      try{
         Assert.assertEquals(expectedTitle, driver.getTitle());
         logger.warn("Navigated to correct webpage " );

      }
      catch(Throwable pageNavigationError){
         logger.error("Navigated to uncorrect webpage " );

      }
   }


   @Test
   public void testUserLogin (){
      String expectedTitle = "Hesabım\n" +
              "vefavefa762278";

      driver.get("https://www.gittigidiyor.com/uye-girisi");
      webForm.enterUsername();
      webForm.enterPassword();
      webForm.pressSubmitButton();
     String s=webForm.getAccount();

      try{
         Assert.assertEquals(expectedTitle,s);
         logger.warn("Logged in " );

      }
      catch(Throwable pageNavigationError){
         logger.error("cant Log in " );

      }

   }

}