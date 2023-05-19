package installation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {
   public static WebDriver driver;
   @BeforeClass
   public static void startBrowser() {
      driver = DriverFactory.createDriver(WEBDRIVERS.CHROMECLEAN);
   }
   @AfterClass
   public static void closeBrowser() throws InterruptedException {
      Thread.sleep(3000);
      driver.quit();
   }
}
