package coachListTest;

import installation.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class FrontEndList extends BaseClass {
    @BeforeClass
    public static void siteOpen() throws InterruptedException {
        driver.get("https://ithillel.ua");
        Thread.sleep(3000);
    }
    @Test
    public void courseChoosing() throws InterruptedException {
        driver.findElement(By.cssSelector("#body > div.site-wrapper > div.site-header.-no-logo.-kv > div.site-header_nav.site-nav > div > div > nav > ul > li:nth-child(2) > button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='coursesMenuControlPanel']/ul/li[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='coursesMenuMainContent']/div[3]/div/ul/li[1]/button")).click();
        driver.findElement(By.xpath("//*[@id='block-202987']/div/ul/li[1]/a/div")).click();
        Thread.sleep(2000);
        String expectedURL = "https://ithillel.ua/courses/front-end-basic";
        String actualURL = driver.getCurrentUrl();
        assertEquals(expectedURL,actualURL);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("lazySectionCoaches")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='coachesShowAllButton']")).click();
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//p[@class='coach-card_name']"));
        System.out.println(elements.size());
        for (WebElement element : elements) {
            String coachName = element.getText();
            System.out.println(coachName);
        }
    }
}

