package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class SendAppPage extends BasePage {

    @FindBy(name = "insured0_surname")
    public WebElement insuredSurname;

    @FindBy(name = "insured0_name")
    public WebElement insuredName;

    @FindBy(name = "insured0_birthDate")
    public WebElement insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//span[contains(text(), 'Продолжить')]")
    public WebElement issueButton;

    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillField(String fieldName, String value) throws NoSuchFieldException {
        switch (fieldName) {
            case "Surname":
                fillField(insuredSurname, value);
                break;
            case "Name":
                fillField(insuredName, value);
                break;
            case "Birthday":
                fillField(insuredBirthDate, value);
                break;
            case "Surname1":
                fillField(surname, value);
                break;
            case "Name1":
                fillField(name, value);
                break;
            case "Middlename":
                fillField(middlename, value);
                break;
            case "Birthday1":
                fillField(birthDate, value);
                break;
            case "Passport series":
                fillField(passportSeries, value);
                break;
            case "Passport number":
                fillField(passportNumber, value);
                break;
            case "Issue day":
                fillField(issueDate, value);
                break;
            case "Issue place":
                fillField(issuePlace, value);
                break;
            default:
                throw new NoSuchFieldException();
        }
    }

    public void clickIssueButton() {
        issueButton.click();
    }

    public void checkError() {
        assertTrue("There is no error",
                driver.findElement(By.xpath("//div[@class='b-form-center-pos b-form-error-message']")).isDisplayed());
    }
}