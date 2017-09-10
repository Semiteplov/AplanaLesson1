package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public boolean checkTitle() {
        if(driver.getTitle().equals("Страхование путешественников"))
            return true;
        else
            return false;
    }
}
