import Pages.LoginPage;
import Pages.MyAccountPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest {

  @Test
  public void loginSuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    boardingPage.getSignInLink().click();
    assertThat(loginPage.isLoaded()).isTrue();
    loginPage.signIn("sikeresteszt@gmail.com", "test1234");
    assertThat(myAccountPage.isLoaded()).isTrue();
    assertThat(myAccountPage.getHeader().getText()).isEqualTo("Your account");
    assertThat(boardingPage.getAccount().getText()).isEqualTo("Sikeres Teszt");
    boardingPage.getSignOutLink().click();
  }

  @Test
  public void loginUnsuccessful() {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    boardingPage.getSignInLink().click();
    loginPage.signIn("sikertelenteszt@gmail.com", "test1234");
    assertThat(loginPage.getAuthenticationAlert().isDisplayed()).isTrue();
    assertThat(loginPage.getAuthenticationAlert().getText()).isEqualTo("Authentication failed.");
  }
}
