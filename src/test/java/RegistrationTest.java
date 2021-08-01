import Pages.CreateAccountPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationTest extends BaseTest {

  @Test
  public void registrationSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
    boardingPage.getSignInLink().click();
    assertThat(loginPage.isLoaded()).isTrue();
    loginPage.getRegistrationLink().click();
    assertThat(createAccountPage.isLoaded()).isTrue();
    createAccountPage.createAnAccount("Sikeres", "Teszt", "sikeresteszt+22@gmail.com", "test1234");
    assertThat(boardingPage.getAccount().getText()).isEqualTo("Sikeres Teszt");
    boardingPage.getSignOutLink().click();
  }

  @Test
  public void registrationUnsuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
    boardingPage.getSignInLink().click();
    assertThat(loginPage.isLoaded()).isTrue();
    loginPage.getRegistrationLink().click();
    assertThat(createAccountPage.isLoaded()).isTrue();
    createAccountPage.createAnAccount("Sikertelen", "sikertelenteszt+0@gmail.com", "test1234");
    String value = createAccountPage.getLastNameField().getAttribute("required");
    assertThat(value).isEqualTo("true");
  }
}
