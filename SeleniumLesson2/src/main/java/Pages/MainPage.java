package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@class='sbrf-div-list-inner --area bp-area header_more_nav']")
    WebElement menuItems;

    @FindBy(xpath = "//*[@class='alt-menu-collapser__hidder']")
    WebElement menuInsurance;

    @FindBy(xpath = "//*[@class='region-list__name']")
    WebElement region;

    @FindBy(xpath = "//*[@class='region-list__modal-content']")
    WebElement regionList;

    @FindBy(xpath = "//*[@class='social__list']")
    WebElement socialList;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String itemName) {
        menuItems.findElement(By.xpath("//span[contains(@class,'multiline')]/*[contains(text(),'"
                + itemName + "')]")).click();
    }

    public void selectInsuranceItem(String itemName) {
        menuInsurance.findElement(By.xpath("//ul[@class='alt-menu-collapser__column']//a[contains(text(),'"
                + itemName + "')]")).click();
    }

    public void selectRegion(String value) {
        region.click();
        wait.until(ExpectedConditions.visibilityOf(regionList));
        regionList.findElement(By.xpath("//a[contains(text(),'" + value + "')]")).click();
    }

    protected void isElementExist(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    public void selectSocialIcon(String value) {
        socialList.findElement(By.xpath("//span[contains(@class, 'social__icon social__icon_type_" + value + "')]"));
    }
}