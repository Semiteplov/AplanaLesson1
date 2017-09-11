package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class TravelInsurancePage extends BasePage {
    @FindBy(xpath = "//div[@class='sbrf-rich-wrapper']//img[contains(@src,'travel')]")
    WebElement issueButton;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public void issueTravel() {
        issueButton.click();
    }

    public void checkTitle() {
        assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle().toString());
    }

    public void scrollToIssueButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", issueButton);
    }
}
