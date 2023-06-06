package PageFactory_Homework;

import installation.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import PageFactory_Homework.HillelPageFactory;
import static junit.framework.Assert.assertEquals;

public class PageTest extends BaseClass {
    static HillelPageFactory hillelPageFactory;
    @BeforeClass
    public static void openPage() throws InterruptedException {
        driver.get("https://ithillel.ua/");
        hillelPageFactory= PageFactory.initElements(driver, HillelPageFactory.class);
        //driver.wait(1000);
    }
    @Test
    public void checkStartPage() {
        assertEquals("https://ithillel.ua/", driver.getCurrentUrl());
    }
    @Test
    public void courseInformation(){
        hillelPageFactory.openCoursePage();
        assertEquals("https://ithillel.ua/courses/front-end-basic", driver.getCurrentUrl());
        hillelPageFactory.courseInformation();
    }
}
