package installation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
   public static WebDriver driver;
   protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
   @BeforeClass
   public static void createDriver() {
      driver = DriverFactory.createDriver(WEBDRIVERS.CHROMECLEAN);
   }
   @AfterClass
   public static void closeBrowser() throws InterruptedException {
      Thread.sleep(3000);
      driver.quit();
   }
}