import Pages.MainPage;
import Pages.PolicyPage;
import Pages.SendAppPage;
import Pages.TravelInsurancePage;
import org.junit.Ignore;
import org.junit.Test;

public class RefactoringTest extends BaseTest {

    @Test
    public void testMainPage() throws Exception {
        driver.get(baseUrl + "ru/person");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectRegion("Нижегородская область");
        mainPage.checkRegion("Нижегородская область");
        mainPage.checkSocialItems();
    }


    @Test
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "ru/person");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Застраховать себя");
        mainPage.selectInsuranceItem("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        travelInsurancePage.checkTitle();
        travelInsurancePage.issueTravel();


        PolicyPage policyPage = new PolicyPage(driver);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        policyPage.scrollToIssueButton();
        policyPage.scrollToInsurance();
        policyPage.selectKindOfInsurance("Минимальная");
        policyPage.clickIssueButton();

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField("Surname", "Ivanov");
        sendAppPage.fillField("Name", "Ivan");
        sendAppPage.fillField("Birthday", "01.01.1967");
        sendAppPage.fillField("Surname1", "Петров");
        sendAppPage.fillField("Name1", "Петр");
        sendAppPage.fillField("Middlename", "Петрович");
        sendAppPage.fillField("Birthday1", "02.02.1986");
        sendAppPage.fillField("Passport series", "1111");
        sendAppPage.fillField("Passport number", "111111");
        sendAppPage.fillField("Issue day", "11.11.1958");
        sendAppPage.fillField("Issue place", "QWER");

        sendAppPage.checkFillField("Ivanov", sendAppPage.insuredSurname);
        sendAppPage.checkFillField("Ivan", sendAppPage.insuredName);
        sendAppPage.checkFillField("01.01.1967", sendAppPage.insuredBirthDate);
        sendAppPage.checkFillField("Петров", sendAppPage.surname);
        sendAppPage.checkFillField("Петр", sendAppPage.name);
        sendAppPage.checkFillField("Петрович", sendAppPage.middlename);
        sendAppPage.checkFillField("02.02.1986", sendAppPage.birthDate);
        sendAppPage.checkFillField("1111", sendAppPage.passportSeries);
        sendAppPage.checkFillField("111111", sendAppPage.passportNumber);
        sendAppPage.checkFillField("11.11.1958", sendAppPage.issueDate);
        sendAppPage.checkFillField("QWER", sendAppPage.issuePlace);

        sendAppPage.clickIssueButton();
        sendAppPage.checkError();
    }
}
