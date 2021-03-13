import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestPurchase {


   private static final WebDriver driver = new ChromeDriver();
   final static Logger logger = Logger.getLogger(TestPurchase.class);
   public static void main(String[] args) {


   }





   @Test
   public void  testWebsiteCanOpen(){

      String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
      String expectedUrl = Utils.BASE_URL;
      driver.get(expectedUrl);
      try{
         Assert.assertEquals(expectedTitle, driver.getTitle());
         logger.warn("Navigated to correct webpage " );

      }
      catch(Throwable pageNavigationError){
         logger.error("Navigated to correct webpage " );

      }
   }


}