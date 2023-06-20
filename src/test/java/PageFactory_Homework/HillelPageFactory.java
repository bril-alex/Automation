package PageFactory_Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static installation.BaseClass.driver;

public class HillelPageFactory {
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    @FindBy(xpath = "//button[@data-dropdown-trigger='coursesMenu']")
    private WebElement courseMenu;
    @FindBy(xpath = "//button[@data-category='programming']")
    private WebElement courseProgramming;
    @FindBy(xpath = "//a[@href ='https://ithillel.ua/courses/front-end-basic']")
    private WebElement chooseFront;
    @FindBy(xpath = "//h1[@class='course-descriptor_header']")
    private WebElement courseTitle;
    @FindBy (xpath = "//span[@class='course-rating_average']")
    private WebElement courseRate;
    @FindBy (xpath = "//div[@class= 'programme']")
    private WebElement courseDescription;
    @FindBy(xpath = "//*[@id='coachesShowAllButton']")
    private WebElement allCoachesButton;
    @FindBy(xpath = "//p[@class='coach-card_name']")
    private List <WebElement> coachList;
    public void openCoursePage(){
        wait.until(ExpectedConditions.visibilityOf(courseMenu));
        courseMenu.click();
        wait.until(ExpectedConditions.visibilityOf(courseProgramming));
        courseProgramming.click();
        wait.until(ExpectedConditions.visibilityOf(chooseFront));
        chooseFront.click();
    }
    public WebElement getCourseTitle(){
        wait.until(ExpectedConditions.visibilityOf(courseTitle));
        return courseTitle;
    }
    public WebElement getCourseRate(){
        return courseRate;
    }
    public WebElement getCourseDescription(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class= 'programme']")));
        wait.until(ExpectedConditions.visibilityOf(courseDescription));
        System.out.println("Course Descriptions: \n");
        return courseDescription;
    }
    public int getCoachCount(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("lazySectionCoaches")));
        wait.until(ExpectedConditions.elementToBeClickable(allCoachesButton));
        allCoachesButton.click();
        System.out.println("Count of coaches: " + coachList.size());
        return coachList.size();
    }

    public List<String>getListCoachesNames(){
        List<String>coaches = new ArrayList<>();
        for (WebElement element : coachList) {
            String coachName = element.getText();
            System.out.println(coachName);
        }
        return coaches;
    }
}
