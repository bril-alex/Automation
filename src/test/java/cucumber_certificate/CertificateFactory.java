package cucumber_certificate;

import installation.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CertificateFactory extends BaseClass {
    @FindBy(name = "certificate")
    WebElement searchField;
    @FindBy(id = "certificateCheckForm")
    WebElement checkFormMassage;
    WebDriver driver;

    public CertificateFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendNumber(String certificateNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click();
        searchField.sendKeys(certificateNumber);
        searchField.sendKeys(Keys.ENTER);
    }

    private boolean checkLinkCertificate() {

        return driver.getCurrentUrl().contains("view");
    }

    public boolean CheckForm() throws Exception {
        System.out.println(checkFormMassage.getAttribute("class"));

        int i = 0;
        boolean result=false;
        while (true) {
            if (checkLinkCertificate()) {
                result = true;
                break;
            }
            if (checkFormMassage.getAttribute("class").contains("invalid")) {
                result = false;
                break;
            }

            try {
                Thread.sleep(1000);
                i++;
                if (i > 10) {
                    throw new Exception("Out of time wait certificate checker");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
