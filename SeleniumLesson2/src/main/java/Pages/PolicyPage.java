package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicyPage extends BasePage {

    @FindBy(xpath = "//section[contains(@class),'b-form-box-block')]")
    public WebElement kindOfInsurance;

    @FindBy(xpath = "//*[@class='b-button-block-center']//span[contains(text(), 'Оформить')]")
    public WebElement issueButton;

    public PolicyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectKindOfInsurance(String value) {
        kindOfInsurance.findElement(By.xpath("//*[@class='b-form-section']//div[contains(text(),'"
                + value + "')]")).click();
    }

    public void clickIssueButton() {
        issueButton.click();
    }


}