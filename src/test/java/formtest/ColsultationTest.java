package formtest;

import installation.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ColsultationTest extends BaseClass {

    @BeforeClass
    public static void siteOpen(){
        driver.get("https://ithillel.ua");
        driver.findElement(By.id("btn-consultation-hero")).click();
    }
    @Test
    public void testNameField() throws InterruptedException {
        driver.findElement(By.id("input-name-consultation")).sendKeys("Alex");
        Thread.sleep(2000);
    }
    @Test
    public void testEmailField() throws InterruptedException {
        driver.findElement(By.id("input-email-consultation")).sendKeys("test@gmail.com");
        Thread.sleep(2000);
    }
    @Test
    public void testPhoneField() throws InterruptedException {
        driver.findElement(By.id("input-tel-consultation")).sendKeys("631234567");
        Thread.sleep(2000);
    }
    @Test
    public void testTelegramChoosing() throws InterruptedException {
        driver.findElement(By.cssSelector("#field-messenger-consultation > div > div > div > div.socials-input-triggers > button:nth-child(1) > svg > g > path:nth-child(1)")).click();
        Thread.sleep(4000);
    }
    @Test
    public void testViberChoosing() throws InterruptedException {
        driver.findElement(By.cssSelector("#field-messenger-consultation > div > div > div > div.socials-input-triggers > button:nth-child(2) > svg > rect")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("db")).sendKeys("+380631234567");
    }
    @Test
    public void testCourceChossing() throws InterruptedException {
        courceName(Cource.JAVA_BASIC);
        Thread.sleep(3000);
    }
    private void courceName(Cource cource){
        driver.findElement(By.className("listbox-btn_content")).click();
        WebElement element = driver.findElement(By.xpath("//ul[contains(@class,\"listbox_opt-list\") and contains(@role,\"listbox\")]"));
        List<WebElement> list = element.findElements(By.tagName("li"));
        for (WebElement webElement : list) {
            if (webElement.findElement(By.tagName("span")).getText().equals(cource.toString())) {
                webElement.findElement(By.tagName("span")).click();
            }
        }
    }
    @Test
    public void testPermissionsAccepting() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"form-consultation\"]/div[1]/footer/div[1]/label/span")).click();
        Thread.sleep(3000);
    }
}
