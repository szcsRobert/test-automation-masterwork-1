import Pages.CreateAccountPage;
import Pages.LoginPage;
import Pages.TermsAndConditionsOfUsePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TermsAndConditionsTest extends BaseTest {
  @Test
  public void openTermsAndConditionsLinkAndClickCheckbox() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
    TermsAndConditionsOfUsePage termsAndConditionsOfUsePage = PageFactory.initElements(driver, TermsAndConditionsOfUsePage.class);
    boardingPage.getSignInLink().click();
    assertThat(loginPage.isLoaded()).isTrue();
    loginPage.getRegistrationLink().click();
    assertThat(createAccountPage.isLoaded()).isTrue();
    createAccountPage.getTermsAndConditionsLink().click();
    Set<String> handlesSet = driver.getWindowHandles();
    List<String> handlesList = new ArrayList<>(handlesSet);
    driver.switchTo().window(handlesList.get(1));
    assertThat(termsAndConditionsOfUsePage.isLoaded()).isTrue();
    assertThat(termsAndConditionsOfUsePage.getHeader().getText()).isEqualTo("Terms and conditions of use");
    driver.close();
    driver.switchTo().window(handlesList.get(0));
    createAccountPage.getTermsAndConditionsCheckbox().click();
    assertThat(createAccountPage.getTermsAndConditionsCheckbox().isEnabled()).isTrue();
  }
}
