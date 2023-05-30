package installation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {
   public static WebDriver driver;
   @BeforeClass
      driver.quit();
   }
}
