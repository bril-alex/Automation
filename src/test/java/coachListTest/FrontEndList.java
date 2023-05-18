package coachListTest;

import installation.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FrontEndList extends BaseClass {
    @BeforeClass
    public static void siteOpen() throws InterruptedException {
        driver.get("https://ithillel.ua");
        Thread.sleep(3000);
    }
    @Test
    public void A_test_courseChoosing() throws InterruptedException {
        driver.findElement(By.cssSelector("#body > div.site-wrapper > div.site-header.-no-logo.-kv > div.site-header_nav.site-nav > div > div > nav > ul > li:nth-child(2) > button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"coursesMenuControlPanel\"]/ul/li[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"coursesMenuMainContent\"]/div[3]/div/ul/li[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"block-202987\"]/div/ul/li[1]/a/div")).click();
        Thread.sleep(2000);
    }
    @Test
    public void B_test_verifyUrl() throws InterruptedException {
        String expectedURL = "https://ithillel.ua/courses/front-end-basic";
        String actualURL = driver.getCurrentUrl();
        assertEquals(expectedURL,actualURL);
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
    }
    @Test
    public void C_test_scrollPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("lazySectionCoaches")));
        Thread.sleep(3000);
    }
    @Test
    public void D_test_coaches() throws InterruptedException {
       driver.findElement(By.xpath("//*[@id=\"coachesShowAllButton\"]")).click();
       Thread.sleep(2000);
       List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'coach-list') and contains(@class, 'coaches_list') and contains(@class, 'coach-list_item') and contains(@class, 'coach-card') and contains(@class, 'coach-card_content') and contains(@class, 'coach-card_group') and contains(@class, 'coach-card_name')]"));
        for (WebElement element : elements) {
            String coachName = element.getText();
            System.out.println(coachName);
        }
    }

}
