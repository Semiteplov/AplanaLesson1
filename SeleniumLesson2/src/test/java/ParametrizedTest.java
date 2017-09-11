import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ParametrizedTest extends BaseTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"IVANOV", "IVAN", "11.22.1963", "Петров", "Петр",
                "Петровчи", "01.05.2001", "1111", "222222", "20.20.2014", "ААА"}
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public /* NOT private */ String insuredSurname;

    @Parameterized.Parameter(1)
    public /* NOT private */ String insuredName;

    @Parameterized.Parameter(2)
    public /* NOT private */ String insured0_birthDate;

    @Parameterized.Parameter(3)
    public /* NOT private */ String surname;

    @Parameterized.Parameter(4)
    public /* NOT private */ String name;

    @Parameterized.Parameter(5)
    public /* NOT private */ String middlename;

    @Parameterized.Parameter(6)
    public /* NOT private */ String birthDate;

    @Parameterized.Parameter(7)
    public /* NOT private */ String passport_series;

    @Parameterized.Parameter(8)
    public /* NOT private */ String passport_number;

    @Parameterized.Parameter(9)
    public /* NOT private */ String issueDate;

    @Parameterized.Parameter(10)
    public /* NOT private */ String issuePlace;

    @Ignore
    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/ru/person");
        driver.findElement(By.xpath("//span[contains(text(),'Застраховать себя')]")).click();
        driver.findElement(By.linkText("Страхование путешественников")).click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        isElementExist(By.xpath("//h1[text()='Страхование путешественников']"));

        driver.findElement(By.xpath("//*[text()='Оформить онлайн']")).click();
        driver.findElement(By.xpath("//div[@class='sbrf-rich-outer']//img")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.xpath("//*[contains(text(), 'Минимальная')]")).click();
        driver.findElement(By.xpath("//*[@class='b-button-block-center']//span[contains(text(), 'Оформить')]")).click();


        fillField(By.name("insured0_surname"), insuredSurname);
        fillField(By.name("insured0_name"), insuredName);
        fillField(By.name("insured0_birthDate"),insured0_birthDate);
        fillField(By.name("surname"), surname);
        fillField(By.name("name"), name);
        fillField(By.name("middlename"), middlename);
        fillField(By.name("birthDate"), birthDate);

        WebElement element = driver.findElement(By.xpath("//h3[contains(text(), 'Данные паспорта РФ')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        fillField(By.name("passport_series"), passport_series);
        fillField(By.name("passport_number"), passport_number);
        fillField(By.name("issueDate"), issueDate);
        fillField(By.name("issuePlace"), issuePlace);

        driver.findElement(By.xpath("//span[contains(text(), 'Продолжить')]")).click();

        isElementExist(By.xpath("//*[text()='Заполнены не все обязательные поля']"));

        checkFillField(insuredSurname, By.name("insured0_surname"));
        checkFillField(insuredName, By.name("insured0_name"));
        checkFillField(insured0_birthDate, By.name("insured0_birthDate"));
        checkFillField(surname, By.name("surname"));
        checkFillField(name, By.name("name"));
        checkFillField(middlename, By.name("middlename"));
        checkFillField(birthDate, By.name("birthDate"));
        checkFillField(passport_series, By.name("passport_series"));
        checkFillField(passport_number, By.name("passport_number"));
        checkFillField(issueDate, By.name("issueDate"));
        checkFillField(issuePlace, By.name("issuePlace"));


    }
}

