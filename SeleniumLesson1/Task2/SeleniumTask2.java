import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTask2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:/Users/Slava/Desktop/Drivers/chromedriver.exe");

    driver = new ChromeDriver();
    baseUrl = "http://www.sberbank.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSeleniumTask2() throws Exception {
    driver.get(baseUrl + "/ru/person");
    driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*//div/div/ul/li[5]/a/span")).click();
    driver.findElement(By.linkText("Страхование путешественников")).click();

    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    isElementPresent(By.xpath("//h1/.[text()='Страхование путешественников']"));

    driver.findElement(By.xpath("//a//*[text()='Оформить онлайн']")).click();
    driver.findElement(By.xpath("//p/a/img")).click();
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }

    WebElement element = driver.findElement(By.xpath("//*//section/section/section[2]/div[1]/div[1]/div"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    driver.findElement(By.xpath("//*[@id=\"views\"]/form/section/section/section[2]/div[1]/div[1]/div")).click();

    element = driver.findElement(By.xpath("//*[@id=\"views\"]/form/section/section/section[6]/span/span"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    driver.findElement(By.xpath("//*[@id=\"views\"]/form/section/section/section[6]/span/span")).click();
    driver.findElement(By.name("insured0_surname")).clear();
    driver.findElement(By.name("insured0_surname")).sendKeys("Ivanov");
    driver.findElement(By.name("insured0_name")).clear();
    driver.findElement(By.name("insured0_name")).sendKeys("Ivan");
    driver.findElement(By.xpath("//*//section/section[1]/div/insured-input/div/fieldset[4]/div/img")).click();
    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[5]/a")).click();
    driver.findElement(By.name("surname")).clear();
    driver.findElement(By.name("surname")).sendKeys("Петров");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Петр");
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys("Петрович");
    driver.findElement(By.xpath("//*//section/form/section/section[2]/div/fieldset[7]/div/img")).click();
    driver.findElement(By.xpath("//*//table/tbody/tr[1]/td[6]/a")).click();

    element = driver.findElement(By.xpath("//*//form/section/section[3]/div/fieldset[1]/div[1]/input"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    driver.findElement(By.name("passport_series")).clear();
    driver.findElement(By.name("passport_series")).sendKeys("1111");
    driver.findElement(By.name("passport_number")).clear();
    driver.findElement(By.name("passport_number")).sendKeys("111111");
    driver.findElement(By.xpath("//*//form/section/section[3]/div/fieldset[2]/div/img")).click();
    driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]/a")).click();
    driver.findElement(By.name("issuePlace")).clear();
    driver.findElement(By.name("issuePlace")).sendKeys("Афыв");
    driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[5]/div[1]/span[2]")).click();

    assertTrue(driver.findElement(By.xpath("//*[text()='Заполнены не все обязательные поля']")).isDisplayed());
    assertEquals("Ivanov", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
    assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
    assertEquals("Ivan", driver.findElement(By.name("insured0_name")).getAttribute("value"));
    assertEquals("Петров", driver.findElement(By.name("surname")).getAttribute("value"));
    assertEquals("Петр", driver.findElement(By.name("name")).getAttribute("value"));
    assertEquals("Петрович", driver.findElement(By.name("middlename")).getAttribute("value"));
    assertEquals("1111", driver.findElement(By.name("passport_series")).getAttribute("value"));
    assertEquals("111111", driver.findElement(By.name("passport_number")).getAttribute("value"));
    assertEquals("Афыв", driver.findElement(By.name("issuePlace")).getAttribute("value"));
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
