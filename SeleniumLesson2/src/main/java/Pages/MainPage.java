package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
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
        wait = new WebDriverWait(driver, 5, 1000);
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

    public void checkRegion(String value) {
        assertEquals("Нижегородская область", region.getText());
    }

    public void checkSocialItems() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", socialList);
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_fb']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_tw']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_yt']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_ins']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_vk']")));
        assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_ok']")));
    }
}