import Pages.CreateAccountPage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RegistrationTest extends BaseTest {

  @Test
  public void registrationSuccessful(){
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
    boardingPage.getSignInLink().click();
    assertThat(loginPage.isLoaded()).isTrue();
    loginPage.getRegistrationLink().click();
    assertThat(createAccountPage.isLoaded()).isTrue();
<<<<<<< HEAD
    createAccountPage.createAnAccount("Sikeres", "Teszt", "sikeresteszt+33@gmail.com", "test1234");
=======
    createAccountPage.createAnAccount("Sikeres", "Teszt", "sikeresteszt+31@gmail.com", "test1234");
>>>>>>> 1f9b5914c4e80b63c43d2ae8d700d9da82436098
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
