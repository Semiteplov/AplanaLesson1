import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.RETURN;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTask1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:/Users/Slava/Desktop/Drivers/chromedriver.exe");

    driver = new ChromeDriver();
    baseUrl = "https://www.sberbank.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumTask1() throws Exception {
    driver.get(baseUrl + "/ru/person");
    driver.findElement(By.cssSelector("span.region-list__arrow")).click();

    Wait<WebDriver> wait = new WebDriverWait(driver, 1, 3000);
    wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(By.xpath("//*[@class='region-list__modal-caption']"))));

    driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div/div[1]/div/div[1]/input")).
            sendKeys("Нижегородская область");

    wait = new WebDriverWait(driver, 2, 1000);
    wait.until(ExpectedConditions.visibilityOf(
              driver.findElement(By.xpath("/html/body/div[7]/div/div/div"))));

    driver.findElement(By.xpath("/html/body/div[7]/div/div/div")).click();
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    assertTrue(isElementPresent(By.xpath("//*[text()='Нижегородская область']")));

    WebElement element = driver.findElement(By.xpath("//*[@class='social social_section_person']//div"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_fb']")));
    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_tw']")));
    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_yt']")));
    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_ins']")));
    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_vk']")));
    assertTrue(isElementPresent(By.xpath("//*[@class='social__icon social__icon_type_ok']")));

  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
