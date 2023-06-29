package certificate_steps;

import cucumber_certificate.CertificateFactory;
import installation.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static junit.framework.Assert.assertEquals;

public class CertificateSteps extends BaseClass {
    static {
        if(driver ==null){
            BaseClass.createDriver();
        }
    }
    CertificateFactory certificateFactory= new CertificateFactory(driver);
    @Before
    public void pageOpening(){
        driver.get("https://certificate.ithillel.ua/");
        assertEquals("https://certificate.ithillel.ua/",driver.getCurrentUrl());
    }
    @When("I send certificate {string}")
    public void iSendCertificate(String certificateNumber) {
        certificateFactory.sendNumber(certificateNumber);
    }
    @Then("Certificate verification - {string}")
    public void certificateVerification(String expected) throws Exception {
        boolean actualResult = certificateFactory.CheckForm();
        boolean expectedResult = Boolean.parseBoolean(expected);
        assertEquals(expectedResult, actualResult);
    }
}
